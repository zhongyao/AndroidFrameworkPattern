package com.hongri.model.mvp.presenter;

<<<<<<< HEAD:app/src/main/java/com/hongri/model/mvp/presenter/MVPPresenter.java
import com.hongri.model.mvp.model.MVPDataModelManager;
=======
import android.graphics.Bitmap;
import com.hongri.model.mvp.model.MVPModelManager;
>>>>>>> develop:app/src/main/java/com/hongri/model/mvp/presenter/MVPDataPresenter.java
import com.hongri.model.mvp.model.MVPDataModel;
import com.hongri.model.mvp.presenter.base.MVPBasePresenter;
import com.hongri.model.mvp.view.MVPViewInterface;

/**
 * @author zhongyao
 * @date 2018/9/3
 *
 * Presenter层
 */

<<<<<<< HEAD:app/src/main/java/com/hongri/model/mvp/presenter/MVPPresenter.java
public class MVPPresenter extends MVPBasePresenter<MVPViewInterface> implements MVPLoadDataCallback {
=======
public class MVPDataPresenter extends MVPBasePresenter<MVPViewInterface> implements MVPLoadDataCallback {
>>>>>>> develop:app/src/main/java/com/hongri/model/mvp/presenter/MVPDataPresenter.java

    /**
     * 请求数据入口
     *
     * @param url
     */
    public void requestData(String url) {
        getAttachView().showLoading();
        MVPDataModelManager.newInstance(MVPDataModel.class.getName()).setParams("").executeGetRequest(url, this);
    }

    public void requestFile(String url){
        MVPModelManager.newInstance(MVPDataModel.class.getName()).setParams("").executeRequestFile(url,this);
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

    @Override
    public void onSuccessBitmap(Bitmap bitmap) {
        if (isViewAttached()) {
            getAttachView().dismissLoading();
            getAttachView().showSuccessBitmap(bitmap);
        }
    }

    @Override
    public void onFailureBitmap(Bitmap bitmap) {
        if (isViewAttached()) {
            getAttachView().dismissLoading();
            getAttachView().showFailureBitmap(bitmap);
        }
    }
}
