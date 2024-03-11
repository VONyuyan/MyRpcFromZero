package com.fred.rpc.server;

/**
 * ClassName: NettyServerInitializer
 * Package: com.fred.rpc.server
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/8 11:19
 * @Version 1.0
 */

import com.fred.rpc.service.ServiceProvider;
import com.fred.rpc.util.serialize.JsonSerializer;
import com.fred.rpc.util.serialize.MyDecode;
import com.fred.rpc.util.serialize.MyEncode;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.AllArgsConstructor;

/**
 * 初始化，主要负责序列化的编码解码， 需要解决netty的粘包问题
 */
@AllArgsConstructor
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    private ServiceProvider serviceProvider;
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 使用自定义的编解码器
        pipeline.addLast(new MyDecode());
        // 编码需要传入序列化器，这里是json，还支持ObjectSerializer，也可以自己实现其他的
        pipeline.addLast(new MyEncode(new JsonSerializer()));

        pipeline.addLast(new NettyRPCServerHandler(serviceProvider));
    }
}
