package com.hongri.model.mvp.presenter;

/**
 * @author zhongyao
 * @date 2018/9/3
 */

public interface MVPLoadDataCallback<T> {
    /**
     * 这里引入泛型的概念--可以根据请求数据类型的不同设置为不同类型的参数
     *
     * @param successData
     */
    void onSuccess(T successData);

    void onFailure(T errorData);
}
