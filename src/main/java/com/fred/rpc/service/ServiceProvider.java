package com.fred.rpc.service;

/**
 * ClassName: ServiceProvider
 * Package: com.fred.rpc.service
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 14:53
 * @Version 1.0
 */

import com.fred.rpc.util.register.ServiceRegister;
import com.fred.rpc.util.register.ZkServiceRegister;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * 之前这里使用Map简单实现的
 * 存放服务接口名与服务端对应的实现类
 * 服务启动时要暴露其相关的实现类0
 * 根据request中的interface调用服务端中相关实现类
 */
public class ServiceProvider {
    /**
     * 一个实现类可能实现多个接口
     */
    private String host;
    private int port;
    private Map<String, Object> interfaceProvider;
    private ServiceRegister serviceRegister;

    public ServiceProvider(String host, int port){
        this.host = host;
        this.port = port;
        this.interfaceProvider = new HashMap<>();
        this.serviceRegister = new ZkServiceRegister();
    }

    public void provideServiceInterface(Object service){
        Class<?>[] interfaces = service.getClass().getInterfaces();

        for(Class clazz : interfaces){
            // 本机的映射表
            interfaceProvider.put(clazz.getName(),service);
            // 在注册中心注册服务
            serviceRegister.register(clazz.getName(),new InetSocketAddress(host,port));
        }

    }

    public Object getService(String interfaceName){
        return interfaceProvider.get(interfaceName);
    }
}
