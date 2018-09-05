package com.hongri.model.mvp.presenter.base;

import com.hongri.model.mvp.view.base.MVPBaseViewInterface;

/**
 * @author zhongyao
 * @date 2018/9/4
 */

public class MVPBasePresenter<V extends MVPBaseViewInterface> {

    public V mView;

    /**
     * 绑定mView，一般在初始化中调用该方法
     */
    public void attachView(V view) {
        mView = view;
    }

    /**
     * 销毁mView，一般在onDestroy方法中调用
     */
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }

    /**
     * 是否与mView建立联系
     * 每次调用业务方请求的时候都要先调用此方法检查是否与mView建立联系
     */
    public boolean isViewAttached() {
        return mView != null;
    }

    /**
     * 获取连接的mView
     */
    public V getAttachView() {
        return mView;
    }
}
