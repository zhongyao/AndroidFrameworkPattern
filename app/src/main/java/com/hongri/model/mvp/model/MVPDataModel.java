package com.hongri.model.mvp.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import com.hongri.model.mvp.model.base.MVPBaseModel;
import com.hongri.model.mvp.presenter.MVPLoadDataCallback;

/**
 * @author hongri
 * @date 2018/9/3
 *
 * Model层
 */

public class MVPDataModel extends MVPBaseModel {
<<<<<<< HEAD
    public String data;
=======
    public String data = "";
>>>>>>> develop

    @Override
    public void executeGetRequest(String url, final MVPLoadDataCallback callback) {
        /**
         * 模拟网络请求耗时操作
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data = "请求服务端数据成功";
                if (!TextUtils.isEmpty(data)) {
                    callback.onSuccess(data);
                } else {
                    data = "请求服务端数据失败";
                    callback.onFailure(data);
                }
            }
        }, 1000);
    }

        @Override
        public void executeRequestFile(String url, MVPLoadDataCallback callback) {
            /**
             * 网络请求文件耗时操作
             */
            new RequestTask(callback).execute(url);
        }

        public class RequestTask extends AsyncTask<String, Void, Bitmap> {

            private MVPLoadDataCallback listener;

            public RequestTask(MVPLoadDataCallback listener) {
                this.listener = listener;
            }

            @Override
            protected Bitmap doInBackground(String... strings) {
                Bitmap bitmap = null;
                InputStream inputStream;
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(10 * 1000);
                    int responseCode = conn.getResponseCode();

                    if (responseCode == 200) {
                        inputStream = conn.getInputStream();
                        bitmap = BitmapFactory.decodeStream(inputStream);
                    } else {
                        bitmap = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                if (bitmap != null) {
                    listener.onSuccessBitmap(bitmap);
                } else {
                    listener.onFailureBitmap(bitmap);
                }
            }
        }
}
