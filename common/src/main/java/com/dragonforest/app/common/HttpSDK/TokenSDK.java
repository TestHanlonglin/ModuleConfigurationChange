package com.dragonforest.app.common.HttpSDK;

import android.util.Log;

/**
 * TokenSDK 模拟
 *
 * @author 韩龙林
 * @date 2019/8/27 17:25
 */
public class TokenSDK {
    private static TokenSDK instance;

    private TokenSDK() {
    }

    public static TokenSDK getInstance() {
        if (instance == null) {
            instance = new TokenSDK();
        }
        return instance;
    }

    private String ip;
    private String port;

    public void init(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public String getToken() {
        Log.e(getClass().getSimpleName(), "Token执行请求：ip:" + ip + ",port:" + port + ";");
        return ip + "_" + port + "_token";
    }
}
