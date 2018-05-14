package com.springboot.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("/HttpClient")
public class HttpClineDemoController {

    @RequestMapping("/doIt")
    public String doIt(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.baidu.com/");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            System.err.println("response: "+ response);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity,"UTF-8").toString();
            System.err.println("responseString" + responseString);
            HttpContext context;
            return responseString;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
