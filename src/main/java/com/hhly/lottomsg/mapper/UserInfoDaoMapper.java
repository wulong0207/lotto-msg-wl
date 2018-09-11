package com.hhly.lottomsg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.GuessUserInfoBO;
import com.hhly.lottomsg.bo.UserInfoBO;

public interface UserInfoDaoMapper {
	 
		
		/**
		 * 
		 * @Desc 查询有效用户个数
		 * @return
		 */
		int findValidUserInfoCount();
		
		/**
		 * 
		 * @Desc 分次查询有效用户列表
		 * @param list
		 * @param begin
		 * @param end
		 * @return
		 */
		List<UserInfoBO> findValidUserInfo(@Param("begin") Integer begin,@Param("pageSize") Integer pageSize);
		
		/**
		 * 
		 * @Description 查询购买已淘汰球队的订单用户 
		 * @author HouXiangBao289
		 * @param lotteryCode
		 * @param systemCodeLike
		 * @return
		 */
		List<UserInfoBO> findObsoletedUsers(@Param("lotteryCode") String lotteryCode,@Param("systemCodeLike") String systemCodeLike);
		
		/**
		 * 
		 * @Desc 根据用户id集合分次查询用户列表
		 * @CreatDate 2017年4月14日 下午2:28:46
		 * @param list
		 * @return
		 */
		List<UserInfoBO> findUserInfoByIds(@Param("list") List<Integer> list);
		
		/**
		 * 
		 * @Description 查询专家粉丝 
		 * @author HouXiangBao289
		 * @param userIssueId
		 * @return
		 */
		List<UserInfoBO> findUserFans(@Param("userIssueId") Integer userIssueId);
		
		/**
		 * 
		 * @Desc 根据用户id查询用户
		 * @CreatDate 2017年4月14日 下午2:28:46
		 * @param id
		 * @return
		 */
		UserInfoBO findUserInfoById(@Param("id") Integer id);

		/**
		 * 
		 * @Description 获取今天生日用户
		 * @author HouXiangBao289
		 * @return
		 */
		List<UserInfoBO> findBirthdayUser();
		
		/**
		 * 
		 * @Description 1、注册第N天未登录：未实名认证用户注册第N天未进行登录
		 * @author HouXiangBao289
		 * @param days 天数
		 * @return
		 */
		List<UserInfoBO> findCon1Users(@Param("days") Integer days);
		
		/**
		 * 
		 * @Description 2、注册第N天未下单：未实名认证用户注册第N天未进行任何订单下单
		 * @author HouXiangBao289
		 * @param days 天数
		 * @return
		 */
		List<UserInfoBO> findCon2Users(@Param("days") Integer days);
		
		/**
		 * 
		 * @Description 3、注册（未实名认证）第N天有下单但未购买：未实名认证用户注册第N天有进行下单，但并未支付购买
		 * @author HouXiangBao289
		 * @param days 天数
		 * @return
		 */
		List<UserInfoBO> findCon3Users(@Param("days") Integer days);
		
		/**
		 * 
		 * @Description 4、注册并实名认证后第N天未购买：已实名认证用户注册第N天有下单，但并未支付购买
		 * @author HouXiangBao289
		 * @param days 天数
		 * @return
		 */
		List<UserInfoBO> findCon4Users(@Param("days") Integer days);
		
		/**
		 * 
		 * @Description 5、注册(不区分实名)第N天未购买：所有注册用户（不区分实名）第N天天有进行下单，但并未支付购买
		 * @author HouXiangBao289
		 * @param days 天数
		 * @return
		 */
		List<UserInfoBO> findCon5Users(@Param("days") Integer days);
		
		/**
		 * 
		 * @Description 6、首单第N天未二单：用户第一个订单成功后第N天未进行下一个成功订单
		 * @author HouXiangBao289
		 * @param days 天数
		 * @return
		 */
		List<UserInfoBO> findCon6Users(@Param("days") Integer days);
		
		/**
		 * 
		 * @Description 7、首单15-30天内无第二单：用户第一个订单成功后第N天~第N天之间未进行下一个成功订单
		 * @author HouXiangBao289
		 * @param startDays 第N天
		 * @param endDays 至第N天
		 * @return
		 */
		List<UserInfoBO> findCon7Users(@Param("startDays") Integer startDays,@Param("endDays") Integer endDays);
		
		/**
		 * 
		 * @Description 8、距上单30到50天未登录：用户距离上一个成功订单第N天~第N天未进行登录  (且距上登录时间第N天~第N天)
		 * @author HouXiangBao289
		 * @param startDays 第N天
		 * @param endDays 至第N天
		 * @param lotteryCode 彩种id
		 * @return
		 */
		List<UserInfoBO> findCon8Users(@Param("lotteryCode") Integer lotteryCode,@Param("startDays") Integer startDays,@Param("endDays") Integer endDays);
		
		/**
		 * 
		 * @Description 9、距上单30到50天未购买：用户距离上一个成功订单第N天~第N天未进行购买
		 * @author HouXiangBao289
		 * @param startDays 第N天
		 * @param endDays 至第N天
		 * @param lotteryCode 彩种id
		 * @return
		 */
		List<UserInfoBO> findCon9Users(@Param("lotteryCode") Integer lotteryCode,@Param("startDays") Integer startDays,@Param("endDays") Integer endDays);
		
		/**
		 * 
		 * @Description 10、账户余额X元距离上单X天未购买：用户余额N元以上距离上一订单第N天未.进行购买
		 * @author HouXiangBao289
		 * @param startDays 第N天
		 * @param userBalance 用户账户余额
		 * @param lotteryCode 彩种id
		 * @return
		 */
		List<UserInfoBO> findCon10Users(@Param("lotteryCode") Integer lotteryCode,@Param("startDays") Integer startDays,@Param("userBalance") Double userBalance);
		
		/**
		 * 
		 * @Description 11、距上单15到30天未购买（低客单）：上单金额N元以下用户，第N天~第N天未购买
		 * @author HouXiangBao289
		 * @param startDays 第N天
		 * @param endDays 至第N天
		 * @param lotteryCode 彩种id
		 * @param orderMoney 设置订单金额阀值
		 * @return
		 */
		List<UserInfoBO> findCon11Users(@Param("orderMoney") Double orderMoney,@Param("lotteryCode") Integer lotteryCode,@Param("startDays") Integer startDays,@Param("endDays") Integer endDays);
		
		
		/**
		 * 
		 * @Description 12、距上单30到50天未购买（高客单）：上单金额N元以上用户，第N天~第N天未购买
		 * @author HouXiangBao289
		 * @param startDays 第N天
		 * @param endDays 至第N天
		 * @param lotteryCode 彩种id
		 * @param orderMoney 设置订单金额阀值
		 * @return
		 */
		List<UserInfoBO> findCon12Users(@Param("orderMoney") Double orderMoney,@Param("lotteryCode") Integer lotteryCode,@Param("startDays") Integer startDays,@Param("endDays") Integer endDays);
		
		/**
		 * 
		 * @Description 12、购彩平均值X元X天未购买：shang月度购彩金额平率N元以上用户，第N天~第N天未购买
		 * @author HouXiangBao289
		 * @param startDays 第N天
		 * @param endDays 至第N天
		 * @param orderMoney 设置订单金额阀值
		 * @return
		 */
		List<UserInfoBO> findCon13Users(@Param("orderMoney") Double orderMoney,@Param("startDays") Integer startDays,@Param("endDays") Integer endDays);
		
		/**
		 * 
		 * @Description 获取多账号绑定同一手机号码(去重)
		 * @author HouXiangBao289
		 * @return
		 */
		List<String> findUserSameMobile();

		/**
		 * 
		 * @param lotteryCode
		 * @param string
		 * @return
		 */
		List<GuessUserInfoBO> findBallGameGuessUsers(@Param("activityCode")String activityCode,@Param("lotteryCode")int lotteryCode,@Param("systemCode") String systemCode);
}
