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

    public String data = "";

    @Override
    public void executeGetRequest(String url, final MVPLoadDataCallback callback) {
        /**
         * 模拟网络请求耗时操作
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /**
                 * 从服务端请求回来的字符串数据：
                 * 为了增加通用性，建议以请求回来的原有数据返回给View层，由View层做具体的数据解析、UI展示处理
                 */
                data = "{\n"
                    + "  \"mData\":\"红日\",\n"
                    + "  \"gender\": \"男士\",\n"
                    + "  \"age\":18\n"
                    + "}";
                if (!TextUtils.isEmpty(data)) {
                    callback.onSuccess(data);
                } else {
                    data = "数据获取失败";
                    callback.onFailure(data);
                }
            }
        }, 1000);
    }
}
