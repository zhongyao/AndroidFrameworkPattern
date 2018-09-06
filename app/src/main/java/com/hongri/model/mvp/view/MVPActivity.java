package com.hongri.model.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.hongri.model.R;
<<<<<<< HEAD
import com.hongri.model.mvp.presenter.MVPPresenter;
=======
import com.hongri.model.mvp.bean.MVPDataInfo;
import com.hongri.model.mvp.presenter.MVPDataPresenter;
import com.hongri.model.mvp.util.ParseJsonUtil;
>>>>>>> develop
import com.hongri.model.mvp.view.base.MVPBaseActivity;

/**
 * MVP(Model--View--Presenter)框架模式--参考：http://www.jcodecraeer.com/a/anzhuokaifa/2017/1020/8625.html
 *
 * @author hongri
 *
 * 此Activity属于业务View层
 */
public class MVPActivity extends MVPBaseActivity implements MVPViewInterface, OnClickListener {

    private Button btnName;
    private TextView tvData;
<<<<<<< HEAD
    private MVPPresenter mvpPresenter;
    private String URL = "";
=======
    private ImageView iv;
    private MVPDataPresenter mvpDataPresenter;
    private String requestUrl = "";
    private String imageUrl
        = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536172342134&di"
        + "=a60a404882ac53f1425f9e4b2ef87c2c&imgtype=0&src=http%3A%2F%2Fyouimg1.c-ctrip"
        + ".com%2Ftarget%2Ffd%2Ftg%2Fg2%2FM00%2F1C%2F79%2FCghzf1Vr9wSAY9WdADLfAfZVKbo557.jpg";
>>>>>>> develop

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvppattern);

<<<<<<< HEAD
        mvpPresenter = new MVPPresenter();
        mvpPresenter.attachView(this);
=======
        mvpDataPresenter = new MVPDataPresenter();
        mvpDataPresenter.attachView(this);
>>>>>>> develop

        btnName = findViewById(R.id.btnName);
        tvData = findViewById(R.id.tvData);

        btnName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnName:
                tvData.setText("初始数据");
<<<<<<< HEAD
                mvpPresenter.requestData(URL);
=======
                mvpDataPresenter.requestData(requestUrl);
                break;
            case R.id.iv:
                mvpDataPresenter.requestFile(imageUrl);
>>>>>>> develop
                break;
            default:
                break;
        }
    }

    @Override
<<<<<<< HEAD
    public void showSuccessData(Object data) {
        tvData.setText(data.toString());
=======
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

>>>>>>> develop
    }

    @Override
    public void showFailureData(String data) {
        tvData.setText("获取数据失败");
    }

    @Override
<<<<<<< HEAD
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
=======
    public void showSuccessBitmap(Bitmap bitmap) {
        iv.setImageBitmap(bitmap);
    }

    @Override
    public void showFailureBitmap(Bitmap bitmap) {
        iv.setImageBitmap(null);
>>>>>>> develop
    }
}
