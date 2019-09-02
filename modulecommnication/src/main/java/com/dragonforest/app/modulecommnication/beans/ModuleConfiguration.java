package com.dragonforest.app.modulecommnication.beans;

/**
 * 模块配置基类
 *
 * @author 韩龙林
 * @date 2019/9/2 17:29
 */
public abstract class ModuleConfiguration {
    private String name;
    private String ip;
    private String port;
    private String token; // 暂时用字符串表示

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public String getPort() {
        return port;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public abstract void setIp();

    public abstract void setName();

    public abstract void setPort();

    public abstract void setToken();

    public void init(){
        setIp();
        setPort();
        setName();
        setToken();
    }
}
