package com.hhly.lottomsg.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.hhly.lottomsg.common.constants.Constants;

/**
 * @author Administrator
 *
 * @Date 2016年12月8日
 *
 * @Desc 日期工具类
 */
public class DateUtil {

	public static Logger logger = Logger.getLogger(DateUtil.class);

	/** 定义格式 **/
	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_FORMAT_OBLIQUE_LINE = "yyyy/MM/dd HH:mm:ss";
	public static final String DATE_FORMAT_YY_MM_DD_HH_MM_SS = "yy-MM-dd HH:mm:ss";
	public static final String DATETIME_FORMAT_NO_SEC = "yyyy-MM-dd HH:mm";
	public static final String FORMAT_YYYY_MM = "yyyy-MM";
	public static final String FORMAT_YYYYMM = "yyyyMM";
    public static final String FORMAT_YYYY = "yyyy";
    public static final String FORMAT_YY = "yy";
    public static final String FORMAT_YYMMDD = "yyMMdd";
	public static final String FORMAT_MM_DD = "MM-dd";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_FORMAT_NO_LINE = "yyyyMMdd";
	public static final String DATE_FORMAT_LINE = "yyyyMMdd HH:mm:ss";
	public static final String TIME = "HH:mm:ss";
	public static final String DATA_FORMAT_SIMPLE = "yyMMddHHmmss";
	public static final String DATE_FORMAT_NUM = "yyyyMMddHHmmss";
	public static final String DATE_MMM_D_YYYY_K_M_S_S = "MMM d, yyyy K:m:s a";
	public static final String FORMAT_CHINESE_DAY = "MM月dd日 HH:mm:ss";
	public static final String FORMAT_CHINESE_YYYYMM = "yyyy年MM月";
	public static final String FORMAT_POINT_YYYYMMDD = "yyyy.MM.dd";
	public static final String FORMAT_M_D_H_M = "MM-dd HH:mm";
	public static final String FORMAT_M_D_H_M_S = "MM-dd HH:mm:ss";
	public static final String FORMAT_H_M = "HH:mm";
	public static final String DATE_SEPARATOR = "-";
	
	/**
	 * 北京单场销售暂停时间
	 */
	public static final String DATETIME_FORMAT_BJ_SALE_END_START_TIME = "yyyy-MM-dd 06:00";
	/**
	 * 北京单场销售开始时间
	 */
	public static final String DATETIME_FORMAT_BJ_SALE_START_TIME = "yyyy-MM-dd 09:45";
	
    /**
     * 周几map
     */
    public static final Map<Integer, String> weekTxtMap = new HashMap<>(7);

    static {
        weekTxtMap.put(1, "周一");
        weekTxtMap.put(2, "周二");
        weekTxtMap.put(3, "周三");
        weekTxtMap.put(4, "周四");
        weekTxtMap.put(5, "周五");
        weekTxtMap.put(6, "周六");
        weekTxtMap.put(7, "周日");
    }
    
	/**
	 * @return 根据默认格式(yyyy-MM-dd HH:mm:ss)获取当前时间
	 */
	public static String getNow() {
		return new SimpleDateFormat(DEFAULT_FORMAT).format(new Date());
	}

	/**
	 * 方法说明: 获取当前时间Date类型
	 * 
	 * @auth: xiongJinGang
	 * @param format
	 *            格式化
	 * @time: 2017年5月9日 下午6:39:31
	 * @return: Date
	 */
	public static Date getNowDate(String format) {
		Date date = new Date();
		if (ObjectUtil.isBlank(format)) {
			return date;
		}
		return convertStrToDate(convertDateToStr(date, format), format);
	}

	/**
	 * 方法说明: 获取当前时间，返回日期类型
	 * 
	 * @auth: xiongJinGang
	 * @time: 2017年5月17日 上午10:51:14
	 * @return: Date
	 */
	public static Date getNowDate() {
		return getNowDate(null);
	}

	/**
	 * @param format
	 *            - 日期格式
	 * @return 根据参数日期格式获取当前时间
	 */
	public static String getNow(String format) {
		SimpleDateFormat sdf = null;
		if (null == format || "".equals(format)) {
			sdf = new SimpleDateFormat(DEFAULT_FORMAT);
		} else {
			sdf = new SimpleDateFormat(format);
		}
		return sdf.format(new Date());
	}

	public static String getYesterday(String format) {
		SimpleDateFormat sdf = null;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		if (null == format || "".equals(format)) {
			sdf = new SimpleDateFormat(DEFAULT_FORMAT);
		} else {
			sdf = new SimpleDateFormat(format);
		}
		return sdf.format(cal.getTime());
	}

	/**
	 * 方法说明: 字符串日期转成想要的格式
	 * 
	 * @auth: xiongJinGang
	 * @param date
	 *            20091225091010
	 * @param nowFormat
	 *            当前格式
	 * @param targetFormat
	 *            目标格式
	 * @time: 2017年5月5日 下午8:14:23
	 * @return: String
	 */
	public static String convertStrToTarget(String date, String nowFormat, String targetFormat) {
		SimpleDateFormat dFormat = new SimpleDateFormat(nowFormat);
		Date newDate = null;
		try {
			newDate = dFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (newDate != null) {
			SimpleDateFormat target = new SimpleDateFormat(targetFormat);
			date = target.format(newDate);
		}
		return date;
	}

	/**
	 * @param str
	 *            字符型日期
	 * @return 根据默认格式(yyyy-MM-dd HH:mm:ss)获取日期
	 */
	public static Date convertStrToDate(String str) {
		return convertStrToDate(str, DEFAULT_FORMAT);
	}

	/**
	 * @param str
	 *            日期字符串
	 * @param format
	 *            格式
	 * @return 获取指定格式日期对象
	 * @Desc 获取指定格式日期对象
	 */
	public static Date convertStrToDate(String str, String format) {
		try {
			if (null == str || "".equals(str)) {
				return null;
			}
			return new SimpleDateFormat(format).parse(str);
		} catch (ParseException e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	/**
	 * 日期格式转换
	 * 
	 * @param str
	 *            日期格式
	 * @param format
	 * @return
	 * @throws NullPointerException()，ServiceRuntimeException（转换异常）
	 */
	public static Date convertStrToDate2(String str, String format) {
		try {
			if (null == str || "".equals(str)) {
				throw new NullPointerException("日期参数为空");
			}
			return new SimpleDateFormat(format).parse(str);
		} catch (ParseException e) {
			throw new RuntimeException("日期转换异常：" + e.getMessage());
		}
	}

	/**
	 * @param date
	 *            日期对象
	 * @return 默认格式的日期字符串
	 * @Desc 日期对象转为字符串
	 */
	public static String convertDateToStr(Date date) {
		return convertDateToStr(date, DEFAULT_FORMAT);
	}

	/**
	 * @param date
	 *            日期对象
	 * @param format
	 *            格式
	 * @return 指定格式的日期字符串
	 * @Desc 日期对象转为指定格式字符串
	 */
	public static String convertDateToStr(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = null;
		if (null == format || "".equals(format)) {
			sdf = new SimpleDateFormat(DEFAULT_FORMAT);
		} else {
			sdf = new SimpleDateFormat(format);
		}
		return sdf.format(date);
	}
	
	/**
	 * @param date
	 *            日期对象
	 * @param format
	 *            格式
	 * @return 指定格式的日期字符串
	 * @Desc 日期对象转为指定格式字符串
	 */
	public static String convertDateToStr(String date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = null;
		if (null == format || "".equals(format)) {
			sdf = new SimpleDateFormat(DEFAULT_FORMAT);
		} else {
			sdf = new SimpleDateFormat(format);
		}
		return sdf.format(date);
	}	

	/**
	 * 方法说明: 得到前后几天的日期，num为正整数，则是后几天，为负整数，则是前几天
	 * 
	 * @auth: xiongJinGang
	 * @param num
	 * @time: 2017年4月19日 下午2:56:04
	 * @return: String
	 */
	public static String getBeforeOrAfterDate(int num) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, num);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 方法说明: 得到前后几天的日期，num为正整数，则是后几天，为负整数，则是前几天
	 * 
	 * @auth: xiongJinGang
	 * @param num
	 * @param format
	 * @time: 2017年4月26日 下午5:16:30
	 * @return: String
	 */
	public static String getBeforeOrAfterDate(int num, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, num);
		return new SimpleDateFormat(format).format(cal.getTime());
	}
	
	public static String getBeforeOrAfterYearForString(int num, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, num);
		return new SimpleDateFormat(format).format(cal.getTime());
	}

	/**
	 * 方法说明: 得到前后几年的当天日期，num为正整数，则是后几年，为负整数，则是前几年
	 * 
	 * @auth: xiongJinGang
	 * @param num
	 * @param format
	 * @time: 2017年6月13日 下午2:41:37
	 * @return: Date
	 */
	public static Date getBeforeOrAfterYear(int num, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, num);
		String addResult = new SimpleDateFormat(format).format(cal.getTime());
		return convertStrToDate(addResult);
	}

	/**
	 * @return 秒值
	 * @Desc 获取当前时间的秒值
	 */
	public static int getSecOfNow() {
		return getFieldVal(new Date(), Calendar.SECOND);
	}

	/**
	 * @param date
	 *            日期对象
	 * @return 秒值
	 * @Desc 获取指定日期的秒值
	 */
	public static int getSec(Date date) {
		return getFieldVal(date == null ? new Date() : date, Calendar.SECOND);
	}

	/**
	 * @return 分值
	 * @Desc 获取当前时间的分值
	 */
	public static int getMinOfNow() {
		return getFieldVal(new Date(), Calendar.MINUTE);
	}

	/**
	 * @param date
	 *            日期对象
	 * @return 分值
	 * @Desc 获取指定日期的分值
	 */
	public static int getMin(Date date) {
		return getFieldVal(date == null ? new Date() : date, Calendar.MINUTE);
	}

	/**
	 * @param date
	 *            日期对象
	 * @return 日值
	 * @Desc 获取指定日期的日值
	 */
	public static int getDay(Date date) {
		return getFieldVal(date == null ? new Date() : date, Calendar.DATE);
	}

	/**
	 * @return 小时
	 * @Desc 获取当前时间的小时值
	 */
	public static int getHourOfNow() {
		return getFieldVal(new Date(), Calendar.HOUR_OF_DAY);
	}

	/**
	 * @return 日值
	 * @Desc 获取当前时间的日值
	 */
	public static int getDayOfNow() {
		return getFieldVal(new Date(), Calendar.DATE);
	}

	/**
	 * @return 年值
	 * @Desc 获取当前时间的年值
	 */
	public static int getYearOfNow() {
		return getFieldVal(new Date(), Calendar.YEAR);
	}

	/**
	 * @param date
	 *            日期对象
	 * @return 年值
	 * @Desc 获取指定日期的年值
	 */
	public static int getYear(Date date) {
		return getFieldVal(date == null ? new Date() : date, Calendar.YEAR);
	}

	/**
	 * @param date
	 *            日期对象
	 * @param field
	 *            日期字段(eg：YEAR，MINUTE，SECOND，DAY_OF_WEEK 等)
	 * @return 指定日期的指定字段值
	 * @Desc 获取指定日期的指定字段值
	 */
	public static int getFieldVal(Date date, int field) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(field);
	}

	/**
	 * @param startDate
	 *            开始日期
	 * @param includeDays
	 *            包含的天集合,即需要哪几天的日期(只能指定SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	 *            THURSDAY, FRIDAY, SATURDAY对应的字段值)
	 * @param count
	 *            日期列表數量
	 * @return 日期列表,从指定的开始日期往后，获取一周中指定的那几天日期，组合一个日期集合返回
	 * @Desc 从指定的开始日期往后，获取一周中指定的几天日期的集合列表
	 */
	public static List<Date> getDaysOfWeek(Date startDate, Integer[] includeDays, int count) {
		return getDaysOfWeek(startDate, includeDays, count, null);
	}

	/**
	 * @param startDate
	 *            开始日期
	 * @param includeDays
	 *            包含的天集合,即需要哪几天的日期(只能指定SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	 *            THURSDAY, FRIDAY, SATURDAY对应的字段值)
	 * @param count
	 *            日期列表數量
	 * @param filterDays
	 *            需要过滤的天集合(即符合条件的天不能存在于该过滤列表中)
	 * @return 日期列表,从指定的开始日期往后，获取一周中指定的那几天日期，组合一个日期集合返回
	 * @Desc 从指定的开始日期往后，获取一周中指定的几天日期的集合列表
	 */
	public static List<Date> getDaysOfWeek(Date startDate, Integer[] includeDays, int count, List<Date> filterDays) {
		if (startDate == null || includeDays == null || includeDays.length == 0 || count == 0) {
			return new ArrayList<Date>();
		}
		List<Integer> dayList = Arrays.asList(includeDays);
		if (!(dayList.contains(Calendar.SUNDAY) || dayList.contains(Calendar.MONDAY)
				|| dayList.contains(Calendar.TUESDAY) || dayList.contains(Calendar.WEDNESDAY)
				|| dayList.contains(Calendar.THURSDAY) || dayList.contains(Calendar.FRIDAY)
				|| dayList.contains(Calendar.SATURDAY))) {
			return new ArrayList<Date>();
		}
		List<Date> target = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		while (true) {
			if (count == target.size()) {
				break;
			}
			// 如果是需要过滤的日期
			if (filterDays != null && !filterDays.isEmpty() && filterDays.contains(cal.getTime())) {
				cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
				continue;
			}
			// 是否是符合的天
			int temp = cal.get(Calendar.DAY_OF_WEEK);
			if (dayList.contains(temp)) {
				target.add(cal.getTime());
			}
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
		}
		return target;
	}

	/**
	 * @param startDate
	 *            开始日期
	 * @param includeDays
	 *            包含的天集合,即需要哪几天的日期(只能指定SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	 *            THURSDAY, FRIDAY, SATURDAY对应的字段值)
	 * @param count
	 *            日期列表數量
	 * @param filterStart
	 *            过滤日期范围：开始日期
	 * @param filterEnd
	 *            过滤日期范围：结束日期
	 * @return 日期列表,从指定的开始日期往后，获取一周中指定的那几天日期，组合一个日期集合返回
	 * @Desc 从指定的开始日期往后，获取一周中指定的几天日期的集合列表
	 */
	public static List<Date> getDaysOfWeek(Date startDate, Integer[] includeDays, int count, Date filterStart,
			Date filterEnd) {
		if (startDate == null || includeDays == null || includeDays.length == 0 || count == 0) {
			return new ArrayList<Date>();
		}
		List<Integer> dayList = Arrays.asList(includeDays);
		if (!(dayList.contains(Calendar.SUNDAY) || dayList.contains(Calendar.MONDAY)
				|| dayList.contains(Calendar.TUESDAY) || dayList.contains(Calendar.WEDNESDAY)
				|| dayList.contains(Calendar.THURSDAY) || dayList.contains(Calendar.FRIDAY)
				|| dayList.contains(Calendar.SATURDAY))) {
			return new ArrayList<Date>();
		}
		List<Date> target = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		while (true) {
			if (count == target.size()) {
				break;
			}
			// 如果是需要过滤的日期范围
			if (filterStart != null && filterEnd != null && cal.getTime().compareTo(filterStart) >= 0
					&& cal.getTime().compareTo(filterEnd) <= 0) {
				cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
				continue;
			}
			// 是否是符合的天
			int temp = cal.get(Calendar.DAY_OF_WEEK);
			if (dayList.contains(temp)) {
				target.add(cal.getTime());
			}
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
		}
		return target;
	}

	/**
	 * 根据当前日期获得上周的日期区间（上周周一和周日日期）
	 * 
	 * @return
	 * @author wuLong
	 */
	public static Date[] getLastTimeInterval() {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
		int offset1 = 1 - dayOfWeek;
		int offset2 = 7 - dayOfWeek;
		calendar1.add(Calendar.DATE, offset1 - 7);
		calendar2.add(Calendar.DATE, offset2 - 7);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		// System.out.println(sdf.format(calendar1.getTime()));// last Monday
		String lastBeginDate = sdf.format(calendar1.getTime());
		// System.out.println(sdf.format(calendar2.getTime()));// last Sunday
		String lastEndDate = sdf1.format(calendar2.getTime());
		Date[] dates = new Date[2];
		dates[0] = convertStrToDate(lastBeginDate);
		dates[1] = convertStrToDate(lastEndDate);
		return dates;
	}

	public static Date[] getTimeInterval(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		String imptimeBegin = sdf.format(cal.getTime());
		// System.out.println("所在周星期一的日期：" + imptimeBegin);
		cal.add(Calendar.DATE, 6);
		String imptimeEnd = sdf1.format(cal.getTime());
		// System.out.println("所在周星期日的日期：" + imptimeEnd);
		Date[] dates = new Date[2];
		dates[0] = convertStrToDate(imptimeBegin);
		dates[1] = convertStrToDate(imptimeEnd);
		return dates;
	}

	public static Date[] getbeforeMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date[] dates = new Date[2];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		dates[0] = convertStrToDate(sdf.format(calendar.getTime()));
		calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		dates[1] = convertStrToDate(sdf1.format(calendar.getTime()));
		return dates;
	}

	public static Date[] getNowMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date[] dates = new Date[2];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		dates[0] = convertStrToDate(sdf.format(calendar.getTime()));
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		dates[1] = convertStrToDate(sdf1.format(calendar.getTime()));
		return dates;
	}

	/**
	 * 计算日期是星期几
	 * 
	 * @param date
	 * @return 1-7
	 */
	public static int dayForWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return dayForWeek(c);
	}

	/**
	 * 计算当前时间是星期几
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月3日 下午2:16:55
	 * @return
	 */
	public static int dayForWeek() {
		return dayForWeek(Calendar.getInstance());
	}

	/**
	 * 根据日期字符串获取周几
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static int dayForWeek(String dateStr, String format) {
		Date date = convertStrToDate(dateStr, format);
		return dayForWeek(date);
	}

	/**
	 * 计算星期
	 * 
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2017年3月3日 下午2:20:46
	 * @param c
	 * @return
	 */
	private static int dayForWeek(Calendar c) {
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}
	
	/**
	 * 计算星期, 返回中文
	 * @param date
	 * @return
	 * @date 2017年10月12日上午10:38:17
	 * @author cheng.chen
	 */
	public static String dayForWeekStr(Date date){
		return weekTxtMap.get(dayForWeek(date));
	}

	/**
	 * 获取日期前几天或者后几天的日期
	 * 
	 * @param date
	 *            指定日期
	 * @param dayNum
	 *            指定天数 正数 1 为后一天，负数-1为前一天
	 * @return 日期
	 */
	public static Date getDateDit(Date date, int dayNum) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, dayNum);
		date = calendar.getTime();
		return date;
	}
	
	/**
	 * 当前时间加多少秒后返回
	 * 
	 * @param second
	 * @return
	 */
	public static Timestamp currentTimeAddSec(int second) {
		Calendar caln = Calendar.getInstance();
		caln.add(Calendar.SECOND, second);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ts.setTime(caln.getTimeInMillis());
		return ts;
	}

	/**
	 * 
	 * @Description: 时间加多少秒返回
	 * @param date
	 * @param time
	 * @return
	 * @author wuLong
	 * @date 2017年3月25日 下午2:34:05
	 */
	public static Date addSecond(Date date, Integer time) {
		if (ObjectUtil.isBlank(date)) {
			return null;
		}
		Calendar caln = Calendar.getInstance();
		caln.setTime(date);
		caln.add(Calendar.SECOND, time);
		return caln.getTime();
	}
	
	/**
	 * 时间加上多少天后返回
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDay(Date date, Integer day) {
		if (ObjectUtil.isBlank(date)) {
			return null;
		}
		Calendar caln = Calendar.getInstance();
		caln.setTime(date);
		caln.add(Calendar.DATE, day);
		return caln.getTime();
	}

	/**
	 * 
	 * @Description: 时间加多少小时返回
	 * @param date
	 * @param hour
	 * @return
	 * @author wuLong
	 * @date 2017年3月25日 下午2:36:42
	 */
	public static Date addHour(Date date, Integer hour) {
		if (ObjectUtil.isBlank(date)) {
			return null;
		}
		Calendar caln = Calendar.getInstance();
		caln.setTime(date);
		caln.add(Calendar.HOUR_OF_DAY, hour);
		return caln.getTime();
	}

	/**
	 * 
	 * @Description: 时间加多少分钟返回
	 * @param date
	 * @param minute
	 * @return
	 * @author wuLong
	 * @date 2017年3月25日 下午2:37:52
	 */
	public static Date addMinute(Date date, Integer minute) {
		if (ObjectUtil.isBlank(date)) {
			return null;
		}
		Calendar caln = Calendar.getInstance();
		caln.setTime(date);
		caln.add(Calendar.MINUTE, minute);
		return caln.getTime();
	}
	
	/**  
	* 方法说明: 月份加上几个月返回，正数加，负数减
	* @auth: xiongJinGang
	* @param date
	* @param month
	* @time: 2018年3月15日 下午12:16:24
	* @return: Date 
	*/
	public static Date addMonth(Date date, Integer month) {
		if (ObjectUtil.isBlank(date)) {
			return null;
		}
		Calendar caln = Calendar.getInstance();
		caln.setTime(date);
		caln.add(Calendar.MONTH, month);
		return caln.getTime();
	}
	
	public static Long getNowAddMinute(Date date, Integer minute) {
		if (ObjectUtil.isBlank(date)) {
			return null;
		}
		Calendar caln = Calendar.getInstance();
		caln.setTime(date);
		caln.add(Calendar.MINUTE, minute);
		return caln.getTimeInMillis();
	}

	/**
	 * 输入的时间是否小于当前时间
	 * 
	 * @param t
	 * @return
	 */
	public static boolean isOver(String t) {
		if (t == null)
			return true;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(DateUtil.strToTimestamp(t));
		return (cal1.compareTo(cal2)) <= 0;
	}

	/**
	 * 输入的时间是否小于当前时间
	 * 
	 * @param t
	 * @return
	 */
	public static boolean isOver(Timestamp t) {
		if (t == null)
			return true;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(t);
		return (cal1.compareTo(cal2)) <= 0;
	}

	/**
	 * 将字符串转换为时间戳
	 * 
	 * @param time
	 * @param
	 * @return 时间戳
	 */
	public static Timestamp strToTimestamp(String time) {
		Timestamp ts = null;
		try {
			ts = Timestamp.valueOf(time);
			return ts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}

	/**
	 * 
	 * @author longguoyou
	 * 
	 * @date 2017年2月9日 上午10:04:33
	 * 
	 * @desc 比较两个日期类型时间大小
	 *
	 * @param sourceDate
	 * @param targetDate
	 * @return
	 */
	public static int compare(Date sourceDate, Date targetDate) {
		DateFormat df = new SimpleDateFormat(DEFAULT_FORMAT);
		return compare(df.format(sourceDate), df.format(targetDate));
	}

	/**
	 * 方法说明: 二个时间相差的秒数，
	 * 
	 * @auth: xiongJinGang
	 * @param sourceDate
	 *            源时间 大于目标时间，返回的秒数才是正数，否则是负数
	 * @param targetDate
	 *            目标时间
	 * @time: 2017年5月9日 下午2:19:53
	 * @return: long
	 */
	public static long compareAndGetSeconds(Date sourceDate, Date targetDate) {
		long interval = (sourceDate.getTime() - targetDate.getTime()) / 1000;
		return interval;
	}

	/**
	 * 
	 * @author longguoyou
	 * 
	 * @date 2017年2月9日 上午9:51:08
	 * 
	 * @desc 比较两个字符类型时间大小：<br>
	 *       大于，返回1； 等于 ，返回0；小于，返回 -1
	 *
	 * @param sourceTime
	 *            比较时间
	 * @param targetTime
	 *            被比较时间
	 * @return
	 */
	public static int compare(String sourceTime, String targetTime) {
		DateFormat df = new SimpleDateFormat(DEFAULT_FORMAT);
		try {
			Date dtSource = df.parse(sourceTime);
			Date dtTarget = df.parse(targetTime);
			if (dtSource.getTime() > dtTarget.getTime()) {
				return 1;
			} else if (dtSource.getTime() < dtTarget.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static Date getMinDate(Date date1, Date date2) {
		if (date1 == null) {
			return date2;
		} else if (date2 == null) {
			return date1;
		} else if (date1.getTime() < date2.getTime()) {
			return date1;
		}
		return date2;
	}

	/**
	 * 判断时间是否是当天
	 * 
	 * @param date
	 * @return
	 * @date 2017年5月22日下午12:01:44
	 * @author cheng.chen
	 */
	public static boolean isToday(Date date) {
		String dateStr = DateUtil.convertDateToStr(date, "yyyy-MM-dd");
		String now = getNow("yyyy-MM-dd");
		return dateStr.equals(now);
	}

	/**
	 * 方法说明: 验证信用卡是否过期（overdueDate=0920的格式）
	 * 
	 * @auth: xiongjingang
	 * @param overdueDate
	 * @time: 2017年3月17日 上午9:26:48
	 * @return: boolean
	 */
	public static boolean validateCreditCard(String overdueDate) {
		boolean flag = false;
		try {
			String month = overdueDate.substring(0, 2);
			String year = "20" + overdueDate.substring(2, 4);
			String nowMonth = getNow(FORMAT_YYYY_MM);
			String validateYear = year + "-" + month;
			flag = validateYear.compareTo(nowMonth) >= 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 校验信用卡有效期是否过期
	 * 
	 * @param input
	 *            传入参数，格式如：1220
	 * @return true:表示还未过期;false:表示过期
	 */
	public static Boolean validateCredCardOver(String input) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMyy");
		simpleDateFormat.setLenient(false);
		Date expiry = simpleDateFormat.parse(input);
		Calendar cal = Calendar.getInstance();
		cal.setTime(expiry);
		cal.add(Calendar.MONTH, Constants.NUM_1);
		return cal.getTime().after(new Date());
	}

	/**
	 * 
	 * @Description: 返回两个日期之间的毫秒数
	 * @param date1
	 * @param date2
	 * @return
	 * @author wuLong
	 * @date 2017年3月25日 下午2:24:57
	 */
	public static long getDifferenceTime(Date date1, Date date2) {
		long d = date1.getTime() - date2.getTime();
		if (d < 1) {
			return 0;
		}
		return d;
	}

	/**
	 * 判断是否超过1年
	 * 
	 * @param startDate
	 * @param endDate
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean judgmentDate(Date startDate, Date endDate) throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date date = null;
		calendar.setTime(endDate);
		calendar.add(Calendar.YEAR, -1);
		date = calendar.getTime();
		return date.compareTo(startDate) > 0;
	}

	/**
	 * 获取精确到秒的时间戳
	 * 
	 * @param dateStr
	 * @param format，该格式最好与dateStr格式类型一致，否则会报错
	 * @return
	 */
	public static int getSecondTimestamp(String dateStr, String format) {
		if (StringUtil.isBlank(dateStr)) {
			return 0;
		}
		Date date = DateUtil.convertStrToDate(dateStr, format);

		String timestamp = String.valueOf(date.getTime() / 1000);
		return Integer.valueOf(timestamp);
	}
	
    public static int date2TimeStamp(String date_str,String format){  
    	String date =  convertStrToTarget(date_str, DEFAULT_FORMAT, format);
        try {  
            SimpleDateFormat sdf = new SimpleDateFormat(format);  
            String timestamp = String.valueOf(sdf.parse(date).getTime()/1000);  
            return Integer.valueOf(timestamp);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0;  
    } 
    
    /**  
    * 方法说明: 时间类型转成时间戳
    * @auth: xiongJinGang
    * @param date
    * @param format
    * @time: 2017年8月24日 上午9:58:40
    * @return: int 
    */
    public static int dateTimeStamp(String date,String format){  
        try {  
            SimpleDateFormat sdf = new SimpleDateFormat(format);  
            String timestamp = String.valueOf(sdf.parse(date).getTime()/1000);  
            return Integer.valueOf(timestamp);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return 0;  
    } 
    
    /**
     * 获取某天的开始时间
     *
     * @return
     */
    public static Date getDayStart(Date date) {
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime();
    }
    
    /**
     * 获取某天的结束时间
     *
     * @return
     */
    public static Date getDayEnd(Date date) {
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime();
    }
    /**
     * 获取某天的结束时间
     *
     * @return
     */
    public static Date getDayEnd() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);  
        return cal.getTime();
    }
	/**
	 * 判断当前时间是否在某一时间段
	 * 
	 * @param format
	 *            时间格式 "HH:mm"
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 * @throws Exception
	 */
	public static boolean isCurDateAtTimeRange(String format, String startTime, String endTime) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String currentDate = sdf.format(new Date());
		Date currDate = sdf.parse(currentDate);// 当前时间
		Date startDate = sdf.parse(startTime);// 每节开始时间
		Date endDate = sdf.parse(endTime);// 每节结束时间
		if (currDate.after(startDate) && currDate.before(endDate)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 方法说明: 获取当前时间后几天的几点钟
	 * 
	 * @auth: lidecheng
	 * @param
	 * @time: 2017年4月19日 下午2:56:04
	 * @return: String
	 */
	public static Date getAfterDayHour(int day, int hourt) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(GregorianCalendar.DATE, day);
		calendar.set(Calendar.HOUR_OF_DAY, hourt);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 方法说明: 设置当前时间的时分秒
	 * 
	 * @auth: lidecheng
	 * @param
	 * @time: 2017年4月19日 下午2:56:04
	 * @return: String
	 */
	public static Date getDaySetTime(int hourt, int min, int sec) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY, hourt);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, sec);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @Description 计算两个日期之间的天数，包含开始日期和结束日期
	 * @author HouXiangBao289
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getTwoDateDays(Date startDate,Date endDate){
		return (int)((endDate.getTime() - startDate.getTime())/86400000) + 1;
	}

	/**
	 * 两个时间之间相差距离多少天
	 * @param str1 时间参数 1
	 * @param str2 时间参数 2：
	 * @return 相差天数
	 * @throws Exception
	 */
	public static long getDistanceDays(String str1, String str2) throws Exception{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date one;
		Date two;
		long days=0;
		try {
			one = df.parse(str1);
			two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff ;
			if(time1<time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			days = diff / (1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}

	/**
	 * 两个时间相差距离多少天多少小时多少分多少秒
	 * @param str1 时间参数 1 格式：1990-01-01 12:00:00
	 * @param str2 时间参数 2 格式：2009-01-01 12:00:00
	 * @return long[] 返回值为：{天, 时, 分, 秒}
	 */
	public static long[] getDistanceTimes(String str1, String str2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date one;
		Date two;
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		try {
			one = df.parse(str1);
			two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff ;
			if(time1<time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			day = diff / (24 * 60 * 60 * 1000);
			hour = (diff / (60 * 60 * 1000) - day * 24);
			min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long[] times = {day, hour, min, sec};
		return times;
	}
	/**
	 * 两个时间相差距离多少天多少小时多少分多少秒
	 * @param str1 时间参数 1 格式：1990-01-01 12:00:00
	 * @param str2 时间参数 2 格式：2009-01-01 12:00:00
	 * @return String 返回值为：xx天xx小时xx分xx秒
	 */
	public static String getDistanceTime(String str1, String str2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date one;
		Date two;
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		try {
			one = df.parse(str1);
			two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff ;
			if(time1<time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			day = diff / (24 * 60 * 60 * 1000);
			hour = (diff / (60 * 60 * 1000) - day * 24);
			min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return day + "天" + hour + "小时" + min + "分" + sec + "秒";
	}

	/**
	 * 日期时分秒归零 ， 例如:Date类型：2017-10-11 18:03:25 , 返回Date类型： 2017-10-11 00:00:00
	 * @author longguoyou
	 * @date 2017年10月11日
	 * @param date
	 * @param format 为null时归零，非空则相应变化
	 * @return
	 */
    public static Date getDateWithNoHHMiss(Date date, String format){
    	return DateUtil.convertStrToDate(DateUtil.convertDateToStr(date, ObjectUtil.isBlank(format)?DateUtil.DATE_FORMAT:format), ObjectUtil.isBlank(format)?DateUtil.DATE_FORMAT:format);
    }
    /**
     * 获取指定日期的开始时间 例如：2017-10-11 00:00:00
     * @author longguoyou
     * @date 2017年10月11日
     * @param date
     * @return
     */
    public static Date getBeginTime(Date date){
    	return DateUtil.convertStrToDate(DateUtil.convertDateToStr(date, DateUtil.DATE_FORMAT) + " 00:00:00", DateUtil.DEFAULT_FORMAT);
    }
    /**
     * 获取指定日期的结束时间 例如：2017-10-11 23:59:59
     * @author longguoyou
     * @date 2017年10月11日
     * @param date
     * @return
     */
    public static Date getEndTime(Date date){
    	return DateUtil.convertStrToDate(DateUtil.convertDateToStr(date, DateUtil.DATE_FORMAT) + " 23:59:59", DateUtil.DEFAULT_FORMAT);
    }

	/**
	 * 
	 * @Description 获取上月 
	 * @author HouXiangBao289
	 * @return
	 */
	public static Date getBeforeMonth(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		return c.getTime();
	}
	
	/**
	 * 
	 * @Description 获取季度开始月份 
	 * @author HouXiangBao289
	 * @param quarter 1本季度,2上季度
	 * @param isQuarterStart true开始月份，false结束月份
	 * @return
	 */
	public static Date getQuarterMonth(int quarter,boolean isQuarterStart){
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		if(quarter == 1){
			month = getQuarterInMonth(month,isQuarterStart);
		}
		else if(quarter == 2){
			month++;
			// 计算上季度的月份
			month = (month/3 + (month%3>0?1:0) - 1) * 3 - 1;
			month = getQuarterInMonth(month,isQuarterStart);
		}
		c.set(Calendar.MONTH, month);
		return c.getTime();
	}
	
	private static int getQuarterInMonth(int month, boolean isQuarterStart){  
		 int months[] = { 0, 3, 6, 9 };
	     if (!isQuarterStart)
	        months = new int[] { 2, 5, 8, 11 };
	        
	     if (month >= 0 && month <= 2)
	        return months[0];
	     else if (month >= 3 && month <= 5)  
	        return months[1];  
	     else if (month >= 6 && month <= 8)  
	        return months[2];
	     else
	        return months[3];
	}
	
	
    /**
     * 本周的第一天
     * @param dataStr
     * @param dateFormat
     * @param resultDateFormat
     * @return
     * @throws ParseException
     */
    public static Date getFirstOfWeek(){
        Calendar cal = Calendar.getInstance();
        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime();

    }
	/**
	 * 时间格式转换为：Tue, 27 Feb 2018 10:11:39 +0800
	 * @author jiangwei
	 * @Version 1.0
	 * @CreatDate 2018年2月27日 上午10:10:21
	 * @param date
	 * @return
	 */
	public static String timeZone(Date date){
		String [] str = date.toString().split(" ");
		StringBuilder sb = new StringBuilder();
		sb.append(str[0]);
		sb.append(", ");
		sb.append(str[2]);
		sb.append(" ");
		sb.append(str[1]);
		sb.append(" ");
		sb.append(str[5]);
		sb.append(" ");
		sb.append(str[3]);
		sb.append(" +0800");
		return sb.toString();
	} 
	/**  
	* 方法说明: 获取当前时间戳
	* @auth: xiongJinGang
	* @time: 2018年3月27日 上午10:35:13
	* @return: Long 
	*/
	public static Long getNowTimeStamp(){
		return Calendar.getInstance().getTimeInMillis();
	}
}
