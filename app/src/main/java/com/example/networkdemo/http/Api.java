package com.example.networkdemo.http;

import com.example.network.ResponseModel;
import com.example.networkdemo.model.LoginBackModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author xushibin
 * @date 12/22/21
 * description：
 */
public interface Api {

    @FormUrlEncoded
    @POST("login")
    Observable<ResponseModel<LoginBackModel>> login(@FieldMap Map<String, String> params);

}
