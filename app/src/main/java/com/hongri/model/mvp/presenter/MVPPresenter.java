package com.hongri.model.mvp.presenter;

import com.hongri.model.mvp.model.MVPDataModel;
import com.hongri.model.mvp.presenter.base.MVPBasePresenter;
import com.hongri.model.mvp.view.MVPViewInterface;
import com.hongri.model.util.Token;

/**
 * @author zhongyao
 * @date 2018/9/3
 *
 * Presenter
 */

public class MVPPresenter extends MVPBasePresenter<MVPViewInterface> implements MVPLoadDataCallback {

    public void loadUserData(String url) {
        getAttachView().showLoading();
        MVPDataModel.request(Token.API_USER_DATA).params(url).execute(this);
    }

    @Override
    public void onSuccess(Object successData) {
        if (isViewAttached()) {
            getAttachView().dismissLoading();
            getAttachView().showData(successData.toString());
        }
    }

    @Override
    public void onFailure(Object errorData) {
        if (isViewAttached()) {
            getAttachView().dismissLoading();
            getAttachView().showData(errorData.toString());
        }
    }
}
