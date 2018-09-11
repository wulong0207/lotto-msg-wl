package com.hhly.lottomsg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hhly.lottomsg.bo.IssueOfficialTimeBO;
import com.hhly.lottomsg.bo.NewIssueBO;
import com.hhly.lottomsg.bo.SportAgainstInfoBO;
import com.hhly.lottomsg.vo.LotteryVO;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc
 * @date 2017/5/31 15:49
 * @company 益彩网络科技公司
 */
public interface LotteryInfoMapper {

    /**
     * @desc 前端接口：用户中心-查询低频彩等待出票的官方出票时间段
     * @author huangb
     * @date 2017年4月19日
     * @param lotteryVO
     *            查询对象
     * @return 前端接口：用户中心-查询低频彩等待出票的官方出票时间段
     */
    IssueOfficialTimeBO findNumOfficialTime(LotteryVO lotteryVO);

    /**
     * @desc 前端接口：用户中心-查询高频彩等待出票的官方出票时间段
     * @author huangb
     * @date 2017年4月19日
     * @param lotteryVO
     *            查询对象
     * @return 前端接口：用户中心-查询高频彩等待出票的官方出票时间段
     */
    IssueOfficialTimeBO findHighOfficialTime(LotteryVO lotteryVO);

    /**
     * @desc 前端接口：用户中心-查询竞技彩等待出票的官方出票时间段
     * @author huangb
     * @date 2017年4月19日
     * @param lotteryVO
     *            查询对象
     * @return 前端接口：用户中心-查询竞技彩等待出票的官方出票时间段
     */
    List<IssueOfficialTimeBO> findSportOfficialTime(LotteryVO lotteryVO);

    /**
     * 获取彩期信息
     * @param lotteryCode
     * @param issueCode
     * @return
     */
    NewIssueBO findLotteryIssue(@Param("lotteryCode") int lotteryCode, @Param("issueCode") String issueCode);

    /**
     * 查询对阵信息
     * @param lotteryCode
     * @param issueCode
     * @param systemCode
     * @return
     */
	SportAgainstInfoBO querySportMatchInfo(@Param("lotteryCode") Integer lotteryCode, @Param("systemCode") String systemCode);


}
