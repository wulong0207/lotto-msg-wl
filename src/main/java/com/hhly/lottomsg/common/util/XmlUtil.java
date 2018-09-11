package com.hhly.lottomsg.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

/**
 * @desc xml工具类
 * @author xiongJinGang
 * @date 2017年3月23日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public class XmlUtil {
	/**  
	* 方法说明: 将输入流解析成xml
	* @auth: xiongJinGang
	* @param inputStream
	* @throws Exception
	* @time: 2017年3月23日 上午10:27:15
	* @return: Map<String,String> 
	*/
	public static Map<String, String> parseXml(InputStream inputStream) throws Exception {
		if (inputStream == null) {
			return null;
		}

		Map<String, String> map = new HashMap<String, String>();// 将解析结果存储在HashMap中
		SAXReader reader = new SAXReader();// 读取输入流
		Document document = reader.read(inputStream);
		Element root = document.getRootElement();// 得到xml根元素
		List<Element> elementList = root.elements();// 得到根元素的所有子节点
		for (Element e : elementList) { // 遍历所有子节点
			map.put(e.getName(), e.getText());
		}

		inputStream.close(); // 释放资源
		inputStream = null;

		return map;
	}

	/** 
	   * 根据Map组装xml消息体，值对象仅支持基本数据类型、String、BigInteger、BigDecimal，以及包含元素为上述支持数据类型的Map 
	   *  
	   * @param vo 
	   * @param rootElement 
	   * @return 
	   */
	public static String map2xmlBody(Map<String, Object> vo, String rootElement) {
		org.dom4j.Document doc = DocumentHelper.createDocument();
		Element body = DocumentHelper.createElement(rootElement);
		doc.add(body);
		buildMap2xmlBody(body, vo);
		return doc.asXML();
	}

	private static void buildMap2xmlBody(Element body, Map<String, Object> vo) {
		if (vo != null) {
			Iterator<String> it = vo.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				if (!StringUtil.isBlank(key)) {
					Object obj = vo.get(key);
					Element element = DocumentHelper.createElement(key);
					if (obj != null) {
						if (obj instanceof java.lang.String) {
							element.setText((String) obj);
						} else {
							if (obj instanceof java.lang.Character || obj instanceof java.lang.Boolean || obj instanceof java.lang.Number || obj instanceof java.math.BigInteger || obj instanceof java.math.BigDecimal) {
								org.dom4j.Attribute attr = DocumentHelper.createAttribute(element, "type", obj.getClass().getCanonicalName());
								element.add(attr);
								element.setText(String.valueOf(obj));
							} else if (obj instanceof java.util.Map) {
								org.dom4j.Attribute attr = DocumentHelper.createAttribute(element, "type", java.util.Map.class.getCanonicalName());
								element.add(attr);
								buildMap2xmlBody(element, (Map<String, Object>) obj);
							} else {
							}
						}
					}
					body.add(element);
				}
			}
		}
	}

	/** 
	 * 根据xml消息体转化为Map 
	 *  
	 * @param xml 
	 * @param rootElement 
	 * @return 
	 * @throws DocumentException 
	 */
	public static Map xmlBody2map(String xml, String rootElement) throws DocumentException {
		org.dom4j.Document doc = DocumentHelper.parseText(xml);
		Element body = (Element) doc.selectSingleNode("/" + rootElement);
		Map vo = buildXmlBody2map(body);
		return vo;
	}

	private static Map buildXmlBody2map(Element body) {
		Map vo = new HashMap();
		if (body != null) {
			List<Element> elements = body.elements();
			for (Element element : elements) {
				String key = element.getName();
				if (!StringUtil.isBlank(key)) {
					String type = element.attributeValue("type", "java.lang.String");
					String text = element.getText().trim();
					Object value = null;
					if (java.lang.String.class.getCanonicalName().equals(type)) {
						value = text;
					} else if (java.lang.Character.class.getCanonicalName().equals(type)) {
						value = new java.lang.Character(text.charAt(0));
					} else if (java.lang.Boolean.class.getCanonicalName().equals(type)) {
						value = new java.lang.Boolean(text);
					} else if (java.lang.Short.class.getCanonicalName().equals(type)) {
						value = java.lang.Short.parseShort(text);
					} else if (java.lang.Integer.class.getCanonicalName().equals(type)) {
						value = java.lang.Integer.parseInt(text);
					} else if (java.lang.Long.class.getCanonicalName().equals(type)) {
						value = java.lang.Long.parseLong(text);
					} else if (java.lang.Float.class.getCanonicalName().equals(type)) {
						value = java.lang.Float.parseFloat(text);
					} else if (java.lang.Double.class.getCanonicalName().equals(type)) {
						value = java.lang.Double.parseDouble(text);
					} else if (java.math.BigInteger.class.getCanonicalName().equals(type)) {
						value = new java.math.BigInteger(text);
					} else if (java.math.BigDecimal.class.getCanonicalName().equals(type)) {
						value = new java.math.BigDecimal(text);
					} else if (java.util.Map.class.getCanonicalName().equals(type)) {
						value = buildXmlBody2map(element);
					} else {
					}
					vo.put(key, value);
				}
			}
		}
		return vo;
	}

	/**  
	* 方法说明: 字符器类型的xml转成Map
	* @auth: xiongJinGang
	* @param xml
	* @time: 2017年3月29日 下午5:36:47
	* @return: Map<String,String> 
	*/
	public static Map<String, String> stringXmlMap(String xml) {
		Map<String, String> map = new HashMap<String, String>();
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点
			List<Element> list = rootElt.elements();// 获取根节点下所有节点
			for (Element element : list) { // 遍历节点
				map.put(element.getName(), element.getText()); // 节点的name为map的key，text为map的value
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/** <一句话功能简述>
	 * <功能详细描述>request转字符串
	 * @param request
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String parseRequst(HttpServletRequest request) {
		String body = "";
		try {
			ServletInputStream inputStream = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			while (true) {
				String info = br.readLine();
				if (info == null) {
					break;
				}
				if (body == null || "".equals(body)) {
					body = info;
				} else {
					body += info;
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}

	public static String parseXML(SortedMap<String, String> parameters) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"appkey".equals(k)) {
				sb.append("<" + k + ">" + parameters.get(k) + "</" + k + ">\n");
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}
	
	/**  
	* 方法说明: map转xml
	* @auth: xiongJinGang
	* @param map
	* @time: 2017年10月12日 下午5:18:37
	* @return: String 
	*/
	public static String parseXML(Map<String, String> map) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set<Map.Entry<String, String>> es = map.entrySet();
		Iterator<Entry<String, String>> it = es.iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			String k = entry.getKey();
			String v = entry.getValue();
			if (null != v && !"".equals(v) && !"appkey".equals(k)) {
				sb.append("<" + k + ">" + map.get(k) + "</" + k + ">\n");
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * 从request中获得参数Map，并返回可读的Map
	 * 
	 * @param request
	 * @return
	 */
	public static SortedMap getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map properties = request.getParameterMap();
		// 返回值Map
		SortedMap returnMap = new TreeMap();
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value.trim());
		}
		return returnMap;
	}

	/**
	 * 转XMLmap
	 * @author  
	 * @param xmlBytes
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> toMap(byte[] xmlBytes, String charset) throws Exception {
		SAXReader reader = new SAXReader(false);
		InputSource source = new InputSource(new ByteArrayInputStream(xmlBytes));
		source.setEncoding(charset);
		Document doc = reader.read(source);
		Map<String, String> params = toMap(doc.getRootElement());
		return params;
	}

	/**
	 * 转MAP
	 * @author  
	 * @param element
	 * @return
	 */
	public static Map<String, String> toMap(Element element) {
		Map<String, String> rest = new HashMap<String, String>();
		List<Element> els = element.elements();
		for (Element el : els) {
			rest.put(el.getName().toLowerCase(), el.getTextTrim());
		}
		return rest;
	}

	public static String toXml(Map<String, String> params) {
		StringBuilder buf = new StringBuilder();
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		buf.append("<xml>");
		for (String key : keys) {
			buf.append("<").append(key).append(">");
			buf.append("<![CDATA[").append(params.get(key)).append("]]>");
			buf.append("</").append(key).append(">\n");
		}
		buf.append("</xml>");
		return buf.toString();
	}
}
