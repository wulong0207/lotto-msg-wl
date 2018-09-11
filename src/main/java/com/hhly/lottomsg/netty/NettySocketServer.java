package com.hhly.lottomsg.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.hhly.lottomsg.rabbitmq.consume.BaseEventListener;

/**
 * 
* @Description: nettySocketServer 
* @author HouXiangBao289
* @date 2017年12月20日 下午2:26:58 
* @version V1.0.0
 */
@Component
public class NettySocketServer implements DisposableBean, Runnable {
    
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${websocket_ip}")
	private String socketIp;
	
	@Value("${websocket_host}")
	private int socketHost;
	
	@Override
	public void run() {
		Configuration config = new Configuration();
		config.setHostname(socketIp);
		config.setPort(socketHost);
		final SocketIOServer server = new SocketIOServer(config);
		addServerListener(server);
		// 启动服务
		server.start();
		logger.info("nettySocketServer已启动!");
	}
	
	/**
	 * 
	 * @Description 添加监听服务
	 * @author HouXiangBao289
	 * @param server
	 */
	private void addServerListener(SocketIOServer server){
		BaseEventListener.server = server;
		//开奖结果变更监听服务
//		DrawResultEventListener drawResultListener = new DrawResultEventListener();
//		drawResultListener.setServer(server);
//		server.addEventListener("getPushDrawResult", DrawResultData.class, drawResultListener);
		
		//竞足SP更新监听服务
//		JzSpEventListener jzListner = new JzSpEventListener();
//		jzListner.setServer(server);
//		server.addEventListener("getFootballSp", JzSpMessageData.class, jzListner);
		
		//竞篮SP更新监听服务
//		JlSpEventListener jlListner = new JlSpEventListener();
//		jlListner.setServer(server);
//		server.addEventListener("getPushBasketballSp",JlSpMessageData.class, jlListner);
	}
	
	@Override
	public void destroy() throws Exception {

	}

}
