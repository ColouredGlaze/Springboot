package com.springboot.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by MingT on 2017/7/17.
 */
@RestController
@RequestMapping("/CRUD")
public class CRUDBeanController {

    @Autowired
    private CRUDBeanService crudBeanService;

    @RequestMapping("/queryAll")
    public Iterable<CRUDBean> queryAll(){
        return crudBeanService.checkAll();
    }

    @RequestMapping("/queryByName")
    public CRUDBean queryByName(String name){
        return crudBeanService.checkByName(name);
    }

    @RequestMapping("/addOnePerson")
    public String addOnePerson(String name,Date birthday, String address){
        CRUDBean crudBean = new CRUDBean();
        crudBean.setName(name);
        crudBean.setBirthday(birthday);
        crudBean.setAddress(address);
        System.err.println(name);
        System.err.println(birthday);
        System.err.println(address);
        crudBeanService.save(crudBean);
        return "OK";
    }
}
