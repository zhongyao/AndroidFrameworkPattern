package com.hongri.model.mvc.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

/**
 * @author zhongyao
 * @date 2018/9/4
 *
 * Model层
 */

public class MVCHttpRequestModel implements MVCHttpRequestInterface {

    @Override
    public void onHttpRequest(final String urlString, final MVCRequestCallback listener) {

        new RequestTask(listener).execute(urlString);

    }

    public class RequestTask extends AsyncTask<String, Void, Bitmap> {

        private MVCRequestCallback listener;

        public RequestTask(MVCRequestCallback listener) {
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
                listener.onFailure("获取失败");
            }
        }
    }
}
