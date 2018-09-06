package com.hongri.model.mvp.model;

import android.os.Handler;
import android.text.TextUtils;
import com.hongri.model.mvp.model.base.MVPBaseModel;
import com.hongri.model.mvp.presenter.MVPLoadDataCallback;

/**
 * @author hongri
 * @date 2018/9/3
 *
 * Model层
 */

public class MVPDataModel extends MVPBaseModel {
    public String data;

    @Override
    public void executeGetRequest(String url, final MVPLoadDataCallback callback) {
        /**
         * 模拟网络请求耗时操作
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data = "请求服务端数据成功";
                if (!TextUtils.isEmpty(data)) {
                    callback.onSuccess(data);
                } else {
                    data = "请求服务端数据失败";
                    callback.onFailure(data);
                }
            }
        }, 1000);
    }
}
