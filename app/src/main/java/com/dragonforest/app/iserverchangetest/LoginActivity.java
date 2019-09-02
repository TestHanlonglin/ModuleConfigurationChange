package com.dragonforest.app.iserverchangetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dragonforest.app.modulecommnication.annotations.ModuleApp;

@ModuleApp
public class LoginActivity extends AppCompatActivity {

    private EditText ed_name;
    private EditText ed_passwd;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        ed_name=findViewById(R.id.ed_uname);
        ed_passwd=findViewById(R.id.ed_passwd);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String passwd = ed_passwd.getText().toString();
        String uname=ed_name.getText().toString();
        if("".equals(passwd)||"".equals(uname)){
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

    }
}
