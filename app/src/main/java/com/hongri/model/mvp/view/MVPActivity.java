package com.hongri.model.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.hongri.model.R;
import com.hongri.model.mvp.presenter.MVPPresenter;
import com.hongri.model.mvp.view.base.MVPBaseActivity;
import com.hongri.model.util.LoadingDialog;

/**
 * @author hongri
 *
 *         View
 */
public class MVPActivity extends MVPBaseActivity implements MVPViewInterface, OnClickListener {

    private Button btnName;
    private Button btnTest;
    private TextView tvName;
    private MVPPresenter mvpPresenter;
    private LoadingDialog loadingDialog;
    private String URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvppattern);

        mvpPresenter = new MVPPresenter();
        mvpPresenter.attachView(this);

        loadingDialog = new LoadingDialog(this, R.style.LoadingTheme);

        btnName = findViewById(R.id.btnName);
        btnTest = findViewById(R.id.btnTest);
        tvName = findViewById(R.id.tvName);


        btnName.setOnClickListener(this);
        btnTest.setOnClickListener(this);
    }

    @Override
    public void showData(String name) {
        tvName.setText(name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnName:
                tvName.setText("name");
                mvpPresenter.loadUserData(URL);
                break;
            case R.id.btnTest:
                loadingDialog.showLoading();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

    @Override
    public void showLoading() {
        if (loadingDialog != null) {
            loadingDialog.showLoading();
        }
    }

    @Override
    public void dismissLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismissLoading();
        }
    }
}
