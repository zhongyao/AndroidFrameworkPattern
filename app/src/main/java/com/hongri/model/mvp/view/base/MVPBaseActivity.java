package com.hongri.model.mvp.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.hongri.model.R;
import com.hongri.model.util.LoadingDialog;

/**
 * @author hongri
 * BaseActivity用于进行View层的通用的初始化及UI展示工作
 */
public class MVPBaseActivity extends AppCompatActivity implements MVPBaseViewInterface {

    /**
     * 页面通用LoadingDialog
     */
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpbase);
        loadingDialog = new LoadingDialog(this, R.style.LoadingTheme);
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
