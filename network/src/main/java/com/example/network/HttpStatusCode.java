package com.example.network;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import retrofit2.HttpException;

/**
 * @author xushibin
 * @date 8/20/21
 * description：
 */
public class HttpStatusCode {

    public static String code2info(int statusCode) {
        String info;
        switch (statusCode) {
            case 200:
                info = "请求成功";
                break;
            case 400:
                info = "错误请求";
                break;
            case 401:
                info = "未授权或授权过期";
                break;
            case 403:
                info = "服务器拒绝请求";
                break;
            case 404:
                info = "请求方法不存在";
                break;
            case 414:
                info = "请求地址过长";
                break;
            case 415:
                info = "不支持的媒体类型";
                break;
            case 500:
                info = "服务器内部错误";
                break;
            case 502:
                info = "错误网关";
                break;
            case 503:
                info = "服务不可用";
                break;
            case 504:
                info = "网关超时";
                break;
            default:
                info = "状态码：" + statusCode;
        }

        return info;
    }


    public static String handleException(Throwable e) {
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int statusCode = httpException.code();
            return code2info(statusCode);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            return "解析错误";
        } else if (e instanceof ConnectException) {
            return "连接超时";
        } else if (e instanceof SocketTimeoutException) {
            return "响应超时";
        } else {
            return "未知错误";
        }
    }

}
