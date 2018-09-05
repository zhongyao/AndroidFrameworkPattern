package com.hongri.model.mvp.model;

import android.os.Handler;
import com.hongri.model.mvp.model.base.MVPBaseModel;
import com.hongri.model.mvp.presenter.MVPLoadDataCallback;

/**
 * @author hongri
 * @date 2018/9/3
 *
 * Model
 */

public class MVPUserModel extends MVPBaseModel {
    public String name;

    @Override
    public void execute(final MVPLoadDataCallback callback) {
        /**
         * 模拟网络请求耗时操作
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name = "红日";
                callback.onSuccess(name);
            }
        }, 1000);
    }
}
