package com.hhly.lottomsg.common.util;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
/**
 * 
 * @desc 精确计算工具
 * @author zhanglei
 * @date 2017-2-6
 * @company 益彩网络科技公司
 * @version 1.0
 */
public final class MathUtil {

	private static final int DEF_DIV_SCALE = 10;

	/**
	 * 提供精度的比较运算
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 * A小于B,-1:A等于B,0:A大于B:1
	 */
	public static int compareTo(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.compareTo(b2);
	}
	
	/**
	 * 
	 * 提供精确的加法运算。
	 * 
	 * @param 	v1	被加数
	 * @param 	v2	加数
	 * @return 两个参数的和
	 */

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * 
	 * @param v2
	 *            减数
	 * 
	 * @return 两个参数的差
	 */

	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).setScale(2,BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}
	/**
	 * 
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * 
	 * @param v2
	 *            减数
	 * 
	 * @return 两个参数的差
	 */

	public static double sub(double v1, double v2,int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).setScale(scale,BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}
	/**
	 * 
	 * 提供精确的乘法运算。
	 * 
	 * @param 	v1	被乘数
	 * @param 	v2	乘数
	 * @return 两个参数的积
	 */

	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).setScale(2,BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}

	/**
	 * 
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
	 * 
	 * 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * 
	 * @param v2
	 *            除数
	 * 
	 * @return 两个参数的商
	 */

	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 
	 * 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * 
	 * @param v2
	 *            除数
	 * 
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * 
	 * @return 两个参数的商
	 */

	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		if(v2 == 0  || v1 ==0){
			return 0;
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * 
	 * @param scale
	 *            小数点后保留几位
	 * 
	 * @return 四舍五入后的结果
	 */

	public static double round(double v, int scale) {
		return round(v, scale, RoundingMode.HALF_UP);
	}

	/**
	 * 截断
	 * 
	 * 提供精确的小数位舍入处理。
	 * 
	 * @param v
	 *            需要舍入的数字
	 * 
	 * @param scale
	 *            小数点后保留几位
	 * 
	 * @return 舍入后的结果
	 */

	public static double round(double v, int scale, RoundingMode mode) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(v);
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, mode).doubleValue();
	}

	/**
	 * 金额截断, 保留小数2位
	 * 
	 * @param money
	 * @return
	 */
	public static double truncate(double money) {
		return new BigDecimal(Double.toString(money)).setScale(2,
				BigDecimal.ROUND_DOWN).doubleValue();
	}
	
	/**  
	* 方法说明: 给定一个金额，得到减去相应手续费后的金额
	* @auth: xiongJinGang
	* @param money 传入金额
	* @param fee 手续费，double类型，0.2表示20%
	* @time: 2017年3月24日 下午4:58:12
	* @return: double 
	*/
	public static double calCounterFee(double money, double fee) {
		double feeDou = calServiceFee(money, fee);
		return sub(money, feeDou, 2);
	}
	
	/**  
	* 方法说明: 获取手续费
	* @auth: xiongJinGang
	* @param money
	* @param fee
	* @time: 2017年4月5日 下午3:55:58
	* @return: double 
	*/
	public static double calServiceFee(double money, double fee) {
		return mul(money, fee);
	}
	
	/**  
	* 方法说明: 3个金额相加
	* @auth: xiongJinGang
	* @param moneyOne
	* @param moneyTwo
	* @param moneyThree
	* @time: 2017年4月5日 下午3:59:35
	* @return: double 
	*/
	public static double add(double moneyOne, double moneyTwo,double moneyThree) {
		return add(moneyOne, add(moneyTwo, moneyThree));
	}
	
	/**
     * 四舍六入
     * @param mod
     * @param big
     * @return
     */
    public static double cauScale4Down6Up(int mod,BigDecimal big){
        //四舍六入
        if(mod<=0 || big.compareTo(BigDecimal.valueOf(0))<=0){
            return big.doubleValue();
        }
        String mathstr = String.valueOf(big.doubleValue()).toString();
        int dian = mathstr.indexOf(".");
        if(dian>0 && mathstr.length()- dian-1 >mod){
            String base = mathstr.substring(0,dian);
            String adress = mathstr.substring(dian+1,mathstr.length());
            if(adress.length()<=mod){
                base = base+"."+adress;
            }else if(adress.length()>=mod+1){
                int v = Integer.valueOf(adress.substring(mod,mod+1));//精确位小数后一位
                int v1 = Integer.valueOf(adress.substring(mod-1,mod));//精确位小数。
                int m =0 ;//是否需要进位。
                if(v>=6){ //精确位后大于等于6，精确位进一
                    m++;
                }else if(v<=4){//精确位后小于等于4，精确位后舍弃
                }else if(v==5 && v1%2==0){//精确位后为5时，精确位前为偶时，精确位后一位舍弃。
                }else if(v==5 && v1%2==1){//精确位后为5时，精确位前为奇时，精确位进一
                    m++;
                }
                String s =adress.substring(0,mod-1);
                base = base+"."+s+v1;
                if(m>0){
                    big = BigDecimal.valueOf(Double.valueOf(base)).add(BigDecimal.valueOf(Math.pow(0.1, mod)));
                }else{
                    big = BigDecimal.valueOf(Double.valueOf(base));
                }
            }
        } 
        return big.doubleValue();
    }
    
    /**
     * 去掉数据尾部无效数据  15.0 -> 15 , 0.0 -> ""
     * @param t
     * @return
     */
    public static String  getNum(double t){
		DecimalFormat df1 = new DecimalFormat("##.##");
		String f = df1.format(t)+"%";
		return f.replace(".0%", "%").replace("%", "");
	}
    /**
     * 去掉数据尾部无效数据  0.0->0
     * @param t
     * @return
     */
    public static String getNumDefaultZero(double t){
    	String retStr = getNum(t);
    	if(retStr==null || "".equals(retStr)){
    		return "0";
    	}
    	return retStr;
    }
    
    /**  
    * 方法说明: 格式化金额，显示方式10,000
    * @auth: xiongJinGang
    * @param amount
    * @time: 2017年4月20日 下午12:05:11
    * @return: String 
    */
	public static String formatAmountToStr(Double amount) {

        if (ObjectUtil.isBlank(amount)) {
            return "0.00";
        }

		if (compareTo(amount, 1.0) < 0) {
			return String.valueOf(amount);
		}
		DecimalFormat myformat = new DecimalFormat();
		myformat.applyPattern("##,###.00");
		try {
			return myformat.format(amount);
		} catch (Exception e) {
			return String.valueOf(amount);
		}
	}
	
	/**  
	* 方法说明: 格式化金额，保留2位小数
	* @auth: xiongJinGang
	* @param amount
	* @time: 2017年10月27日 下午12:18:44
	* @return: String 
	*/
	public static String formatAmount(Double amount) {
        if (ObjectUtil.isBlank(amount)) {
            return "0.00";
        }

		DecimalFormat myformat = new DecimalFormat("######0.00");
		try {
			return myformat.format(amount);
		} catch (Exception e) {
			return String.valueOf(amount);
		}
	}
	

	/**  
	* 方法说明: 将带格式的金额转成double类型
	* @auth: xiongJinGang
	* @param amount 1,000.00
	* @throws ParseException
	* @time: 2017年4月20日 下午12:14:42
	* @return: Double 
	*/
	public static Double formatAmountToDouble(String amount) throws ParseException {
		DecimalFormat myformat = new DecimalFormat();
		return myformat.parse(amount).doubleValue();
	}
	/**
	 * 
	 * 乘法运算。金额直接截断, 保留小数2位
	 * 
	 * @param 	v1	被乘数
	 * @param 	v2	乘数
	 * @return 两个参数的积
	 */

	public static double mulRoundDown(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).setScale(2,BigDecimal.ROUND_DOWN).doubleValue();
	}
}

