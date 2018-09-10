package com.hongri.model.mvp.presenter;

/**
 * @author hongri
 * @date 2018/9/3
 */

public interface MVPLoadDataCallback {

    /**
     * 成功回调，更新UI
     * @param successData
     */
    void onSuccess(String successData);

    /**
     * 失败回调，展示失败提示
     * @param errorData
     */
    void onFailure(String errorData);

}
