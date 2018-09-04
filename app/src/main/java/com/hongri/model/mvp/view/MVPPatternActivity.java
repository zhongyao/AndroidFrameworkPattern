package com.hongri.model.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.hongri.model.R;
import com.hongri.model.mvp.presenter.MVPPresenter;

/**
 * @author hongri
 *
 *         View
 */
public class MVPPatternActivity extends AppCompatActivity implements MVPViewInterface, OnClickListener {

    private Button btnName;
    private TextView tvName;
    private MVPPresenter mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvppattern);

        mvpPresenter = new MVPPresenter();
        mvpPresenter.attachView(this);

        btnName = findViewById(R.id.btnName);
        tvName = findViewById(R.id.tvName);

        btnName.setOnClickListener(this);
    }

    @Override
    public void showData(String name) {
        tvName.setText(name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnName:
                mvpPresenter.loadUserData();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null){
            mvpPresenter.detachView();
        }
    }
}
