package com.hhly.lottomsg.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.hhly.lottomsg.common.constants.UserConstants;

/**
 * @author lgs on
 * @version 1.0
 * @desc Number数字格式化工具类
 * @date 2017/3/16.
 * @company 益彩网络科技有限公司
 */
public class NumberFormatUtil {

    public static final String ONE_DECIMAL_POINT = "##.0";
    public static final String DEFAULT = "##";
    private static final String TOW_DECIMAL_POINT = "##.00";

    /**
     * 默认保留2位小数
     * @param number 数字
     * @return
     */
    public static String format(Number number){
        final NumberFormat nf = NumberFormat.getInstance();
        if(number == null) {
            return "";
        }
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大小数
        nf.setMaximumFractionDigits(2);

        nf.setMinimumFractionDigits(2);

        //设置最大小数
        nf.setMaximumIntegerDigits(10);
        return nf.format(number);
    }
    /**
     * 默认保留2位小数
     * @param number String
     * @return
     */
    public static String format(String innumber){
    
        final NumberFormat nf = NumberFormat.getInstance();
        if(innumber == null) {
            return "";
        }
    	Double number = Double.valueOf(innumber);
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大小数
        nf.setMaximumFractionDigits(2);

        nf.setMinimumFractionDigits(2);

        //设置最大小数
        nf.setMaximumIntegerDigits(10);
        return nf.format(number);
    }

    /**
     * 格式化数子
     * @param number 数字
     * @return
     */
    public static String formatMaximum(Number number,int maximumFractionDigits){
        final NumberFormat nf = NumberFormat.getInstance();
        if(number == null) {
            return "";
        }
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大小数
        nf.setMaximumFractionDigits(maximumFractionDigits);

        nf.setMinimumFractionDigits(maximumFractionDigits);

        //设置最大小数
        nf.setMaximumIntegerDigits(10);
        return nf.format(number);
    }

    /**
     * 保留2位小数
     *
     * @param number 数字
     * @return
     */
    public static String format(Number number, String format) {
        final NumberFormat df2 = new DecimalFormat(format);
        if (number == null) {
            return "";
        }
        return df2.format(number);
    }


    /**
     * 格式化数字 左边补零
     *
     * @param number 需要格式化数字 10
     * @param length 格式化长度 4
     * @return 0010
     */
    public static String formatZeroFill(Number number, int length) {
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(length);
        //设置最小整数位数
        nf.setMinimumIntegerDigits(length);
        return nf.format(number);
    }


    /***************lotto-core中工具类 迁移  20171107**************/
    public static String dispose(Double prebonus) {

        String str = "";
        if (prebonus < UserConstants.TEN_THOUSANT) {
            return formatAmountToStr(prebonus) + UserConstants.YUAN;
        } else if (prebonus >= UserConstants.TEN_THOUSANT && prebonus < UserConstants.HUNDRED_MILLIONS) {
            return MathUtil.formatAmountToStr(prebonus/UserConstants.TEN_THOUSANT) + UserConstants.TEN_THOUSANT_STR + UserConstants.YUAN;
        } else {
            return MathUtil.formatAmountToStr(prebonus/UserConstants.HUNDRED_MILLIONS) + UserConstants.HUNDRED_MILLIONS_STR+ UserConstants.YUAN;
        }
    }

    public static String formatAmountToStr(Double amount) {
        if (MathUtil.compareTo(amount, 1.0) < 0) {
            return String.valueOf(amount);
        }
        DecimalFormat myformat = new DecimalFormat();
        myformat.applyPattern("#,###.##");
        try {
            return myformat.format(amount);
        } catch (Exception e) {
            return String.valueOf(amount);
        }
    }


    public static void main(String[] args) {
        System.out.println(formatZeroFill(10, 4));
        System.out.println(formatMaximum(000.0005, 1));
    }
}

