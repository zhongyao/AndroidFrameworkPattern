package com.hongri.model.mvp.model.base;

import java.util.Map;

import com.hongri.model.mvp.presenter.MVPLoadDataCallback;

/**
 * @author hongri
 * @date 2018/9/5
 */

public abstract class MVPBaseModel {

    protected String[] mParams;

    /**
     * 设置数据请求参数
     *
     * @param args 参数数组
     */
    public MVPBaseModel setParams(String... args) {
        mParams = args;
        return this;
    }

    /***
     * 执行Get网络请求
     * @param url
     * @param callback
     */
    public abstract void executeGetRequest(String url, MVPLoadDataCallback callback);

    /**
     * 执行Post网络请求
     *
     * @param url
     * @param params
     * @param callback
     */
    protected void executePostRequest(String url, Map params, MVPLoadDataCallback callback) {

    }
}
