package com.hhly.lottomsg.rabbitmq.provider;

/**
 * 发送消息到队列
 *
 * @author yuanshangbing
 * @create 2017/5/22 17:14
 */
public interface MessageProvider {
    /**
     * 发送消息
     * @param queueKey 队列名
     * @param message  消息
     */
    public void sendMessage(String queueKey, Object message);
}
