package com.github.kongmu373;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SmokeTest {
    @Test
    public void test() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://srh.bankofchina.com/search/whpj/search_cn.jsp");
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("erectDate", "2021-09-17"));
        params.add(new BasicNameValuePair("nothing", "2021-09-17"));
        params.add(new BasicNameValuePair("nothing", "2021-09-17"));
        params.add(new BasicNameValuePair("pjname", "英镑"));
        params.add(new BasicNameValuePair("page", "3"));

        httpPost.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute(httpPost);
        String s = EntityUtils.toString(response.getEntity(), "GBK");
        System.out.println(s);
    }
}
