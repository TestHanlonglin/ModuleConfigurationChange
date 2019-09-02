package com.dragonforest.app.modulecommnication.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.dragonforest.app.modulecommnication.annotations.Module1;
import com.dragonforest.app.modulecommnication.annotations.Module10;
import com.dragonforest.app.modulecommnication.annotations.Module11;
import com.dragonforest.app.modulecommnication.annotations.Module12;
import com.dragonforest.app.modulecommnication.annotations.Module13;
import com.dragonforest.app.modulecommnication.annotations.Module14;
import com.dragonforest.app.modulecommnication.annotations.Module15;
import com.dragonforest.app.modulecommnication.annotations.Module16;
import com.dragonforest.app.modulecommnication.annotations.Module17;
import com.dragonforest.app.modulecommnication.annotations.Module18;
import com.dragonforest.app.modulecommnication.annotations.Module19;
import com.dragonforest.app.modulecommnication.annotations.Module2;
import com.dragonforest.app.modulecommnication.annotations.Module20;
import com.dragonforest.app.modulecommnication.annotations.Module3;
import com.dragonforest.app.modulecommnication.annotations.Module4;
import com.dragonforest.app.modulecommnication.annotations.Module5;
import com.dragonforest.app.modulecommnication.annotations.Module6;
import com.dragonforest.app.modulecommnication.annotations.Module7;
import com.dragonforest.app.modulecommnication.annotations.Module8;
import com.dragonforest.app.modulecommnication.annotations.Module9;
import com.dragonforest.app.modulecommnication.annotations.ModuleApp;
import com.dragonforest.app.modulecommnication.beans.ModuleConfiguration;

import java.util.HashMap;

/**
 * 模块配置管理类
 *
 * @author 韩龙林
 * @date 2019/9/2 17:47
 */
public class ModuleConfigurationManager {

    public ModuleConfiguration currentModuleConfiguration = null;

    private static ModuleConfigurationManager instance;

    private ModuleConfigurationManager() {
    }

    public static ModuleConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ModuleConfigurationManager();
        }
        return instance;
    }

    public ModuleConfiguration getCurrentModuleConfiguration() {
        return currentModuleConfiguration;
    }

    private onResetConfigurationListener onResetConfigurationListener;
    private HashMap<String, ModuleConfiguration> configurationContainer = new HashMap<>();

    public HashMap<String, ModuleConfiguration> getConfigurationContainer() {
        return configurationContainer;
    }

    public ModuleConfiguration getModuleConfiguration(String key) {
        return configurationContainer.get(key);
    }

    public void init(Context context) {
        loadConfiguration(context);
        registerActivityLifeCircle(context);
    }

    /**
     * 加载配置信息,必须使用application的context
     *
     * @param context
     */
    public void loadConfiguration(Context context) {
        ApplicationInfo appInfo = null;
        try {
            appInfo = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);
            String appConfigClassPath = appInfo.metaData.getString("app");
            ModuleConfiguration appConfiguration = reflectClass(appConfigClassPath);
            configurationContainer.put("app", appConfiguration);
            for (int i = 0; i < 20; i++) {
                String moduleName = "module" + (i + 1);
                String moduleConfigurationClassPath = appInfo.metaData.getString(moduleName);
                if (moduleConfigurationClassPath != null && !moduleConfigurationClassPath.equals("")) {
                    ModuleConfiguration moduleConfiguration = reflectClass(moduleConfigurationClassPath);
                    configurationContainer.put(moduleName, moduleConfiguration);
                }
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void registerActivityLifeCircle(Context context) {
        ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                // 使用标识注解区分
                if (activity.getClass().isAnnotationPresent(ModuleApp.class)) {
                    currentModuleConfiguration = getModuleConfiguration("app");
                } else if (activity.getClass().isAnnotationPresent(Module1.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module1");
                } else if (activity.getClass().isAnnotationPresent(Module2.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module3.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module4.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module5.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module6.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module7.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module8.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module9.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module10.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module11.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module12.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module13.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module14.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module15.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module16.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module17.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module18.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module19.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else if (activity.getClass().isAnnotationPresent(Module20.class)) {
                    currentModuleConfiguration = getModuleConfiguration("module2");
                } else {
                    currentModuleConfiguration = getModuleConfiguration("app");
                }
                if (onResetConfigurationListener != null) {
                    onResetConfigurationListener.onReset(currentModuleConfiguration);
                }
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    public void setOnResetConfigurationListener(ModuleConfigurationManager.onResetConfigurationListener onResetConfigurationListener) {
        this.onResetConfigurationListener = onResetConfigurationListener;
    }

    /**
     * 反射 获得对象
     *
     * @param classPath
     * @return
     */
    private ModuleConfiguration reflectClass(String classPath) {
        try {
            Class<?> aClass = Class.forName(classPath);
            ModuleConfiguration o = (ModuleConfiguration) aClass.newInstance();
            o.init();
            return o;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface onResetConfigurationListener {
        /**
         * 重新设置配置之后的操作
         */
        void onReset(ModuleConfiguration moduleConfiguration);
    }
}
