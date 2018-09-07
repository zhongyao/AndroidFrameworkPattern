package com.hongri.model.mvc.model;

/**
 * @author hongri
 * @date 2018/9/4
 */

public interface MVCHttpRequestInterface {
    /**
     * 网络请求方法
     * @param url
     * @param listener
     */
    void onHttpRequest(String url, MVCRequestCallback listener);
}
