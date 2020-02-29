package netty.demo.handler.echo;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * echo服务端处理器
 *
 * @author ywb
 * @date 2020/2/28 12:12
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelHandlerAdapter {
    int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //DelimiterBasedFrameDecoder分隔符解码器
//        String body = (String) msg;
//        System.out.println("This is " + ++counter + " times receive client : [" + body + "]");
//        body += "$_";
//        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
//        ctx.writeAndFlush(echo);

        //FixedLengthFrameDecoder固定长度解码器
        System.out.println("Receive client : [" + msg + "]");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        //发生异常，关闭链路
        ctx.close();
    }
}
