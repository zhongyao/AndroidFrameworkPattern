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
import com.hongri.model.mvc.model.OnRequestBitmapListener;

/**
 * @author hongri
 */
public class MVCPatternActivity extends AppCompatActivity implements View.OnClickListener {

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
                mvcHttpRequestModel.onHttpRequestBitmap(URL, new OnRequestBitmapListener() {

                    @Override
                    public void onSuccess(final Bitmap bitmap) {
                        if (bitmap != null) {
                            iv.setImageBitmap(bitmap);
                        }
                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(MVCPatternActivity.this, "请求失败", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            default:
                break;
        }
    }
}
