package com.example.network.listener;

/**
 * 网络请求回调监听
 */
public interface CallBackLis<T> {

    void onSuccess(String method, T content);

    void onFailure(String method, String error);

}
