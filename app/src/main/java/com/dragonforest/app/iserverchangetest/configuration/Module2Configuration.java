package com.dragonforest.app.iserverchangetest.configuration;

import com.dragonforest.app.modulecommnication.beans.ModuleConfiguration;

/**
 * @author 韩龙林
 * @date 2019/9/2 17:36
 */
public class Module2Configuration extends ModuleConfiguration {

    @Override
    public void setIp() {
        setIp("232.168.8.1");
    }

    @Override
    public void setName() {
        setName("模块2");
    }

    @Override
    public void setPort() {
        setPort("8083");
    }

    @Override
    public void setToken() {
        setToken("");
    }
}
