package com.hongri.model.mvvm.model;

import com.hongri.model.mvvm.viewmodel.MVVMLoadDataCallback;

/**
 * @author hongri
 * @date 2018/9/3
 * Model层
 */

public class MVVMDataModel {
    public String mData;

    public MVVMDataModel() {
        this.mData = "初始数据";
    }

    public void requestData(MVVMLoadDataCallback callback) {
        this.mData = "数据请求成功";
        callback.onSuccess();
    }
}
