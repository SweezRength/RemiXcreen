package com.example.kcci.seung.remixscreen;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class Search extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serarch);
       EditText editText = (EditText) findViewById(R.id.searchKey);
       ImageButton imageButton = (ImageButton) findViewById(R.id.btnImg);
       String search = editText.getText().toString();

       if (editText.getText() != null) {

            try {
                String result = HttpUtil.getData("https://www.googleapis.com/customsearch/v1?key=AIzaSyAiSdCCMPDnm-XyVuiw6IZHVdOAVoUM69A&cx=012495032762985097118:rhcgypaguh4&q=" + search + "&searchType=image&imgSize=xlarge&filter=1&fileType=jpg&dateRestrict=y");
                Log.e("result", result);
                JSONObject obj = new JSONObject(search);
                obj.get("items");
                JSONArray items = (JSONArray) obj.get(result);
                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = (JSONObject) items.get(i);
                    JSONObject link = (JSONObject) item.get("link");
                    Log.e("url", link + "");
                }


//                /**
//                 * 파일명
//                 */
//                String fileName;
//                /**
//                 * 저장할 폴더
//                 */
//                final String SAVE_FOLDER = "/url-images";
//
//                //다운로드 경로를 지정
//                String savePath = Environment.getExternalStorageDirectory().toString() + SAVE_FOLDER;
//                File dir = new File(savePath);
//                //상위 디렉토리가 존재하지 않을 경우 생성
//                if (!dir.exists()) {
//                    dir.mkdirs();
//                }
//                //파일 이름 :날짜_시간
////                Date day = new Date();
////                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.KOREA);
////                fileName = String.valueOf(sdf.format(day));
//
////               //웹 서버 쪽 파일이 있는 경로
////                String fileUrl = params[0];
//                //다운로드 폴더에 동일한 파일명이 존재하는지 확인
//                if (new File(savePath + "/" + fileName).exists() == false) {
//                } else {
//                }
//                String localPath = savePath + "/" + fileName + ".jpg";
//                try {
//                    URL imgUrl = new URL(fileUrl);
//                    //서버와 접속하는 클라이언트 객체 생성
//                    HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
//                    int len = conn.getContentLength();
//                    byte[] tmpByte = new byte[len];
//                    //입력 스트림을 구한다
//                    InputStream is = conn.getInputStream();
//                    File file = new File(localPath);
//                    //파일 저장 스트림 생성
//                    FileOutputStream fos = new FileOutputStream(file);
//                    int read;
//                    //입력 스트림을 파일로 저장
//                    for (; ; ) {
//                        read = is.read(tmpByte);
//                        if (read <= 0) {
//                            break;
//                        }
//                        fos.write(tmpByte, 0, read); //file 생성
//                    }
//                    is.close();
//                    fos.close();
//                    conn.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return null;

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

//        class ImageDownload extends AsyncTask<String, Void, Void> {
//            /**
//             * 파일명
//             */
//            private String fileName;
//            /**
//             * 저장할 폴더
//             */
//            private final String SAVE_FOLDER = "/url-images";
//
//            @Override
//            protected Void doInBackground(String... params) {
//                //다운로드 경로를 지정
//                String savePath = Environment.getExternalStorageDirectory().toString() + SAVE_FOLDER;
//                File dir = new File(savePath);
//                //상위 디렉토리가 존재하지 않을 경우 생성
//                if (!dir.exists()) {
//                    dir.mkdirs();
//                }
//                //파일 이름 :날짜_시간
////                Date day = new Date();
////                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.KOREA);
////                fileName = String.valueOf(sdf.format(day));
//
////               //웹 서버 쪽 파일이 있는 경로
////                String fileUrl = params[0];
//                //다운로드 폴더에 동일한 파일명이 존재하는지 확인
//                if (new File(savePath + "/" + fileName).exists() == false) {
//                } else {
//                }
//                String localPath = savePath + "/" + fileName + ".jpg";
//                try {
//                    URL imgUrl = new URL(fileUrl);
//                    //서버와 접속하는 클라이언트 객체 생성
//                    HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
//                    int len = conn.getContentLength();
//                    byte[] tmpByte = new byte[len];
//                    //입력 스트림을 구한다
//                    InputStream is = conn.getInputStream();
//                    File file = new File(localPath);
//                    //파일 저장 스트림 생성
//                    FileOutputStream fos = new FileOutputStream(file);
//                    int read;
//                    //입력 스트림을 파일로 저장
//                    for (; ; ) {
//                        read = is.read(tmpByte);
//                        if (read <= 0) {
//                            break;
//                        }
//                        fos.write(tmpByte, 0, read); //file 생성
//                    }
//                    is.close();
//                    fos.close();
//                    conn.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        }
//    }
    }
}

