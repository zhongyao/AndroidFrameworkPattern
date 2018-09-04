package com.hongri.model.mvc.model;

/**
 * @author zhongyao
 * @date 2018/9/4
 */

public interface MVCHttpRequestInterface {
    void onHttpRequestBitmap(String url, OnRequestBitmapListener listener);
}
