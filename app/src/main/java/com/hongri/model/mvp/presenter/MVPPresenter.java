package com.hongri.model.mvp.presenter;

import com.hongri.model.mvp.model.MVPUserModel;
import com.hongri.model.mvp.view.MVPBaseInterface;

/**
 * @author zhongyao
 * @date 2018/9/3
 *
 * Presenter
 */

public class MVPPresenter implements MVPLoadDataCallback {
    private MVPBaseInterface view;
    private MVPUserModel model;

    public MVPPresenter(MVPBaseInterface view) {
        this.view = view;
        this.model = new MVPUserModel();
    }

    public void loadUserData() {
        this.model.loadUserDataFromNet(this);
    }

    @Override
    public void onSuccess() {
        view.updateName(model.name);
    }

    @Override
    public void onFailure() {
        view.updateName("name加载失败...");
    }
}
