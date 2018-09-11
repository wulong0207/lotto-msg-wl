package com.hhly.lottomsg.socket;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hhly.lottomsg.bo.JczqTrendSpBO;
import com.hhly.lottomsg.common.enums.LotteryEnum;
import com.hhly.lottomsg.common.util.JsonUtil;
import com.hhly.lottomsg.rabbitmq.consume.JzSpEventListener;


@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class BaseEventListenerTest {

	/**
	 * 竞彩足球监听推送组件
	 */
	@Autowired
	private JzSpEventListener jzSpEventListener;
	
	@Test
	public void testSendToThirdjoinPush() {
		List<JczqTrendSpBO> list = new ArrayList<>();
		String[] tmp = new String[]{"4.98", "3.45", "6.99"};
		list.add(new JczqTrendSpBO(100L, tmp, "1:2"));
		tmp = new String[]{"2.98", "2.45", "2.99"};
		list.add(new JczqTrendSpBO(101L, tmp, "1:4"));
		
		String sp;
		try {
			sp = URLEncoder.encode(JsonUtil.objectToJcakJson(list),"UTF-8").replace("+", "%20");
			String rsMsg = jzSpEventListener.sendToThirdjoinPush(LotteryEnum.Lottery.FB.getName() + "",sp);
			System.out.println("推送服务结果：" + rsMsg);
		} catch (NoSuchAlgorithmException | IOException | URISyntaxException e) {
			e.printStackTrace();
			System.out.println("推送异常================================");
		}
	}
}
