package com.geektime.nio.homework02;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author mengfeng
 * @Date 2021/7/4 21:30
 */
public class HttpClientUtils {
    public static CloseableHttpClient httpclient = HttpClients.createDefault();
    
    public static String getAsString(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            return EntityUtils.toString(entity1, "UTF-8");
        } finally {
            response1.close();
        }
    }

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8801/";
        String text = HttpClientUtils.getAsString(url);
        System.out.println("url: " + url + " ; response: \n" + text);
    }
}
