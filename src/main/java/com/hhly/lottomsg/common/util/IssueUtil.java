package com.hhly.lottomsg.common.util;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.hhly.lottomsg.bo.CommissionBO;
import com.hhly.lottomsg.common.constants.Constants;
import com.hhly.lottomsg.common.constants.SymbolConstants;

/**
 * @author yuanshangbing
 * @version 1.0
 * @desc 抄单相关工具类
 * @date 2017/9/21 15:50
 * @company 益彩网络科技公司
 */
public class IssueUtil {
	
	
	 private static final Logger LOGGER = Logger.getLogger(IssueUtil.class);
    /***
     * 例子 13返回 10+
     * 10+、20+……90+
     100+、200+……900+
     1000+、2000+
     * @return
     */
    public static String replaceMantissa(Integer num){
    	if(ObjectUtil.isBlank(num) || num<0){return "0";}
        String numStr = String.valueOf(num);
        if(numStr.length()==1){
            return numStr;
        }
        switch (numStr.length()) {
            case 2:
                return mantissaStr(num,10,1);
            case 3:
                return mantissaStr(num,100,2);
            case 4:
                return mantissaStr(num,1000,3);
            case 5:
                return mantissaStr(num,10000,4);
            case 6:
                return mantissaStr(num,100000,5);
            case 7:
                return mantissaStr(num,1000000,6);
            case 8:
                return mantissaStr(num,10000000,7);
        }
        return "0";

    }

    /**
     *
     * @param num 原始数字
     * @param replaceNum 取模数字
     * @param places 补位数
     * @return
     */
    private static String mantissaStr(Integer num,Integer replaceNum,Integer places){
        String numStr = String.valueOf(num);
        if(num%replaceNum==0){
            return numStr;
        }else{
            String mantissa = mantissa(numStr);
            StringBuilder b = new StringBuilder();
            for(int i=0;i<places;i++){
                b.append("0");
            }
            return mantissa +b.toString() + "+";
        }
    }

    private static String mantissa(String numStr){
        String oneToTen[] = Constants.ONE_TEN;
        String one = numStr.substring(0,1);
        for(String num : oneToTen){
            if(num.equals(one)){
                return num;
            }
        }
        return "";
    }

    /**
     * 动态列表等展示时间
     * 小于１小时，X分钟前
     A、大于1小时间，小于24小时，则显示X小时前
     B、大于1天，小于5天，则显示X天前
     C、大于5天以上，刚显示发布时间年+月+日，如2017-08-31
     * @param issueDate
     * @return
     */
    public static String getShowDateStr(Date issueDate){
        String nowDateStr = DateUtil.getNow();
        String issueDateStr = DateUtil.convertDateToStr(issueDate);
        //{天, 时, 分, 秒}
        long s[] = DateUtil.getDistanceTimes(issueDateStr,nowDateStr);
        if(s[0]>=5){//大于等于5天以上，刚显示发布时间年+月+日，如2017-08-31
            return DateUtil.convertDateToStr(issueDate,DateUtil.DATE_FORMAT);
        }
        if(s[0]>=1 && s[0]<5){//大于等于1天，小于5天，则显示X天前
            return s[0]+"天前";
        }
        if(s[1]>=1 && s[1]<24){//大于等于1小时间，小于24小时，则显示X小时前
            return s[1]+"小时前";
        }
        //小于１小时，就显示显示５分钟前＼１５分钟前＼３０分钟前＼１小时前
        if(s[2]<60){
            return s[2]+"分钟前";
        }
		return "";
    }

    /**
     * 最高回报率
     */
    public static Double getMaxBackRate(Double maxWinAmount,Double betAmount){
    	if(!ObjectUtil.isBlank(maxWinAmount) && !ObjectUtil.isBlank(betAmount))
    			return NumberUtil.div(maxWinAmount,betAmount,2);
    	
    	LOGGER.error("***** getMaxBackRate Param NULL*****");
    	return 0D;
    }

    /**
     * 命中率/最大猜中
     */
    public static Double getWinRate(Double hitNum,Double issueNum){
    	if(!ObjectUtil.isBlank(hitNum) && !ObjectUtil.isBlank(issueNum))
    		return NumberUtil.div(hitNum,issueNum,2);
        
        LOGGER.error("***** getWinRate Param NULL*****");
    	return 0D;
    }

    /**
     * 盈利率
     * @param hitNum
     * @param issueNum
     * @return
     */
    public static Double profitRate(Double hitNum,Double issueNum){
    	if(!ObjectUtil.isBlank(hitNum) && !ObjectUtil.isBlank(issueNum)) {
    		Double profit = NumberUtil.sub(hitNum,issueNum);
            return NumberUtil.div(profit,issueNum,2);
    	}
    	
    	LOGGER.error("***** profitRate Param NULL*****");
    	return 0D;
    }

    /**
     * 组装最近战绩 中文字符串
     * @author longguoyou
     * @date 2017年10月14日
     * @param recentRecord
     * @return 近几场中几场，如:近10场中7场
     */
    public static String getRecentRecordStr(String recentRecord){
    	if(!ObjectUtil.isBlank(recentRecord)){
    		String[] records = recentRecord.split(SymbolConstants.DOUBLE_SLASH_VERTICAL_BAR);
    		if(records.length != 2){
    			return SymbolConstants.ENPTY_STRING;
    		}
    		return "近"+records[0]+"场中"+records[1]+"场";
		}
    	return SymbolConstants.ENPTY_STRING;
    }

    /**
     * 计算连红 连红(七场以内)，1代表胜，0代表负
     * @param result
     * @return
     */
    public static Integer joinRed(List<Integer> result){
        int count = 0;
        for(Integer str: result){
            if(str ==1 ){
                count = count+1;
            }else{
                return count;
            }
        }
        return count;
    }
    
    /**
     * 从投注内容获取过关方式
     * @author longguoyou
     * @date 2017年10月18日
     * @param betContent
     * @return
     */
	public static String getPasswayFromBetContent(String betContent) {
		StringBuffer sBuffer = new StringBuffer();
		Set<String> set = new HashSet<String>();
		String[] str = FormatConversionJCUtil.singleBetContentAnalysis(betContent);
		if(!ObjectUtil.isBlank(str) && str.length > 1){
			String[] passway = str[1].split(SymbolConstants.COMMA);
			for(String pw : passway){
				set.add(pw.replace(SymbolConstants.UNDERLINE, "串"));
			}
		}

		if(!ObjectUtil.isBlank(set)){
			for(String strPassway : set){
				sBuffer.append(strPassway);
				sBuffer.append(SymbolConstants.COMMA);
			}
			if(!ObjectUtil.isBlank(sBuffer.toString())){
				return sBuffer.toString().substring(0,sBuffer.toString().length()-1);
			}
		}
		return SymbolConstants.ENPTY_STRING;
	}

    /**
     * 最高回报率，盈利率
     * 1、当盈利率小于200%时，直接显示百分比数值
     * 2、当盈利率大于200%时，刚显示X.X倍
     * @return
     */
	public static String getPercentageStr(Double value){
		if(ObjectUtil.isBlank(value)){
			return SymbolConstants.ENPTY_STRING;
		}
        if(NumberUtil.compareTo(value,2)<0){
            return getOnlyPercent(value);
        }else{
            return getOnlyMultiple(value);
        }
    }
	
	/**
	 * 仅处理百分比
	 * @author longguoyou
	 * @date 2017年12月6日
	 * @param value
	 * @return
	 */
	public static String getOnlyPercent(Double value){
		if(ObjectUtil.isBlank(value)){
			return SymbolConstants.ENPTY_STRING;
		}
		Double value1 = NumberUtil.mul(value,100);
        return value1.intValue()+"%";
	}
	
	/**
	 * 仅处理倍数
	 * @author longguoyou
	 * @date 2017年12月6日
	 * @param value
	 * @return
	 */
	public static String getOnlyMultiple(Double value){
		if(ObjectUtil.isBlank(value)){
			return SymbolConstants.ENPTY_STRING;
		}
		return value + SymbolConstants.ENPTY_STRING;
	}
	
	/**
	 * 组装连红字符串
	 * @author longguoyou
	 * @date 2017年11月17日
	 * @param continueHit
	 * @return
	 */
	public static String getContinueHitStr(Integer continueHit){
		if(ObjectUtil.isBlank(continueHit)){
			return SymbolConstants.ENPTY_STRING;
		}
		return continueHit + "连红";
	}
	
	
	/**
	 * 获取总提成
	 * @author longguoyou
	 * @date 2017年12月1日
	 * @param listCommission
	 * @return
	 */
	public static String getSumCommission(List<CommissionBO> listCommission) {
		if(!ObjectUtil.isBlank(listCommission)){
			if(listCommission.get(0).getWinStatus() == 4){
				return "¥ " + MathUtil.round(listCommission.get(0).getCommissionAmount(), 2);
			}
			return SymbolConstants.DOUBLE_TRAVERSE_SLASH;
		}
		return SymbolConstants.DOUBLE_TRAVERSE_SLASH;
	}
	
	/**
	 * 处理本站截止时间
	 * @author longguoyou
	 * @date 2017年11月20日
	 * @param endTimeDb 
	 * @return
	 */
	public static String getEndTimeStr(Date endTimeDb) {
		if(DateUtil.compare(new Date(), endTimeDb) >= 0){
			return "已截止";
		}
		return DateUtil.convertDateToStr(endTimeDb, DateUtil.FORMAT_M_D_H_M) + "截止";
	}
	
	public static void main(String[] args) {

		System.out.println(profitRate(null, 1D));
    }

}
