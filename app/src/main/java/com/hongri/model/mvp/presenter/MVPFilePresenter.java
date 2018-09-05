package com.hongri.model.mvp.presenter;

import android.graphics.Bitmap;
import com.hongri.model.mvp.model.MVPModelManager;
import com.hongri.model.mvp.model.MVPFileModel;
import com.hongri.model.mvp.presenter.base.MVPBasePresenter;
import com.hongri.model.mvp.view.MVPViewInterface;

/**
 * @author zhongyao
 * @date 2018/9/5
 */

public class MVPFilePresenter extends MVPBasePresenter<MVPViewInterface<Bitmap>> implements MVPLoadDataCallback<Bitmap> {

    public void requestFile(String url) {
        getAttachView().showLoading();
        MVPModelManager.newInstance(MVPFileModel.class.getName()).setParams("").executeRequestFile(url, this);
    }

    @Override
    public void onSuccess(Bitmap successData) {
        if (isViewAttached()) {
            getAttachView().dismissLoading();
            getAttachView().showSuccessBitmap(successData);
        }
    }

    @Override
    public void onFailure(Bitmap errorData) {
        if (isViewAttached()) {
            getAttachView().dismissLoading();
            getAttachView().showFailureBitmap(errorData);
        }
    }
}
