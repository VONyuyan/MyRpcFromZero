package com.fred.rpc.service.impl;

import com.fred.rpc.pojo.User;
import com.fred.rpc.service.UserService;

import java.util.Random;
import java.util.UUID;

/**
 * ClassName: UserServiceImpl
 * Package: com.fred.rpc.service.impl
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 10:51
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("客户端查询了"+id+"的用户");
        // 模拟从数据库中取用户的行为
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString())
                .id(id)
                .sex(random.nextBoolean()).build();
        return user;
    }

    @Override
    public Integer insertUserId(User user) {
        System.out.println("插入数据成功："+user);
        return 1;
    }
}
