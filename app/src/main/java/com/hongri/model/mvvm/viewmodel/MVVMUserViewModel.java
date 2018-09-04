package com.hongri.model.mvvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.databinding.library.baseAdapters.BR;
import com.hongri.model.mvvm.model.MVVMUserModel;

/**
 * @author zhongyao
 * @date 2018/9/3
 */

public class MVVMUserViewModel extends BaseObservable implements MVVMLoadDataCallback {
    private MVVMUserModel model;

    public MVVMUserViewModel() {
        model = new MVVMUserModel();
    }

    /**
     * 必须添加@Bindable注释
     * @return
     */
    @Bindable
    public String getName() {
        return model.name;
    }

    public void loadUserData() {
        model.loadUserDataFromNet(this);
    }

    @Override
    public void onSuccess() {
        notifyPropertyChanged(BR.name);
    }

    @Override
    public void onFailure() {

    }
}
