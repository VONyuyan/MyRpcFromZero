package com.fred.rpc.service.impl;

import com.fred.rpc.pojo.Blog;
import com.fred.rpc.service.BlogService;

/**
 * ClassName: BlogServiceImpl
 * Package: com.fred.rpc.service.impl
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 14:25
 * @Version 1.0
 */
// 服务端新的服务接口实现类
public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getBlogById(Integer id) {
        Blog blog = Blog.builder().id(id).title("我的博客").useId(22).build();
        System.out.println("客户端查询了"+id+"博客");
        return blog;
    }
}
