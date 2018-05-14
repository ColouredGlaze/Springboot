package com.springboot.vue.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.util.ReturnData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Vue")
public class UserBeanController {

    @Resource
    private UserBeanService userBeanService;

    @RequestMapping("/searchAll")
    public Map searchAll() {
        return ReturnData.Result(userBeanService.searchAllUser());
    }

    @RequestMapping("/addOneUser")
    public Map addOneUser(String context) {
        JSONObject jsonObject = (JSONObject) JSON.parse(context);
        UserBean newUser = jsonObject.toJavaObject(UserBean.class);
        return ReturnData.Result(userBeanService.addOneUser(newUser));
    }

    @RequestMapping("/deleteUser")
    public Map deletePerson(String context) {
        JSONObject jsonObject = (JSONObject) JSON.parse(context);
        return ReturnData.Result(userBeanService.deleteUser(jsonObject.getLong("id")));
    }

    @RequestMapping("/preciseSearchByName")
    public Map preciseSearchByName(String context) {
        JSONObject jsonObject = (JSONObject) JSON.parse(context);
        return ReturnData.Result(userBeanService.preciseSearchByName(jsonObject.getString("name")));
    }

    @RequestMapping("/fuzzySearchByName")
    public Map fuzzySearchByName(String context) {
        JSONObject jsonObject = (JSONObject) JSON.parse(context);
        return ReturnData.Result(userBeanService.fuzzySearchByName(jsonObject.getString("name")));
    }

    @RequestMapping("/conditionsSearch")
    public Map conditionsSearch(String context) {
        JSONObject jsonObject = (JSONObject) JSON.parse(context);
        return ReturnData.Result(userBeanService.conditionsSearch(
                jsonObject.getString("name"),
                jsonObject.getString("sex"),
                jsonObject.getInteger("age")));
    }

    @RequestMapping("/UpdateUser")
    public Map UpdateUser(String context) {
        JSONObject jsonObject = (JSONObject) JSON.parse(context);
        return ReturnData.Result(userBeanService.updateUser(jsonObject.toJavaObject(UserBean.class)));
    }
}
