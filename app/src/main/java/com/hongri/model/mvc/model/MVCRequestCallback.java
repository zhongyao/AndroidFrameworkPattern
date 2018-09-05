package com.hongri.model.mvc.model;

/**
 * @author zhongyao
 * @date 2018/9/4
 * 请求回调接口
 */

public interface MVCRequestCallback<T extends Object> {

    /**
     * 请求成功
     *
     * @param successData
     */
    void onSuccess(T successData);

    /**
     * 请求失败
     *
     * @param failureData
     */
    void onFailure(T failureData);
}
