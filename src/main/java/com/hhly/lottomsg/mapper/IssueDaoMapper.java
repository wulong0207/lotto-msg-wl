package com.hhly.lottomsg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.IssueBO;
import com.hhly.lottomsg.bo.LotteryBO;
import com.hhly.lottomsg.vo.IssueVO;

public interface IssueDaoMapper {
	/***
	 * 
	 * @Description 查询彩期信息 
	 * @author HouXiangBao289
	 * @param vo
	 * @return
	 */
	IssueBO selectIssue(IssueVO vo);
	
	/***
	 * 
	 * @Description 查询数字彩当天销售截止彩期信息 
	 * @author HouXiangBao289
	 * @param vo
	 * @return
	 */
	List<IssueBO> selectTodaySaleEndIssues();
	
//	/**
//	 * 
//	 * @Description SP实时推送测试方法 
//	 * @author HouXiangBao289
//	 * @return
//	 */
//	List<Integer> findSalingMatchs();
	
	/**
	 * 
	 * @Description 查询当前期
	 * @author HouXiangBao289
	 * @return
	 */
	IssueBO selectLotCurIssue(@Param("lotteryCode")Integer lotteryCode);
	
	/**
	 * 
	 * @Description 查询彩种信息
	 * @author HouXiangBao289
	 * @param lotteryCode
	 * @return
	 */
	LotteryBO findLotteryInfo(@Param("lotteryCode")Integer lotteryCode);
}
