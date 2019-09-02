package com.dragonforest.app.iserverchangetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.dragonforest.app.common.beans.Modules;
import com.dragonforest.app.common.beans.Targets;
import com.dragonforest.app.common.util.NavigationUtil;
import com.dragonforest.app.modulecommnication.annotations.ModuleApp;
import com.dragonforest.app.modulecommnication.utils.ModuleConfigurationManager;

@ModuleApp
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_goto_module1:
                NavigationUtil.getInstance()
                        .with(this)
                        .module(Modules.MODULE_MODULE1)
                        .setTarget(Targets.TARGET_MODULE1_MAINACTIVITY)
                        .go();
                break;
            case R.id.btn_goto_module2:
                NavigationUtil.getInstance()
                        .with(this)
                        .module(Modules.MODULE_MODULE2)
                        .setTarget(Targets.TARGET_MODULE2_MAINACTIVITY)
                        .go();
                break;
            case R.id.btn_do_request:
                String token = ModuleConfigurationManager.getInstance().getCurrentModuleConfiguration().getToken();
                Toast.makeText(this, "当前token:"+token, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
