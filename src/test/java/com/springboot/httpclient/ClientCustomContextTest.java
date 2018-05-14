package com.springboot.httpclient;

import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class ClientCustomContextTest {

    @Test
    public void ClientCustomContext() throws IOException {
        URI uri = null;
        try {
            uri = new URIBuilder().
                    setScheme("http")
                    .setHost("www.google.com")
                    .setPath("/search")
                    .setParameter("q", "httpclient")
                    .setParameter("btnG", "Google Search")
                    .setParameter("aq", "f")
                    .setParameter("oq", "")
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpGet httpget = new HttpGet(uri);
        System.out.println(httpget.getURI());
        System.err.println("------------------------------");

        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"OK");
        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getStatusLine().getReasonPhrase());
        System.out.println(response.getStatusLine().toString());
        System.err.println("------------------------------");
        response.addHeader("Set-Cookie", "c1=a; path=/; domain=yeetrack.com");
        response.addHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"yeetrack.com\"");
        Header h1 = response.getFirstHeader("Set-Cookie");
        System.out.println(h1);
        Header h2 = response.getLastHeader("Set-Cookie");
        System.out.println(h2);
        Header[] hs = response.getHeaders("Set-Cookie");
        System.out.println(hs.length);
        System.err.println("------------------------------");
        HeaderIterator it = response.headerIterator("Set-Cookie");
        while (it.hasNext()){
            System.out.println(it.next());
        }
        HeaderElementIterator it2 = new BasicHeaderElementIterator(response.headerIterator("Set-Cookie"));

        while (it2.hasNext()) {
            HeaderElement elem = it2.nextElement();
            System.out.println(elem.getName() + " = " + elem.getValue());
            NameValuePair[] params = elem.getParameters();
            for (int i = 0; i < params.length; i++) {
                System.out.println(" " + params[i]);
            }
        }


        CloseableHttpClient httpclient =  HttpClients.createDefault();
        HttpGet httpget1 = new HttpGet("http://www.yeetrack.com/");
        CloseableHttpResponse response2 = httpclient.execute(httpget1);
        try {
            HttpEntity entity = response2.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                try {
                    // do something useful
                } finally {
                    instream.close();
                }
            }
        } finally {
            System.err.println(response2);
            response2.close();
            System.out.println(response2);
        }
    }
}