package com.fred.rpc.client;

import com.fred.rpc.pojo.Blog;
import com.fred.rpc.pojo.ClientProxy;
import com.fred.rpc.pojo.User;
import com.fred.rpc.service.BlogService;
import com.fred.rpc.service.UserService;

/**
 * ClassName: RPCClient
 * Package: com.fred.rpc
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 10:52
 * @Version 1.0
 */
public class RPCClient {
    public static void main(String[] args) {
        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8899);
        UserService proxy = clientProxy.getProxy(UserService.class);

        // 服务的方法1
        User userByUserId = proxy.getUserByUserId(10);
        System.out.println("从服务端得到的user为：" + userByUserId);
        // 服务的方法2
        User user = User.builder().userName("张三").id(100).sex(true).build();
        Integer integer = proxy.insertUserId(user);
        System.out.println("向服务端插入数据："+integer);

        // 客户中添加新的测试用例
        BlogService blogService = clientProxy.getProxy(BlogService.class);
        Blog blogById = blogService.getBlogById(10000);
        System.out.println("从服务端得到的blog为：" + blogById);
    }
}
