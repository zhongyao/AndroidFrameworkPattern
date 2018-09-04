package com.hongri.model.mvc.model;

import android.graphics.Bitmap;

/**
 * @author zhongyao
 * @date 2018/9/4
 */

public interface OnRequestBitmapListener {
    void onSuccess(Bitmap obj);

    void onFailure();
}
