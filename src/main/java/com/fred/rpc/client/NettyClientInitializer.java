package com.fred.rpc.client;

import com.fred.rpc.server.NettyRPCServerHandler;
import com.fred.rpc.service.ServiceProvider;
import com.fred.rpc.util.JsonSerializer;
import com.fred.rpc.util.MyDecode;
import com.fred.rpc.util.MyEncode;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * ClassName: NettyClientInitializer
 * Package: com.fred.rpc.client
 * Description:
 *
 * @Author Fred-Liu
 * @Create 2024/3/8 11:28
 * @Version 1.0
 */
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 使用自定义的编解码器
        pipeline.addLast(new MyDecode());
        // 编码需要传入序列化器，这里是json，还支持ObjectSerializer，也可以自己实现其他的
        pipeline.addLast(new MyEncode(new JsonSerializer()));

        pipeline.addLast(new NettyClientHandler());
    }
}
