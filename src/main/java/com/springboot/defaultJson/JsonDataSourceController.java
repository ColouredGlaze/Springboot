package com.springboot.defaultJson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by MingT on 2017/7/11.
 */
@RestController
@RequestMapping("/DefaultJson")
public class JsonDataSourceController {

    @RequestMapping("/getJsonData")
    // URL:http://localhost:8080/DefaultJson/getJsonData
    public JsonDataSourceBean getJsonData(){
        JsonDataSourceBean jdsb = new JsonDataSourceBean();
        jdsb.setId(1);
        jdsb.setName("jsonData");
        jdsb.setBirthday(new Date());
        return jdsb;
    }

}
