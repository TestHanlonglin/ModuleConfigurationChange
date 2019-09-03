package com.dragonforest.app.modulecommnication.utils;

import android.util.Log;

/**
 * @author 韩龙林
 * @date 2019/9/3 09:38
 */
public class DFLog {
    public static final String DFTag_D = "模块调试=========》》";
    public static final String DFTag_W = "模块警告=========》》";
    public static final String DFTag_E = "模块错误=========》》";

    public static void D(String msg) {
        Log.d(DFTag_D, msg);
    }

    public static void W(String msg) {
        Log.w(DFTag_W, msg);
    }

    public static void E(String msg) {
        Log.e(DFTag_E, msg);
    }
}
