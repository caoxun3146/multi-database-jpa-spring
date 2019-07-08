package multi.data.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class SendPush {

    public static String send(String jsession, String phoneId, String sex) throws IOException {
        String result;
        CloseableHttpClient httpClient;
        HttpPost httpPost;
        CloseableHttpResponse response;
        BasicCookieStore cookieStore;
        //httpClient = HttpClients.createDefault();
        cookieStore = new BasicCookieStore();
        BasicClientCookie JSESSIONID = new BasicClientCookie("JSESSIONID",
                jsession);
        JSESSIONID.setDomain("test.vipgift.gmilesquan.com");
        cookieStore.addCookie(JSESSIONID);
        httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore)
                .build();
        httpPost = new HttpPost(
                "http://test.vipgift.gmilesquan.com/quSuperManager/push/sendMassage");
        httpPost.setHeader(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        //创建 MultipartEntityBuilder,以此来构建我们的参数
        MultipartEntityBuilder EntityBuilder = MultipartEntityBuilder.create();
        //设置字符编码，防止乱码
        ContentType contentType = ContentType.create("text/plain", Charset.forName("UTF-8"));
        //填充我们的文本内容，这里相当于input 框中的 name 与value
        EntityBuilder.addPart("msgCenterUrlModal", new StringBody("", contentType));
        EntityBuilder.addPart("noticeBarUrlModal", new StringBody("", contentType));
        EntityBuilder.addPart("products", new StringBody("14000", contentType)); //新增属性  lemon 14200   qzx 14000   all  14000,14200
        EntityBuilder.addPart("pushType", new StringBody("1", contentType));
        EntityBuilder.addPart("pushTimeType", new StringBody("0", contentType));
        EntityBuilder.addPart("notifyType", new StringBody("3", contentType));
        EntityBuilder.addPart("notifycategory", new StringBody("2", contentType));
        EntityBuilder.addPart("userid", new StringBody("0776f3c9876341ad", contentType));
        EntityBuilder.addPart("sexType", new StringBody(sex, contentType)); // 1 :女   0:男
        EntityBuilder.addPart("title", new StringBody("推送测试", contentType));
        EntityBuilder.addPart("content", new StringBody("趣专享是做什么的? 淘宝天猫商品从趣专享下单,件件都能领额外券及返利,平均每单省50%", contentType));
        EntityBuilder.addPart("noticeBarUrl", new StringBody("\n" +
                "vipgift://com.xmiles.vipgift/web/CommonWebViewActivity?title=11&htmlUrl=https%3A%2F%2Fwww.jianshu.com%2Fp%2Fb5ba7d32eafb&withHead=true&usePost=false", contentType));
        EntityBuilder.addPart("msgCenterUrl", new StringBody("vipgift://com.xmiles.vipgift/web/CommonWebViewActivity?title=22&htmlUrl=https%3A%2F%2Fwww.jianshu.com%2Fp%2Fb5ba7d32eafb&withHead=true&usePost=false", contentType));
        EntityBuilder.addPart("phoneid", new StringBody(phoneId, contentType));
        //EntityBuilder.addBinaryBody("banner", new File("C:\\\\Users\\\\Administrator\\\\Desktop\\\\文档\\\\测试记录\\\\趣专享\\\\素材\\\\veer-323808598.jpg"));

        //参数组装
        httpPost.setEntity(EntityBuilder.build());
        // 使用 httpclient 的 execute 方法发送接口请求
        response = httpClient.execute(httpPost);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        return result;
    }

}
