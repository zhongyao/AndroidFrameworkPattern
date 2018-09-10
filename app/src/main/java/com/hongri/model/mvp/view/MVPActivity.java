package com.hongri.model.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.hongri.model.R;
import com.hongri.model.mvp.bean.MVPDataInfo;
import com.hongri.model.mvp.presenter.MVPPresenter;
import com.hongri.model.mvp.util.ParseJsonUtil;
import com.hongri.model.mvp.view.base.MVPBaseActivity;

/**
 * MVP(Model--View--Presenter)框架模式--参考：http://www.jcodecraeer.com/a/anzhuokaifa/2017/1020/8625.html
 *
 * @author hongri
 *
 * View层
 */
public class MVPActivity extends MVPBaseActivity implements MVPViewInterface, OnClickListener {

    private Button btnName;
    private TextView tvData;
    private MVPPresenter mvpPresenter;
    private String requestUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvppattern);

        mvpPresenter = new MVPPresenter();
        mvpPresenter.attachView(this);

        btnName = findViewById(R.id.btnName);
        tvData = findViewById(R.id.tvData);

        btnName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnName:
                tvData.setText("初始数据");
                mvpPresenter.requestData(requestUrl);
                break;
            default:
                break;
        }
    }

    @Override
    public void showSuccessData(String data) {
        MVPDataInfo dataInfo = ParseJsonUtil.parseJSONData(data);
        tvData.setText(
            "姓名：" + dataInfo.getmName() + "\n" + "性别：" + dataInfo.getmGender() + "\n" + "年龄：" + dataInfo.getmAge());
    }

    @Override
    public void showFailureData(String data) {
        tvData.setText(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}