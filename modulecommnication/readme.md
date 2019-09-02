# 组件化配置切换框架

## 使用：

* 1.每个模块都引入modulecommnication 模块

* 2.app模块中：
* * 为每个模块创建一个配置类，继承ModuleConfiguration， 并重写setXXX设置各个模块真实配置。例如module1模块：
```
    public class Module1Configuration extends ModuleConfiguration {

    @Override
    public void setIp() {
        setIp("172.168.8.1");
    }

    @Override
    public void setName() {
        setName("模块1");
    }

    @Override
    public void setPort() {
        setPort("8082");
    }

    @Override
    public void setToken() {
        setToken("");
    }
}
```
    
* *  AndroidManifest.xml配置各个模块的配置,注意这里的name必须是module+数字（1-20）,app有且只有一个（为主模块），value为配置文件的全类名:
```
    <!--配置各个模块的配置-->
        <meta-data
            android:name="module1"
            android:value="com.dragonforest.app.iserverchangetest.configuration.Module1Configuration"/>
        <meta-data
            android:name="module2"
            android:value="com.dragonforest.app.iserverchangetest.configuration.Module2Configuration"/>
        <meta-data
            android:name="app"
            android:value="com.dragonforest.app.iserverchangetest.configuration.AppConfiguration"/> 
```

* 3.初始化：在Application中调用，前者是加载配置，后者是写重新设置配置之后的逻辑(比如初始化sdk等等)。：
```
ModuleConfigurationManager.getInstance().init(this);
ModuleConfigurationManager.getInstance().setOnResetConfigurationListener();
```

* 4.加入注解，在每个模块里的activity上都加上相应的注解，注意与上面的module1,module2的配置对应。例如，对应模块module1的注解为@Module1,module2的注解为@Module2

* 5.执行跳转,在不同的模块中通过ModuleConfigurationManager.getCurrentModuleConfiguration()每次跳转到不同的模块都会有不同的配置。