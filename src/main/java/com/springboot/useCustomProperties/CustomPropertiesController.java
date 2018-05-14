package com.springboot.useCustomProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MingTie
 * CreateDate：2017/8/16
 * Description：
 */
@RestController
public class CustomPropertiesController {

    @Autowired
    QuiteSetting quiteSetting;
    @Autowired
    SilenceSetting silenceSetting;

    @RequestMapping("getCustomProperties")
    public String getCustomProperties(){
        return quiteSetting.toString()+silenceSetting.toString();
    }
}
