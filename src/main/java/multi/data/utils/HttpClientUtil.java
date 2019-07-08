package multi.data.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class HttpClientUtil {
    public static String SendHttpRequest(String RequestType, String URL, String param) throws IOException {
        String result;
        CloseableHttpClient httpClient;
        HttpPost httpPost;
        HttpGet httpGet;
        CloseableHttpResponse response;
        httpClient = HttpClients.createDefault();

        if (RequestType.equals("POST")) {
            httpPost = new HttpPost(URL); // 参数化 URL
            // 发送json数据
            httpPost.addHeader("Content-type", "application/json; charset=utf-8");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setEntity(new StringEntity(param, Charset.forName("UTF-8"))); // 参数化 param
            response = httpClient.execute(httpPost); // 使用 httpclient 的 execute 方法发送接口请求
            result = EntityUtils.toString(response.getEntity());
        } else {
            httpGet = new HttpGet(URL);
            response = httpClient.execute(httpGet);
            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }
}
