package com.fred.rpc.server;

/**
 * ClassName: SimpleRPCRPCServer
 * Package: com.fred.rpc
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/6 14:29
 * @Version 1.0
 */

import com.fred.rpc.server.RPCServer;
import com.fred.rpc.service.ServiceProvider;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * 这个实现类代表着java原始的BIO监听模式，来一个任务，就new一个线程去处理
 * 处理任务的工作见WorkThread中
 */
public class SimpleRPCRPCServer implements RPCServer {
    // 存着服务接口名-> service对象的map
    private ServiceProvider serviceProvide;

    public SimpleRPCRPCServer(ServiceProvider serviceProvide){
        this.serviceProvide = serviceProvide;
    }

    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动了");
            // BIO的方式监听Socket
            while (true){
                Socket socket = serverSocket.accept();
                // 开启一个新线程去处理
                new Thread(new WorkThread(socket,serviceProvide)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }

    public void stop(){
    }
}
