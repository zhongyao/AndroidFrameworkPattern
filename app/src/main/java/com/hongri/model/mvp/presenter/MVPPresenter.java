package com.hongri.model.mvp.presenter;

import com.hongri.model.mvp.model.MVPDataModelManager;
import com.hongri.model.mvp.model.MVPDataModel;
import com.hongri.model.mvp.presenter.base.MVPBasePresenter;
import com.hongri.model.mvp.view.MVPViewInterface;

/**
 * @author zhongyao
 * @date 2018/9/3
 *
 * Presenter层
 */

public class MVPPresenter extends MVPBasePresenter<MVPViewInterface> implements MVPLoadDataCallback {

    /**
     * 请求数据入口
     *
     * @param url
     */
    public void requestData(String url) {
        getAttachView().showLoading();
        MVPDataModelManager.newInstance(MVPDataModel.class.getName()).setParams("").executeGetRequest(url, this);
    }

    /**
     * 数据请求成功--更新UI
     *
     * @param successData
     */
    @Override
    public void onSuccess(Object successData) {
        if (isViewAttached()) {
            getAttachView().dismissLoading();
            getAttachView().showSuccessData(successData.toString());
        }
    }

    /**
     * 数据请求失败--更新展示错误页面UI
     *
     * @param errorData
     */
    @Override
    public void onFailure(Object errorData) {
        if (isViewAttached()) {
            getAttachView().dismissLoading();
            getAttachView().showFailureData(errorData.toString());
        }
    }
}
