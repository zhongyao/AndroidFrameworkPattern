package com.hongri.model.mvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.hongri.model.R;
import com.hongri.model.databinding.ActivityMvvmpatternBinding;
import com.hongri.model.mvvm.viewmodel.MVVMUserViewModel;

/**
 * @author hongri
 */
public class MVVMPatternActivity extends AppCompatActivity {

    private MVVMUserViewModel userViewModel;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmpatternBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmpattern);
        userViewModel = new MVVMUserViewModel();
        binding.setUserViewModel(userViewModel);
        binding.setHandlers(this);

        tvName = binding.tvName;

    }

    public void onClickShowToastName(View view) {
        Toast.makeText(this, tvName.getText().toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickLoadData(View view) {
        userViewModel.loadUserData();
    }
}
