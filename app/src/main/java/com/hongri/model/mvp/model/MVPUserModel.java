package com.hongri.model.mvp.model;

import com.hongri.model.mvp.presenter.MVPLoadDataCallback;

/**
 * @author zhongyao
 * @date 2018/9/3
 *
 * Model
 */

public class MVPUserModel {
    public String name;

    public MVPUserModel() {
        this.name = "";
    }

    public void loadUserDataFromNet(MVPLoadDataCallback callback) {
        this.name = "红日";
        callback.onSuccess();
    }
}
