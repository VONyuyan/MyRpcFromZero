package com.fred.rpc.util.balance;

/**
 * ClassName: RoundLoadBalance
 * Package: com.fred.rpc.util.balance
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/11 16:07
 * @Version 1.0
 */

import java.util.List;

/**
 * 轮询负载均衡
 */
public class RoundLoadBalance implements LoadBalance{
    private int choose = -1;
    @Override
    public String balance(List<String> addressList) {
        choose++;
        choose = choose%addressList.size();
        return addressList.get(choose);
    }
}
