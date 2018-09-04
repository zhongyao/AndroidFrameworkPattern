package com.hongri.model.mvp.presenter;

import com.hongri.model.mvp.model.MVPUserModel;
import com.hongri.model.mvp.view.MVPViewInterface;

/**
 * @author zhongyao
 * @date 2018/9/3
 *
 * Presenter
 */

public class MVPPresenter implements MVPLoadDataCallback {
    private MVPViewInterface mView;
    private MVPUserModel model;

    public MVPPresenter() {
        model = new MVPUserModel();
    }

    /**
     * 绑定mView，一般在初始化中调用该方法
     */
    public void attachView(MVPViewInterface view) {
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

    public void loadUserData() {
        this.model.loadUserDataFromNet(this);
    }

    @Override
    public void onSuccess() {
        if (isViewAttached()) {
            mView.showData(model.name);
        }
    }

    @Override
    public void onFailure() {
        if (isViewAttached()) {
            mView.showData("name加载失败...");
        }
    }
}
