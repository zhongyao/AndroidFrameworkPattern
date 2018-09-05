package com.hongri.model.mvvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.databinding.library.baseAdapters.BR;
import com.hongri.model.mvvm.model.MVVMDataModel;

/**
 * @author zhongyao
 * @date 2018/9/3
 *
 * ViewModel层
 */

public class MVVMDataViewModel extends BaseObservable implements MVVMLoadDataCallback {
    private MVVMDataModel model;

    public MVVMDataViewModel() {
        model = new MVVMDataModel();
    }

    /**
     * Important
     * 必须添加@Bindable注释
     *
     * @return
     */
    @Bindable
    public String getData() {
        return model.data;
    }

    public void requestData() {
        model.executeRequestData(this);
    }

    @Override
    public void onSuccess(Object successData) {
        notifyPropertyChanged(BR.data);
    }

    @Override
    public void onFailure(Object failureData) {

    }
}
