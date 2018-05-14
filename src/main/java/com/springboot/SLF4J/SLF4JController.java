package com.springboot.SLF4J;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author MingTie
 * CreateDate：2017/9/3
 * Description：
 */
@RestController
@RequestMapping("SLF4J")
public class SLF4JController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("logException")
    public String logException(){
        try {
            int i = 3;
            System.err.println(i/0);
        }catch (Exception e){
            logger.error("Exception Logger Begin.");
            logger.error(e.getMessage());
            logger.error("Exception Logger End.");
        }
        return "logException";
    }
}
