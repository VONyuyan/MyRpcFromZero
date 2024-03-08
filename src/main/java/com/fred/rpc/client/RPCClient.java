package com.fred.rpc.client;

import com.fred.rpc.pojo.*;

/**
 * ClassName: RPCClient
 * Package: com.fred.rpc
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 10:52
 * @Version 1.0
 */
// 共性抽取出来
public interface RPCClient {
    RPCResponse sendRequest(RPCRequest response);
}
