package com.fred.rpc.util.balance;

/**
 * ClassName: LoadBalance
 * Package: com.fred.rpc.util.balance
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/11 16:06
 * @Version 1.0
 */

import java.util.List;

/**
 * 给服务器地址列表，根据不同的负载均衡策略选择一个
 */
public interface LoadBalance {
    String balance(List<String> addressList);
}
