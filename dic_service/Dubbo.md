# Dubbo 2.7

## 快速开始

### 服务提供者

1. 定义一个服务接口

2. 并实现服务接口

3. Spring配置暴露服务

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://code.alibabatech.com/schema/dubbo
       http://code.alibabatech.com/schema/dubbo/dubbo.xsd">

    <!-- 服务名称 -->
    <dubbo:application name="dic" />
    <!-- 注册中心地址 -->
    <dubbo:registry protocol="zookeeper" address="127.0.0.1:2181" />
    <!-- 暴露服务地址 -->
    <dubbo:protocol name="dubbo" port="20081" />
    <!-- 声明暴露的服务 -->
    <dubbo:service interface="org.example.service.dic.DicService" ref="dicService" />
    <bean id="dicService" class="org.example.dic.service.DicServiceImpl" />
</beans>
```

4. 加载Spring配置

```
public class MainApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("spring.xml");
        context.start();
        System.in.read();
    }
}
```

### 服务消费者

1. 通过Spring配置引用远程服务

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://code.alibabatech.com/schema/dubbo
       http://code.alibabatech.com/schema/dubbo/dubbo.xsd">

    <!-- 服务名称 -->
    <dubbo:application name="apicenter" />
    <!-- 注册中心地址 -->
    <dubbo:registry protocol="zookeeper" address="127.0.0.1:2181" />
    <!-- 引用服务 -->
    <dubbo:reference id="dicService" interface="org.example.service.dic.DicService">
        <!-- 单独设置超时时长及重试次数 -->
        <dubbo:method name="get" timeout="2500" retries="3" />
    </dubbo:reference>

</beans>
```

2. 自动注入即可使用

```
@Autowired
DicService dicService;
```