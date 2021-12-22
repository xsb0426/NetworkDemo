package com.example.network.utils;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class HttpUtils {

    /**
     * Post请求,获取请求体
     *
     * @param params
     * @return
     */
    public static RequestBody getRequestBody(Map<String, Object> params) {
        JSONObject jsonObject = new JSONObject(params);
        return RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
    }

    /**
     * Post请求,获取请求体
     *
     * @param params
     * @return
     */
    public static RequestBody getRequestBody(String params) {
        return RequestBody.create(MediaType.parse("application/json"), params);
    }

}
