package com.hongri.model.mvvm.model;

import com.hongri.model.mvvm.viewmodel.MVVMLoadDataCallback;

/**
 * @author zhongyao
 * @date 2018/9/3
 */

public class MVVMUserModel {
    public String name;

    public MVVMUserModel() {
        this.name = "oooo";
    }

    public void loadUserDataFromNet(MVVMLoadDataCallback callback) {
        this.name = "红日";
        callback.onSuccess();
    }
}
