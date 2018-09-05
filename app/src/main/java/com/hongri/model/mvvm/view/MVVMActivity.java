package com.hongri.model.mvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.hongri.model.R;
import com.hongri.model.databinding.ActivityMvvmpatternBinding;
import com.hongri.model.mvvm.viewmodel.MVVMDataViewModel;

/**
 * 参考：https://www.jianshu.com/p/7ee9bbcb184c
 * MVVM框架模式--（Model--View--ViewModel）
 * @author hongri
 * 该Activity属于View层
 */
public class MVVMActivity extends AppCompatActivity {

    private MVVMDataViewModel userViewModel;
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmpatternBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmpattern);
        userViewModel = new MVVMDataViewModel();
        binding.setUserViewModel(userViewModel);
        binding.setHandlers(this);

        tvData = binding.tvData;

    }

    public void onClickShowToastData(View view) {
        Toast.makeText(this, tvData.getText().toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRequestData(View view) {
        userViewModel.requestData();
    }
}
