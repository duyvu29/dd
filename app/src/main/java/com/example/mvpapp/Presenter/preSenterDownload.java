package com.example.mvpapp.Presenter;

import android.os.AsyncTask;
import android.os.Environment;

import androidx.loader.content.AsyncTaskLoader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class preSenterDownload extends AsyncTask<String ,Integer , String> {

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }

    @Override
    protected String doInBackground(String... strings) {
        BufferedInputStream inputStream = null;
        OutputStream outputStream = null;
        HttpURLConnection httpURLConnection = null;

        try {

            URL url = new URL(strings[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            int size = httpURLConnection.getContentLength();

            inputStream = new BufferedInputStream(url.openStream());
            File directory = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_MUSIC + "/" + "video_khanh"
            );
            if (!directory.exists()) {
                directory.mkdir();
            }

            String destinationFilePath = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_MUSIC + "/" + "video_khanh" + "/" + "video_mp4_khanh.mp4"
            ).getAbsolutePath();

            File file = new File(destinationFilePath);
            file.createNewFile();

            outputStream = new FileOutputStream(destinationFilePath);

            byte[] data = new byte[1024];
            int count;
            double sumCount = 0.0;
            int progress = 0;

            while ((count = inputStream.read(data, 0, 1024)) != -1) {
                outputStream.write(data, 0, count);
                sumCount += count;
                if (size > 0) {
                    progress = (int) (sumCount / size * 100.0);
                    publishProgress(progress);
                }
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Success";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
