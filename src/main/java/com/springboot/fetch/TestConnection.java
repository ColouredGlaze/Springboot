package com.springboot.fetch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MingT on 2017/7/14.
 */
@RestController
public class TestConnection {

    @RequestMapping("/fetch/getConnection")
    public String getConnection(String message){
        return "Have received "+message;
    }
}
