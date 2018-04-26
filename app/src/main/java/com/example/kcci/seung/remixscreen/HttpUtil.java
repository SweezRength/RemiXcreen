package com.example.kcci.seung.remixscreen;

/**
 * Created by KCCI on 2018-04-25.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by KCCI on 2018-04-03.
 */

public class HttpUtil {
    public static String getData(String address) throws IOException {
        URL url = new URL(address);
        URLConnection con = url.openConnection();

        //byte 단위의 읽어들이는 class를 character 단위로 읽어들이는 class로 변경
        InputStream is = con.getInputStream();
        //InputStream을 BufferedReader로 변경시키려면 InputStreamReader를 거쳐서 가야한다.
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);


        StringBuffer result = new StringBuffer();
        while (true) {
            String data = br.readLine();

            if (data == null)
                break;
            result.append(data + "\n");

        }
        return result.toString();
    }
}