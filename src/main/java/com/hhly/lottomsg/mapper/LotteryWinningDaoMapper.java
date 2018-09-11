package com.hhly.lottomsg.mapper;

import java.util.List;

import com.hhly.lottomsg.bo.LotteryWinningBO;
import com.hhly.lottomsg.vo.LotteryWinningVO;

/**
 * @desc 彩种奖项数据接口
 * @author YiJian
 * @date 2017年7月12日 上午10:07:43
 * @company 深圳益彩网络科技有限公司
 * @version v1.0
 */
public interface LotteryWinningDaoMapper {

	/**
	 * @desc 查询：单条记录
	 * @date 2017年2月24日
	 * @param lotteryWinningVO
	 *            参数对象
	 * @return 查询：单条记录
	 */
	LotteryWinningBO findSingle(LotteryWinningVO lotteryWinningVO);

	/**
	 * @desc 查询：多条记录
	 * @date 2017年2月24日
	 * @param lotteryWinningVO
	 *            参数对象
	 * @return 查询：多条记录
	 */
	List<LotteryWinningBO> findMultiple(LotteryWinningVO lotteryWinningVO);

}