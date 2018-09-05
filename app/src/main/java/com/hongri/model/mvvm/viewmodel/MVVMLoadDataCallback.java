package com.hongri.model.mvvm.viewmodel;

/**
 * @author zhongyao
 * @date 2018/9/3
 */

public interface MVVMLoadDataCallback<T extends Object> {
    /**
     * 请求成功
     * @param successData
     */
    void onSuccess(T successData);

    /**
     * 请求失败
     * @param failureData
     */
    void onFailure(T failureData);
}
