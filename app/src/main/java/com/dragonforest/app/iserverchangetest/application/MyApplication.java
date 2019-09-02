package com.dragonforest.app.iserverchangetest.application;

import android.util.Log;

import com.dragonforest.app.common.HttpSDK.TokenSDK;
import com.dragonforest.app.common.application.CommonApplication;
import com.dragonforest.app.modulecommnication.beans.ModuleConfiguration;
import com.dragonforest.app.modulecommnication.utils.ModuleConfigurationManager;

/**
 * @author 韩龙林
 * @date 2019/8/27 19:25
 */
public class MyApplication extends CommonApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ModuleConfigurationManager.getInstance().init(this);
        ModuleConfigurationManager.getInstance().setOnResetConfigurationListener(new ModuleConfigurationManager.onResetConfigurationListener() {
            @Override
            public void onReset(ModuleConfiguration moduleConfiguration) {
                // 重新配置之后的逻辑
                if (moduleConfiguration != null) {
                    if (moduleConfiguration.getToken() == null || moduleConfiguration.getToken().equals("")) {
                        TokenSDK.getInstance().init(moduleConfiguration.getIp(),moduleConfiguration.getPort());
                        moduleConfiguration.setToken(TokenSDK.getInstance().getToken());
                        Log.e("MyApplication", "OnResetConfigurationListener回调：ip:" + moduleConfiguration.getIp());
                    }
                }
            }
        });
    }
}
