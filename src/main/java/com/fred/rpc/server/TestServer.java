package com.fred.rpc.server;

import com.fred.rpc.server.RPCServer;
import com.fred.rpc.server.SimpleRPCRPCServer;
import com.fred.rpc.service.BlogService;
import com.fred.rpc.service.ServiceProvider;
import com.fred.rpc.service.UserService;
import com.fred.rpc.service.impl.BlogServiceImpl;
import com.fred.rpc.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TestServer
 * Package: com.fred.rpc
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 14:26
 * @Version 1.0
 */
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        // Map<String, Object> serviceProvide = new HashMap<>();
        // 暴露两个服务接口， 即在RPCServer中加一个HashMap
        // serviceProvide.put("com.fred.rpc.service.UserService",userService);
        // serviceProvide.put("com.fred.rpc.service.BlogService",blogService);
        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 8899);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        // RPCServer RPCServer = new SimpleRPCRPCServer(serviceProvider);
        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
