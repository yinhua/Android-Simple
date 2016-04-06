package com.hua.data;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @author hua.yin
 * @version 1.0.0
 * @since: 16/3/21 下午6:58
 */
public class HttpRequest {
    enum reqeustType{

    }

    public static InputStream reqeustGet(String requestUrl, Map<String, String> header
            , Map<String, String> params)
            throws IOException {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(requestUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(false);
            urlConnection.setDoInput(true);
//            urlConnection.setRequestMethod(urlConnection.P);
            return urlConnection.getInputStream();
        } finally {
            closeHttpURLConnection(urlConnection);
        }
    }


    private static void closeHttpURLConnection(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

}
