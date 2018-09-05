package com.hongri.model.mvvm.model;

import android.os.Handler;
import android.text.TextUtils;
import com.hongri.model.mvvm.viewmodel.MVVMLoadDataCallback;

/**
 * @author zhongyao
 * @date 2018/9/3
 * Model层
 */

public class MVVMDataModel {
    public String data;

    public MVVMDataModel() {
        this.data = "初始数据";
    }

    public void executeRequestData(final MVVMLoadDataCallback callback) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data = "请求数据成功";
                if (!TextUtils.isEmpty(data)) {
                    callback.onSuccess(data);
                } else {
                    data = "请求数据失败";
                    callback.onFailure(data);
                }
            }
        }, 1000);

    }
}
