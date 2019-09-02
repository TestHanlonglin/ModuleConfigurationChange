package com.dragonforest.app.common.util;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.dragonforest.app.common.configuration.ModuleIserverManager;

/**
 * 跳转类 所有模块跳转统一入口
 *
 * @author 韩龙林
 * @date 2019/8/27 17:07
 */
public class NavigationUtil {

    public static NavigationUtil getInstance() {
        return new NavigationUtil();
    }

    /**
     * 上下文
     */
    private Context context;
    /**
     * 模块名
     */
    private String module = null;
    /**
     * 目标组件名
     */
    private String target = null;

    public NavigationUtil with(Context context) {
        this.context = context;
        return this;
    }

    public NavigationUtil module(String module) {
        this.module = module;
        return this;
    }

    public NavigationUtil setTarget(String target) {
        this.target = target;
        return this;
    }

    /**
     * 执行跳转
     */
    public void go() {
        if (context == null) {
            Log.e(getClass().getSimpleName(), "context must not be null!!");
            Toast.makeText(context, "context must not be null!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (module == null) {
            Log.e(getClass().getSimpleName(), "module must not be null!!");
            Toast.makeText(context, "module must not be null!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (target == null) {
            Log.e(getClass().getSimpleName(), "target must not be null!!");
            Toast.makeText(context, "target must not be null!!", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            Intent intent = new Intent();
            Class<?> aClass = Class.forName(target);
            intent.setClass(context, aClass);
            context.startActivity(intent);
//
//            // 执行切换云端
//            ModuleIserverManager.changeModule(module);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
