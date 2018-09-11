package com.hhly.lottomsg.common.util;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.*;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @auth lgs on
 * @date 2017/2/6.
 * @desc 对Object对象进行处理
 * @compay 益彩网络科技有限公司
 * @vsersion 1.0
 */
public class ObjectUtil extends ObjectUtils{
	
	
	
	/**
	 * 判断字符串为空
	 * @param string
	 * @return
	 */
	public static boolean isBlank(String string){
		return StringUtils.isBlank(string);
	}
	
	
	/**
	 * 判断LONG,空值
	 * @param l
	 * @return
	 * null/0 (true)
	 * 
	 */
	public static boolean isBlank(Long l){
		return null == l || l.equals(0L);
	}
	
	/**
	 * 判断Integer,空值
	 * @param l
	 * @return
	 * null/0 (true)
	 * 
	 */
	public static boolean isBlank(Integer i){
		return null == i || i.equals(0);
	}
	
	
	/**
	 * 判断Short,空值
	 * @param s
	 * @return
	 * null/0 (true)
	 * 
	 */
	public static boolean isBlank(Short s){
		return null == s || s.equals((short)0);
	}
	
	/**
	 * 判断Double,空值
	 * @param l
	 * @return
	 * null/0 (true)
	 * 
	 */
	public static boolean isBlank(Double d){
		return null == d || d.equals(0d);
	}
	
    /**
     * 查看Object是否为null
     * @param obj Java Object对象
     * @return 是null 返回true否则false
     */
    public static boolean isBlank(Object obj){
        return obj == null;
    }
	
	/**
	 *  判断数组是否为空
	 */
	public static boolean isBlank(Object[] array){
		return array == null || array.length == 0;
	}
	
	/**
	 *  判断List是否为空
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isBlank(List list){
		return list == null || list.size() == 0;
	}
	
	/**
	 *  判断Map是否为空
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isBlank(Map map){
		return map == null || map.size() == 0;
	}
	
	/**
	 *  判断Set是否为空
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isBlank(Set set){
		return set == null || set.size() == 0;
	}
	/**
	 * 判断是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj){
		return obj == null;
	}
	
	/**
	 * 判断是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj){
		return !isNull(obj);
	}

	/**
	 * Object 转换为Map<String, Object>
	 *
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> objectToMap(Object obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (obj == null) {
				return null;
			}
			Field[] declaredFields = obj.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				if (field.get(obj) instanceof String) {
					if (field.get(obj) != null && !field.get(obj).equals("")) {
						map.put(field.getName(), field.get(obj));
					}
				} else if (field.get(obj) instanceof Long) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof Integer) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof Date) {
					if (field.get(obj) != null) {
						map.put(field.getName(), field.get(obj));
					}
				} else if (field.get(obj) instanceof Double) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof Float) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof BigInteger) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof Short) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof BigInteger) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else {
					if (field.get(obj) != null) {
						map.put(field.getName(), field.get(obj));
					}
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}


	/**
	 * Object 转换为Map<String, String>
	 *
	 * @param obj
	 * @return
	 */
	public static Map<String, String> objectToMapStringValue(Object obj) {
		Map<String, String> map = new HashMap<>();
		try {
			if (obj == null) {
				return null;
			}
			Field[] declaredFields = obj.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				if (field.get(obj) instanceof String) {
					if (field.get(obj) != null && !field.get(obj).equals("")) {
						map.put(field.getName(), field.get(obj).toString());
					}
				} else if (field.get(obj) instanceof Long) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof Integer) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof Date) {
					if (field.get(obj) != null) {
						map.put(field.getName(), DateUtil.convertDateToStr((Date) field.get(obj), DateUtil.DEFAULT_FORMAT));
					}
				} else if (field.get(obj) instanceof Double) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof Float) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof BigInteger) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof Short) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else if (field.get(obj) instanceof BigInteger) {
					if (field.get(obj) != null) {
						map.put(field.getName(), String.valueOf(field.get(obj)));
					}
				} else {
					if (field.get(obj) != null) {
						map.put(field.getName(), field.get(obj).toString());
					}
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}
}
