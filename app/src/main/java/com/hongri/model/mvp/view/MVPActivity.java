package com.hongri.model.mvp.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.hongri.model.R;
import com.hongri.model.mvp.bean.MVPDataInfo;
import com.hongri.model.mvp.presenter.MVPDataPresenter;
import com.hongri.model.mvp.util.ParseJsonUtil;
import com.hongri.model.mvp.view.base.MVPBaseActivity;

/**
 * MVP(Model--View--Presenter)框架模式--参考：http://www.jcodecraeer.com/a/anzhuokaifa/2017/1020/8625.html
 *
 * @author hongri
 *
 *         此Activity属于业务View层
 */
public class MVPActivity extends MVPBaseActivity implements MVPViewInterface, OnClickListener {

    private Button btnName;
    private TextView tvData;
    private ImageView iv;
    private MVPDataPresenter mvpDataPresenter;
    private String requestUrl = "";
    private String imageUrl
        = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536172342134&di"
        + "=a60a404882ac53f1425f9e4b2ef87c2c&imgtype=0&src=http%3A%2F%2Fyouimg1.c-ctrip"
        + ".com%2Ftarget%2Ffd%2Ftg%2Fg2%2FM00%2F1C%2F79%2FCghzf1Vr9wSAY9WdADLfAfZVKbo557.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvppattern);

        mvpDataPresenter = new MVPDataPresenter();
        mvpDataPresenter.attachView(this);

        btnName = findViewById(R.id.btnName);
        tvData = findViewById(R.id.tvData);
        iv = findViewById(R.id.iv);

        btnName.setOnClickListener(this);
        iv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnName:
                tvData.setText("初始数据");
                mvpDataPresenter.requestData(requestUrl);
                break;
            case R.id.iv:
                mvpDataPresenter.requestFile(imageUrl);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpDataPresenter != null) {
            mvpDataPresenter.detachView();
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
        tvData.setText("获取数据失败");
    }

    @Override
    public void showSuccessBitmap(Bitmap bitmap) {
        iv.setImageBitmap(bitmap);
    }

    @Override
    public void showFailureBitmap(Bitmap bitmap) {
        iv.setImageBitmap(null);
    }
}
