package com.hua.data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/21 下午6:54
 */
public class UserApi {
    public void get() {
        try {
            URL url = new URL("http:www.baidu.com");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
