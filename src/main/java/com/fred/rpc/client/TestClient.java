package com.fred.rpc.client;

import com.fred.rpc.pojo.Blog;
import com.fred.rpc.pojo.RPCClientProxy;
import com.fred.rpc.pojo.User;
import com.fred.rpc.service.BlogService;
import com.fred.rpc.service.UserService;

/**
 * ClassName: TestClient
 * Package: com.fred.rpc.client
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/8 11:07
 * @Version 1.0
 */
public class TestClient {
    public static void main(String[] args) {
        // 构建一个使用java Socket传输的客户端
        // SimpleRPCClient simpleRPCClient = new SimpleRPCClient("127.0.0.1", 8899);
        NettyRPCClient nettyRPCClient = new NettyRPCClient("127.0.0.1", 8899);
// 把这个客户端传入代理客户端
        RPCClientProxy rpcClientProxy = new RPCClientProxy(nettyRPCClient);
// 代理客户端根据不同的服务，获得一个代理类， 并且这个代理类的方法以或者增强（封装数据，发送请求）
        UserService userService = rpcClientProxy.getProxy(UserService.class);
// 调用方法
        User userByUserId = userService.getUserByUserId(10);

        int userInsert = userService.insertUserId(new User(100, "张三", true));
        // 客户中添加新的测试用例
        BlogService blogService = rpcClientProxy.getProxy(BlogService.class);
        Blog blogById = blogService.getBlogById(10000);
        System.out.println("从服务端得到的blog为：" + blogById);

    }
}
