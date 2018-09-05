package com.hongri.model.mvc.controller;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.hongri.model.R;
import com.hongri.model.mvc.model.MVCHttpRequestModel;
import com.hongri.model.mvc.model.MVCRequestCallback;

/**
 * MVC框架--（Model--View--Controller）
 * 该Activity属于Controller层
 *
 * @author hongri
 */
public class MVCActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRequest;
    private ImageView iv;
    private MVCHttpRequestModel mvcHttpRequestModel;
    private static final String URL
        = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536027337403&di"
        + "=f94b0a842cef7eeb2be2cba6612fe034&imgtype=0&src=http%3A%2F%2Fwww.officedoyen"
        + ".com%2Fuploads%2Fallimg%2F140929%2F1-140929230255201.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * xml文件属于理论上的View层
         */
        setContentView(R.layout.activity_mvcpattern);

        mvcHttpRequestModel = new MVCHttpRequestModel();

        btnRequest = findViewById(R.id.btnRequest);
        iv = findViewById(R.id.iv);
        btnRequest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRequest:
                mvcHttpRequestModel.onHttpRequest(URL, new MVCRequestCallback() {

                    @Override
                    public void onSuccess(Object successData) {
                        if (successData != null) {
                            iv.setImageBitmap((Bitmap)successData);
                        }
                    }

                    @Override
                    public void onFailure(Object successData) {
                        Toast.makeText(MVCActivity.this, successData.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                break;
            default:
                break;
        }
    }
}
