package com.hongri.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.hongri.model.mvc.controller.MVCPatternActivity;
import com.hongri.model.mvp.view.MVPActivity;
import com.hongri.model.mvvm.view.MVVMPatternActivity;

/**
 * @author hongri
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMVC;
    private Button btnMVP;
    private Button btnMVVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMVC = findViewById(R.id.btnMVC);
        btnMVP = findViewById(R.id.btnMVP);
        btnMVVM = findViewById(R.id.btnMVVM);

        btnMVC.setOnClickListener(this);
        btnMVP.setOnClickListener(this);
        btnMVVM.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMVC:
                Intent intentMVC = new Intent(this, MVCPatternActivity.class);
                startActivity(intentMVC);
                break;
            case R.id.btnMVP:
                Intent intentMVP = new Intent(this, MVPActivity.class);
                startActivity(intentMVP);
                break;
            case R.id.btnMVVM:
                Intent intentMVVM = new Intent(this, MVVMPatternActivity.class);
                startActivity(intentMVVM);
                break;
            default:
                break;
        }
    }
}
