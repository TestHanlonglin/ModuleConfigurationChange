package com.dragonforest.app.iserverchangetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dragonforest.app.common.beans.Modules;
import com.dragonforest.app.common.beans.Targets;
import com.dragonforest.app.common.util.NavigationUtil;
import com.dragonforest.app.modulecommnication.annotations.ModuleApp;

@ModuleApp
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_splash);
        // 进入main
        NavigationUtil.getInstance()
                .with(this)
                .module(Modules.MODULE_APP)
                .setTarget(Targets.TARGET_APP_MAINACTIVITY)
                .go();
    }

}
