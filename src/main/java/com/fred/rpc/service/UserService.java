package com.fred.rpc.service;

import com.fred.rpc.pojo.User;

/**
 * ClassName: UserService
 * Package: com.fred.rpc.service
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 10:49
 * @Version 1.0
 */
public interface UserService {
    // 客户端通过这个接口调用服务端的实现类
    User getUserByUserId(Integer id);
    // 给这个服务增加一个功能
    Integer insertUserId(User user);
}
