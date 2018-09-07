package com.hongri.model.mvvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.hongri.model.BR;
import com.hongri.model.mvvm.model.MVVMDataModel;

/**
 * @author zhongyao
 * @date 2018/9/3
 */

public class MVVMDataViewModel extends BaseObservable implements MVVMLoadDataCallback {
    private MVVMDataModel model;

    public MVVMDataViewModel() {
        model = new MVVMDataModel();
    }

    /**
     * 必须添加@Bindable注释
     * @return
     */
    @Bindable
    public String getData() {
        return model.mData;
    }

    public void loadUserData() {
        model.requestData(this);
    }

    @Override
    public void onSuccess() {
        notifyPropertyChanged(BR.data);
    }

    @Override
    public void onFailure() {

    }
}
