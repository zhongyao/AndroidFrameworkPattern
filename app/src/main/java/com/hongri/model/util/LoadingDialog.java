package com.hongri.model.util;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.hongri.model.R;

/**
 * @author zhongyao
 * @date 2018/9/4
 */

public class LoadingDialog extends Dialog {
    private ImageView ivLoading;
    private Context mContext;
    private Animation mAnimation;

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        mContext = context;
        setContentView(R.layout.dialog_loading);

        initView();
    }

    private void initView() {
        ivLoading = findViewById(R.id.ivLoading);
        mAnimation = AnimationUtils.loadAnimation(mContext, R.anim.loading);
    }

    public void showLoading() {
        ivLoading.startAnimation(mAnimation);
        this.show();
    }

    public void dismissLoading() {
        this.dismiss();
    }
}
