package com.fred.rpc.service;

import com.fred.rpc.pojo.Blog;

/**
 * ClassName: BlogService
 * Package: com.fred.rpc.service
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 14:23
 * @Version 1.0
 */
// 新的服务接口
public interface BlogService {
    Blog getBlogById(Integer id);
}
