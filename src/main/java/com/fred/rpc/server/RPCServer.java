package com.fred.rpc.server;

/**
 * ClassName: RPCServer
 * Package: com.fred.rpc
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 10:54
 * @Version 1.0
 */
// 把RPCServer抽象成接口，以后的服务端实现这个接口即可
public interface RPCServer {
    void start(int port);
    void stop();
}

