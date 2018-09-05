package com.hongri.model.mvp.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.hongri.model.mvp.model.base.MVPBaseModel;
import com.hongri.model.mvp.presenter.MVPLoadDataCallback;

/**
 * @author zhongyao
 * @date 2018/9/5
 */

public class MVPFileModel extends MVPBaseModel<Bitmap> {

    @Override
    public void executeRequestFile(String url, MVPLoadDataCallback<Bitmap> callback) {
        /**
         * 网络请求文件耗时操作
         */
        new RequestTask(callback).execute(url);
    }

    public class RequestTask extends AsyncTask<String, Void, Bitmap> {

        private MVPLoadDataCallback<Bitmap> listener;

        public RequestTask(MVPLoadDataCallback<Bitmap> listener) {
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
                listener.onSuccess(bitmap);
            } else {
                listener.onFailure(bitmap);
            }
        }
    }
}
