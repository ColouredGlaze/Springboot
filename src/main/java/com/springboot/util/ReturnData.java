package com.springboot.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MingTie
 * CreateDate：2017/8/17
 * Description：返回数据
 */
public class ReturnData {
    private static String SUCCESSFUL;
    private static String SUCCESSFUL_MESSAGE;
    private static Map<String, Object> SUCCESS_MAP;
    private static String FAILURE;
    private static String FAILURE_MESSAGE;
    private static Map<String, Object> FAILURE_MAP;
    private Map<String, Object> map = new HashMap<>();
    private String message;

    static {
        SUCCESSFUL = "success";
        SUCCESSFUL_MESSAGE = "Successful access to information.";
        SUCCESS_MAP = new HashMap<>();
        SUCCESS_MAP.put("status", SUCCESSFUL);
        SUCCESS_MAP.put("message", SUCCESSFUL_MESSAGE);
        FAILURE = "fail";
        FAILURE_MESSAGE = "Failed to get information.";
        FAILURE_MAP = new HashMap<>();
        FAILURE_MAP.put("status", FAILURE);
        FAILURE_MAP.put("message", FAILURE_MESSAGE);
    }

    private ReturnData(){
        super();
    }

    private ReturnData(String message){
        super();
        this.message = message;
    }

    public Map GetReturnMap(){
        return getMap();
    }

    public static ReturnData NewOkResult(Object data){
        ReturnData returnData = new ReturnData();
        returnData.getMap().put("status", SUCCESSFUL);
        returnData.getMap().put("data", data);
        return returnData;
    }

    public static Map Result(Object data){
        if (data != null){
            return NewOkResult(data).GetReturnMap();
        } else {
            return FailureResult();
        }
    }

    public static Map OkResult(){
        return SUCCESS_MAP;
    }

    public static Map FailureResult(){
        return FAILURE_MAP;
    }

    public static ReturnData setMessage(String message) {
        return new ReturnData(message);
    }

    public Map<String, Object> getMap() {
        return this.map;
    }
}
