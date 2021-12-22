package com.example.networkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.network.listener.CallBackLis;
import com.example.networkdemo.http.HttpRequest;
import com.example.networkdemo.model.LoginBackModel;

public class MainActivity extends AppCompatActivity {

    private EditText etLoginName;
    private EditText etPwd;
    private Button btnLogin;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLoginName = findViewById(R.id.et_login_name);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progress_bar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginName = etLoginName.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                if (TextUtils.isEmpty(loginName)) {
                    Toast.makeText(MainActivity.this, "请输入登录名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                HttpRequest.login(MainActivity.this, loginName, pwd, new CallBackLis<LoginBackModel>() {
                    @Override
                    public void onSuccess(String method, LoginBackModel content) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(String method, String error) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}