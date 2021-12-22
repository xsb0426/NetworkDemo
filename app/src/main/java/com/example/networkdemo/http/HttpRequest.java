package com.example.networkdemo.http;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;

import com.example.network.HttpCall;
import com.example.network.ResponseModel;
import com.example.network.RetrofitHelper;
import com.example.network.listener.CallBackLis;
import com.example.networkdemo.model.LoginBackModel;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * @author xushibin
 * @date 12/22/21
 * description：
 */
public class HttpRequest {

    public static void login(LifecycleOwner owner, String loginName, String pwd, CallBackLis<LoginBackModel> callBackLis) {
        Map<String, String> params = new HashMap<>();
        params.put("loginName", loginName);
        params.put("password", pwd);
        Observable<ResponseModel<LoginBackModel>> observable = RetrofitHelper
                .getInstance()
                .getRetrofit()
                .create(Api.class)
                .login(params);
        HttpCall.doCall(owner, observable, callBackLis, null);
    }
}
