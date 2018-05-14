package com.springboot.globalException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MingT on 2017/7/11.
 */
@RestController
public class GetExceptionController {

    @RequestMapping("/getByZeroException")
    // URL:http://localhost:8080/getByZeroException
    public int getByZeroException(){
        return 100/0;
    }

}
