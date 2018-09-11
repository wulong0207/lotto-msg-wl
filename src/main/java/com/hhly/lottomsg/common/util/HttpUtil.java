package com.hhly.lottomsg.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author huangb
 *
 * @Date 2017年1月9日
 *
 * @Desc http工具
 */
@Component
public class HttpUtil {
	/**
	 * 默认请求编码
	 */
	private static final String DEFAULT_CHARSET = "UTF-8";
	/**
	 * 默认等待响应时间(毫秒)
	 */
	public static final int DEFAULT_SOCKETTIMEOUT = 10000;
	/**
	 * 默认连接服务时间(毫秒)
	 */
	public static final int DEFAULT_CONNECTTIMEOUT = 5000;
	/**
	 * 请求数据超时时间(毫秒)
	 */
	public static final int DEFAULT_CONNECTIONREQUESTTIMEOUT = 1000;	
	/**
	 * 默认执行重试的次数
	 */
	private static final int DEFAULT_RETRY_TIMES = 0;

	/**
	 * @return HttpClient
	 * @Desc 代理IP
	 */
	public static String HTTP_PROXYHOST;
	/**
	 * 代理端口
	 */
	public static String HTTP_PROXYPORT;
	/**
	 * 不使用代理的白名单
	 */
    public static String HTTP_NONPROXYHOSTS;
    /**
	 * 是否启用代理
	 */
    public static String HTTP_PROXY_ENABLE;
    
    @Value("${http_proxy_enable}")
    public void setHTTP_PROXY_ENABLE(String hTTP_PROXY_ENABLE){
    	HTTP_PROXY_ENABLE = hTTP_PROXY_ENABLE;
    }
    
    @Value("${http_nonProxyHosts}")
    public void setHTTP_NONPROXYHOSTS(String hTTP_NONPROXYHOSTS){
    	HTTP_NONPROXYHOSTS = hTTP_NONPROXYHOSTS;
    }
    
    @Value("${http_proxyPort}")
    public void setHTTP_PROXYPORT(String hTTP_PROXYPORT){
    	HTTP_PROXYPORT = hTTP_PROXYPORT;
    }
    
    @Value("${http_proxyHost}")
    public void setHTTP_PROXYHOST(String hTTP_PROXYHOST){
    	HTTP_PROXYHOST = hTTP_PROXYHOST;
    }

    public static CloseableHttpClient createHttpClient() {
		return createHttpClient(DEFAULT_RETRY_TIMES, DEFAULT_CONNECTTIMEOUT, DEFAULT_CONNECTIONREQUESTTIMEOUT, DEFAULT_SOCKETTIMEOUT);
	}

	/**
	 * @param socketTimeout
	 *            请求获取数据的超时时间
	 * @return
	 * @Desc 创建一个默认的可关闭的HttpClient
	 */
	public static CloseableHttpClient createHttpClient(int socketTimeout) {
		return createHttpClient(DEFAULT_RETRY_TIMES, DEFAULT_CONNECTTIMEOUT, DEFAULT_CONNECTIONREQUESTTIMEOUT, socketTimeout);
	}
	
	/**
	 * 
	 * @param connectTimeout
	 * @param socketTimeout
	 * @return
	 * @date 2017年11月16日下午3:04:13
	 * @author cheng.chen
	 */
	public static CloseableHttpClient createHttpClient(int connectTimeout, int socketTimeout) {
		return createHttpClient(DEFAULT_RETRY_TIMES, connectTimeout, DEFAULT_CONNECTIONREQUESTTIMEOUT, socketTimeout);
	}

	/**
	 * @param retryTimes
	 *            重试次数，小于等于0表示不重试
	 * @param socketTimeout
	 *            请求获取数据的超时时间
	 * @return
	 * @Desc 创建一个可关闭的HttpClient
	 */
	public static CloseableHttpClient createHttpClient(int retryTimes, int connectTimeout, int connectionRequestTimeout, int socketTimeout) {
		// 构建请求配置
		Builder builder = RequestConfig.custom();
		// 设置连接超时时间，单位毫秒
		builder.setConnectTimeout(connectTimeout);
		// 设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
		builder.setConnectionRequestTimeout(connectionRequestTimeout);
		// 请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
		builder.setSocketTimeout(socketTimeout);
		RequestConfig defaultRequestConfig = builder.setCookieSpec(CookieSpecs.STANDARD_STRICT).setExpectContinueEnabled(true).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
				.setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
		// 开启HTTPS支持
		// enableSSL();
		// 创建可用Scheme
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.INSTANCE).register("https", socketFactory).build();
		// 创建ConnectionManager，添加Connection配置信息
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		if (retryTimes > 0) {
			setRetryHandler(httpClientBuilder, retryTimes);
		}
		CloseableHttpClient httpClient = httpClientBuilder.setConnectionManager(connectionManager).setDefaultRequestConfig(defaultRequestConfig).build();
		return httpClient;
	}

	/**
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @Desc 执行HttpGet请求
	 */
	public static String doGet(String url) throws IOException, URISyntaxException {
		return doGet(null, url, null, null, null, true, DEFAULT_CONNECTTIMEOUT, DEFAULT_SOCKETTIMEOUT);
	}
	
	/**
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @Desc 执行HttpGet请求
	 */
	public static String doGet(String url, int connectTimeout, int socketTimeout) throws IOException, URISyntaxException {
		return doGet(null, url, null, null, null, true, connectTimeout, socketTimeout);
	}
	
	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            参数集合
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @Desc 执行HttpGet请求
	 */
	public static String doGet(String url, Map<String, String> params) throws IOException, URISyntaxException {
		return doGet(null, url, params, null, null, true,DEFAULT_CONNECTTIMEOUT, DEFAULT_SOCKETTIMEOUT);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param params
	 *            参数集合
	 * @param headers
	 *            头信息集合
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @Desc 执行HttpGet请求
	 */
	public static String doGet(String url, Map<String, String> params, Map<String, String> headers) throws IOException, URISyntaxException {
		return doGet(null, url, params, headers, null, true, DEFAULT_CONNECTTIMEOUT, DEFAULT_SOCKETTIMEOUT);
	}

	/**
	 * @param httpClient
	 *            HttpClient客户端实例，传入null会自动创建一个
	 * @param url
	 *            请求的远程地址
	 * @param params
	 *            参数集合(Map)，可传null
	 * @param headers
	 *            headers集合信息,如："Cookie"，"Reffer"等(Map)，可传null
	 * @param charset
	 *            请求编码，默认UTF8
	 * @param isCloseHttpClient
	 *            执行请求结束后是否关闭HttpClient客户端实例
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @Desc 执行HttpGet请求
	 */
	public static String doGet(CloseableHttpClient httpClient, String url, Map<String, String> params, Map<String, String> headers, String charset, boolean isCloseHttpClient, int connectTimeout, int socketTimeout) throws IOException, URISyntaxException {
		CloseableHttpResponse httpResponse = null;
		try {
			// 创建httpclient
			if (httpClient == null) {
				if (isProxy(url)) {
					httpClient = createProxyHttpClient(connectTimeout, socketTimeout);
				} else {
					httpClient = createHttpClient(connectTimeout, socketTimeout);
				}

			}
			// uri构建对象,指定url
			URIBuilder ub = new URIBuilder();
			ub.setPath(url);
			// url后面跟的参数列表
			if (params != null && !params.isEmpty()) {
				List<NameValuePair> pairs = getNameValuePairs(params);
				ub.setParameters(pairs);
			}
			// get请求
			HttpGet get = new HttpGet(ub.build());
			// 请求的头信息
			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, String> header : headers.entrySet()) {
					get.addHeader(header.getKey(), header.getValue());
				}
			}
			// 请求信息编码
			charset = getCharset(charset);
			// 执行请求获得响应
			httpResponse = httpClient.execute(get);
			// 输出响应结果
			return getResult(httpResponse, charset);
		} finally {
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (Exception e) {
				}
			}
			if (isCloseHttpClient && httpClient != null) {
				try {
					httpClient.close();
				} catch (Exception e) {
				}
			}
		}
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @date 2017年11月16日下午3:38:42
	 * @author cheng.chen
	 */
	public static boolean validaUrl(CloseableHttpClient httpClient, String url) throws IOException, URISyntaxException {
		CloseableHttpResponse httpResponse = null;
		try {
			// uri构建对象,指定url
			URIBuilder ub = new URIBuilder();
			ub.setPath(url);
			// get请求
			HttpGet get = new HttpGet(ub.build());
			// 执行请求获得响应
			httpResponse = httpClient.execute(get);
			// 输出响应结果
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if(statusCode == 200)
				return true;
			return false;
		} finally {
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (Exception e) {
				}
			}
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (Exception e) {
				}
			}
		}		
	}	
	
	/**  
	* 方法说明: 直接请求，不进行URLEncoded处理，支付有的接口，进行了URLEncoded处理后，调不通
	* @auth: xiongJinGang
	* @param url
	* @param charset
	* @throws IOException
	* @throws URISyntaxException
	* @time: 2017年10月24日 下午3:16:53
	* @return: String 
	*/
	public static String doGetNotUrlEncode(String url, String charset) throws IOException, Exception {
		CloseableHttpResponse httpResponse = null;
		CloseableHttpClient httpClient = null;
		try {
			// 创建httpclient
			if (isProxy(url)) {
				httpClient = createProxyHttpClient();
			} else {
				httpClient = createHttpClient();
			}
			// get请求
			HttpGet get = new HttpGet(url);
			// 请求信息编码
			charset = getCharset(charset);
			// 执行请求获得响应
			httpResponse = httpClient.execute(get);
			// 输出响应结果
			return getResult(httpResponse, charset);
		} finally {
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (Exception e) {
				}
			}
			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (Exception e) {
				}
			}
		}
	}
	
	/**
	 * @param url
	 *            请求地址
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @Desc 执行HttpPost请求
	 */
	public static String doPost(String url) throws IOException, URISyntaxException {
		return doPost(null, url, null, null, null, true, DEFAULT_CONNECTTIMEOUT, DEFAULT_SOCKETTIMEOUT);
	}
	
	/**
	 * 
	 * @param url
	 * @param connectTimeout
	 * @param socketTimeout
	 * @return
	 * @date 2017年11月16日下午6:48:14
	 * @author cheng.chen
	 */
	public static String doPost(String url, int connectTimeout, int socketTimeout) throws IOException, URISyntaxException {
		return doPost(null, url, null, null, null, true, connectTimeout, socketTimeout);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param paramsObj
	 *            参数对象(可以是map，也可以是字符串)
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @Desc 执行HttpPost请求
	 */
	public static String doPost(String url, Object paramsObj) throws IOException, URISyntaxException {
		return doPost(null, url, paramsObj, null, null, true, DEFAULT_CONNECTTIMEOUT, DEFAULT_SOCKETTIMEOUT);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param paramsObj
	 *            参数对象(可以是map，也可以是字符串)
	 * @param headers
	 *            头信息集合
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @Desc 执行HttpPost请求
	 */
	public static String doPost(String url, Object paramsObj, Map<String, String> headers) throws IOException, URISyntaxException {
		return doPost(null, url, paramsObj, headers, null, true, DEFAULT_CONNECTTIMEOUT, DEFAULT_SOCKETTIMEOUT);
	}

	/**
	 * @param httpClient
	 *            HttpClient客户端实例，传入null会自动创建一个
	 * @param url
	 *            请求的远程地址
	 * @param paramsObj
	 *            提交的参数信息，目前支持Map,和String(JSON\xml)
	 * @param headers
	 *            headers集合信息,如："Cookie"，"Reffer"等(Map)，可传null
	 * @param charset
	 *            请求编码，默认UTF8
	 * @param isCloseHttpClient
	 *            执行请求结束后是否关闭HttpClient客户端实例
	 * @return
	 * @throws IOException
	 * @Desc 执行HttpPost请求
	 */
	public static String doPost(CloseableHttpClient httpClient, String url, Object paramsObj, Map<String, String> headers, String charset, boolean isCloseHttpClient, int connectTimeout, int socketTimeout) throws IOException {
		CloseableHttpResponse httpResponse = null;
		try {
			// 创建httpclient
			if (httpClient == null) {
				if (isProxy(url)) {
					httpClient = createProxyHttpClient(connectTimeout, connectTimeout);
				} else {
					httpClient = createHttpClient(connectTimeout, connectTimeout);
				}
			}
			// post请求
			HttpPost post = new HttpPost(url);
			// 请求信息编码
			charset = getCharset(charset);
			// 设置参数
			HttpEntity httpEntity = getEntity(paramsObj, charset);
			if (httpEntity != null) {
				post.setEntity(httpEntity);
			}
			// 请求的头信息
			if (headers != null && !headers.isEmpty()) {
				for (Entry<String, String> header : headers.entrySet()) {
					post.addHeader(header.getKey(), header.getValue());
				}
			}
			// 执行请求获得响应
			httpResponse = httpClient.execute(post);
			// 输出响应结果
			return getResult(httpResponse, charset);
		} finally {
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (Exception e2) {
				}
			}
			if (isCloseHttpClient && httpClient != null) {
				try {
					httpClient.close();
				} catch (Exception e2) {
				}
			}
		}
	}

	/**  
	* 方法说明: 传递xml的参数
	* @auth: xiongJinGang
	* @param map
	* @param url
	* @param contentType
	* @param charset
	* @time: 2017年10月24日 上午11:08:01
	* @return: Map<String,String> 
	*/
	public static Map<String, String> doPostXml(Map<String, String> map, String url, String contentType, String charset) {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = null;
		Map<String, String> resultMap = null;
		try {
			// 请求信息编码
			charset = getCharset(charset);
			HttpPost httpPost = new HttpPost(url);
			StringEntity entityParams = new StringEntity(XmlUtil.parseXML(map), charset);
			httpPost.setEntity(entityParams);
			if (ObjectUtil.isBlank(contentType)) {
				contentType = "text/xml;charset=ISO-8859-1";
			}
			httpPost.setHeader("Content-Type", contentType);
			if (isProxy(url)) {
				httpClient = createProxyHttpClient();
			} else {
				httpClient = createHttpClient();
			}
			response = httpClient.execute(httpPost);
			if (response != null && response.getEntity() != null) {
				resultMap = XmlUtil.toMap(EntityUtils.toByteArray(response.getEntity()), charset);
			}
		} catch (Exception e) {
		} finally {
			try {
				if (null != response) {
					response.close();
				}
				if (null != httpClient) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultMap;
	}
	
	/**
	 * 
	 * @Description 传xml字符串请求(短信使用)
	 * @author HouXiangBao289
	 * @param url
	 * @param xmlStr
	 * @param soapAction 
	 * @param contentType
	 * @param charset
	 * @return
	 */
	public static String doPostXml(String url,String xmlStr,String soapAction,String contentType, String charset) {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = null;
		String result = null;
		try {
			// 请求信息编码
			charset = getCharset(charset);
			HttpPost httpPost = new HttpPost(url);
			StringEntity entityParams = new StringEntity(xmlStr,charset);
			httpPost.setEntity(entityParams);
			if (ObjectUtil.isBlank(contentType)) {
				contentType = "text/xml;charset=ISO-8859-1";
			}
			httpPost.setHeader("Content-Type", contentType);
			httpPost.setHeader("SOAPAction", soapAction);
			if (isProxy(url)) {
				httpClient = createProxyHttpClient();
			} else {
				httpClient = createHttpClient();
			}
			response = httpClient.execute(httpPost);
			if (response != null && response.getEntity() != null) {
				result = EntityUtils.toString(response.getEntity(), charset);
			}
		} catch (Exception e) {
		} finally {
			try {
				if (null != response) {
					response.close();
				}
				if (null != httpClient) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	/**  
	* 方法说明: 以xml的形式请求返回数据
	* @auth: xiongJinGang
	* @param map
	* @param url
	* @time: 2017年10月24日 上午11:08:42
	* @return: Map<String,String> 
	*/
	public static Map<String, String> doPostXml(Map<String, String> map, String url) {
		return doPostXml(map, url, null, null);
	}

	/**
	 * @param httpClient
	 *            HttpClient客户端实例，传入null会自动创建一个
	 * @param remoteFileUrl
	 *            远程接收文件的地址
	 * @param localFilePath
	 *            本地文件地址
	 * @param charset
	 *            请求编码，默认UTF-8
	 * @param closeHttpClient
	 *            执行请求结束后是否关闭HttpClient客户端实例
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @Desc 执行文件上传
	 */
	/*
	 * public static String doUploadFile(CloseableHttpClient httpClient, String
	 * remoteFileUrl, String localFilePath, String charset, boolean
	 * closeHttpClient) throws ClientProtocolException, IOException {
	 * CloseableHttpResponse httpResponse = null; try { if (httpClient == null)
	 * { httpClient = createHttpClient(); } // 把文件转换成流对象FileBody File localFile
	 * = new File(localFilePath); FileBody fileBody = new FileBody(localFile);
	 * // 以浏览器兼容模式运行，防止文件名乱码。 HttpEntity reqEntity =
	 * MultipartEntityBuilder.create().setMode(HttpMultipartMode.
	 * BROWSER_COMPATIBLE) .addPart("uploadFile",
	 * fileBody).setCharset(CharsetUtils.get("UTF-8")).build(); //
	 * uploadFile对应服务端类的同名属性<File类型> // .addPart("uploadFileName",
	 * uploadFileName) // uploadFileName对应服务端类的同名属性<String类型> HttpPost httpPost
	 * = new HttpPost(remoteFileUrl); httpPost.setEntity(reqEntity);
	 * httpResponse = httpClient.execute(httpPost); return
	 * getResult(httpResponse, charset); } finally { if (httpResponse != null) {
	 * try { httpResponse.close(); } catch (Exception e) { } } if
	 * (closeHttpClient && httpClient != null) { try { httpClient.close(); }
	 * catch (Exception e) { } } } }
	 */

	/**
	 * 执行文件下载
	 * 
	 * @param httpClient
	 *            HttpClient客户端实例，传入null会自动创建一个
	 * @param remoteFileUrl
	 *            远程下载文件地址
	 * @param localFilePath
	 *            本地存储文件地址
	 * @param charset
	 *            请求编码，默认UTF-8
	 * @param closeHttpClient
	 *            执行请求结束后是否关闭HttpClient客户端实例
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	/*
	 * public static boolean executeDownloadFile(CloseableHttpClient httpClient,
	 * String remoteFileUrl, String localFilePath, String charset, boolean
	 * closeHttpClient) throws ClientProtocolException, IOException {
	 * CloseableHttpResponse response = null; InputStream in = null;
	 * FileOutputStream fout = null; try { HttpGet httpget = new
	 * HttpGet(remoteFileUrl); response = httpClient.execute(httpget);
	 * HttpEntity entity = response.getEntity(); if (entity == null) { return
	 * false; } in = entity.getContent(); File file = new File(localFilePath);
	 * fout = new FileOutputStream(file); int l = -1; byte[] tmp = new
	 * byte[1024]; while ((l = in.read(tmp)) != -1) { fout.write(tmp, 0, l); //
	 * 注意这里如果用OutputStream.write(buff)的话，图片会失真 } // 将文件输出到本地 fout.flush();
	 * EntityUtils.consume(entity); return true; } finally { // 关闭低层流。 if (fout
	 * != null) { try { fout.close(); } catch (Exception e) { } } if (response
	 * != null) { try { response.close(); } catch (Exception e) { } } if
	 * (closeHttpClient && httpClient != null) { try { httpClient.close(); }
	 * catch (Exception e) { } } } }
	 */

	/**
	 * @param paramsObj
	 *            参数对象
	 * @param charset
	 *            编码
	 * @return
	 * @throws UnsupportedEncodingException
	 * @Desc 获取请求参数
	 */
	@SuppressWarnings("unchecked")
	private static HttpEntity getEntity(Object paramsObj, String charset) throws UnsupportedEncodingException {
		if (paramsObj == null) {
			return null;
		}
		if (Map.class.isInstance(paramsObj)) { // 当前是map数据
			Map<String, String> paramsMap = (Map<String, String>) paramsObj;
			// 参数转换封装
			List<NameValuePair> list = getNameValuePairs(paramsMap);
			UrlEncodedFormEntity httpEntity = new UrlEncodedFormEntity(list, charset);
			// 内容类型
			httpEntity.setContentType(ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
			return httpEntity;
		} else if (String.class.isInstance(paramsObj)) {// 当前是string对象，可能是
			String paramsStr = paramsObj.toString();
			StringEntity httpEntity = new StringEntity(paramsStr, charset);
			// logger.info("数据:" + paramsStr);
			if (paramsStr.startsWith("{")) {
				httpEntity.setContentType(ContentType.APPLICATION_JSON.getMimeType());
			} else if (paramsStr.startsWith("<")) {
				httpEntity.setContentType(ContentType.APPLICATION_XML.getMimeType());
			} else {
				httpEntity.setContentType(ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
			}
			return httpEntity;
		} else {
			// logger.info("当前传入参数不能识别类型，无法生成HttpEntity");
			return null;
		}
	}

	/**
	 * @param httpResponse
	 *            http响应
	 * @param charset
	 *            响应信息编码
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 * @Desc 从结果中获取出String数据
	 */
	private static String getResult(CloseableHttpResponse httpResponse, String charset) throws ParseException, IOException {
		String result = null;
		if (httpResponse == null) {
			return result;
		}
		HttpEntity entity = httpResponse.getEntity();
		if (entity == null) {
			return result;
		}
		// System.out.println("StatusCode is " +
		// httpResponse.getStatusLine().getStatusCode());
		result = EntityUtils.toString(entity, charset);
		// 关闭应该关闭的资源，适当的释放资源 ;也可以把底层的流给关闭了(针对文件流的情况)
		EntityUtils.consume(entity);
		return result;
	}

	/**
	 * 转化请求编码
	 * 
	 * @param charset
	 * @return
	 */
	private static String getCharset(String charset) {
		return charset == null ? DEFAULT_CHARSET : charset;
	}

	/**
	 * @param paramsMap
	 *            map参数集合
	 * @return
	 * @Desc 将map类型参数转化为NameValuePair集合方式
	 */
	private static List<NameValuePair> getNameValuePairs(Map<String, String> paramsMap) {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		if (paramsMap == null || paramsMap.isEmpty()) {
			return list;
		}
		for (Entry<String, String> entry : paramsMap.entrySet()) {
			list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return list;
	}

	/**
	 * 
	 * @Desc 开启SSL支持(用于通讯安全)
	 */
	/*
	 * private static void enableSSL() { try { SSLContext context =
	 * SSLContext.getInstance("TLS"); context.init(null, new TrustManager[] {
	 * manager }, null); socketFactory = new SSLConnectionSocketFactory(context,
	 * NoopHostnameVerifier.INSTANCE); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	private static SSLConnectionSocketFactory socketFactory = SSLConnectionSocketFactory.getSocketFactory();
	/**
	 * https请求一般情况下使用了安全系数较低的SHA-1签名，因此首先我们在调用SSL之前需要重写验证方法，取消检测SSL。
	 */
	/*
	 * private static TrustManager manager = new X509TrustManager() {
	 * 
	 * @Override public X509Certificate[] getAcceptedIssuers() { return null; }
	 * 
	 * @Override public void checkServerTrusted(X509Certificate[] chain, String
	 * authType) throws CertificateException {
	 * 
	 * }
	 * 
	 * @Override public void checkClientTrusted(X509Certificate[] chain, String
	 * authType) throws CertificateException {
	 * 
	 * } };
	 */

	/**
	 * @param httpClientBuilder
	 *            客户端构建
	 * @param retryTimes
	 *            重试次数
	 * @Desc 为httpclient设置重试信息 (::该功能暂缓 后续有需要在扩充)
	 */
	private static void setRetryHandler(HttpClientBuilder httpClientBuilder, final int retryTimes) {
		HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				if (executionCount >= retryTimes) {
					// Do not retry if over max retry count
					return false;
				}
				if (exception instanceof InterruptedIOException) {
					// Timeout
					return false;
				}
				if (exception instanceof UnknownHostException) {
					// Unknown host
					return false;
				}
				if (exception instanceof ConnectTimeoutException) {
					// Connection refused
					return false;
				}
				if (exception instanceof SSLException) {
					// SSL handshake exception
					return false;
				}
				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				return idempotent;
			}
		};
		httpClientBuilder.setRetryHandler(myRetryHandler);
	}

	/**
	 * 从远程获取数据
	 * 
	 * @param strURL
	 * @return
	 * @throws Exception
	 */
	public static String getRemotePage(String strURL) throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL(strURL);

		HttpURLConnection httpConn;
		if (isProxy(strURL)) {
			InetSocketAddress addr = new InetSocketAddress(HTTP_PROXYHOST, Integer.parseInt(HTTP_PROXYPORT));
			Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);
			httpConn = (HttpURLConnection) url.openConnection(proxy);
		} else {
			httpConn = (HttpURLConnection) url.openConnection();
		}

		httpConn.setConnectTimeout(DEFAULT_SOCKETTIMEOUT);
		httpConn.setReadTimeout(DEFAULT_SOCKETTIMEOUT);
		InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
		BufferedReader bufReader = new BufferedReader(input);
		String line = "";
		StringBuilder contentBuf = new StringBuilder();
		while ((line = bufReader.readLine()) != null) {
			contentBuf.append(line);
		}
		String result = contentBuf.toString();

		return result;

	}

	/**
	 * @desc   : 判断是否满足代理	 
	 * @author : Bruce Liu
	 * @create : 2017年10月23日
	 * @return
	 */
	public static boolean isProxy(String url) {
		// 是否开通了代理
		if ("true".equals(HTTP_PROXY_ENABLE)) {
			// 设置白名单 ，若匹配成功，则不走代理
			Matcher m = Pattern.compile(HTTP_NONPROXYHOSTS).matcher(url);
			if (m.find()) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * @desc   : 	 
	 * @author : Bruce Liu
	 * @create : 2017年10月23日
	 * @return
	 */
	private static CloseableHttpClient createProxyHttpClient() {
		return createProxyHttpClient(HTTP_PROXYHOST, Integer.valueOf(HTTP_PROXYPORT), DEFAULT_RETRY_TIMES, DEFAULT_CONNECTTIMEOUT, DEFAULT_CONNECTIONREQUESTTIMEOUT, DEFAULT_SOCKETTIMEOUT);
	}
	
	/**
	 * 
	 * @param connectTimeout
	 * @param socketTimeout
	 * @return
	 * @date 2017年11月16日下午3:35:55
	 * @author cheng.chen
	 */
	public static CloseableHttpClient createProxyHttpClient(int connectTimeout, int socketTimeout) {
		return createProxyHttpClient(HTTP_PROXYHOST, Integer.valueOf(HTTP_PROXYPORT), DEFAULT_RETRY_TIMES,connectTimeout, DEFAULT_CONNECTIONREQUESTTIMEOUT, socketTimeout);
	}	
	
	/**
	 * 
	 * @param proxyHost
	 * @param proxyPort
	 * @param connectTimeout
	 * @param socketTimeout
	 * @return
	 * @date 2017年11月16日下午3:35:39
	 * @author cheng.chen
	 */
	public static CloseableHttpClient createProxyHttpClient(String proxyHost, int proxyPort, int connectTimeout, int socketTimeout) {
		return createProxyHttpClient(proxyHost, proxyPort, DEFAULT_RETRY_TIMES,connectTimeout, DEFAULT_CONNECTIONREQUESTTIMEOUT, socketTimeout);
	}

	/**
	 * @desc   : 	 
	 * @author : Bruce Liu
	 * @create : 2017年10月23日
	 * @param defaultRetryTimes
	 * @param defaultSockettimeout
	 * @return
	 */
	private static CloseableHttpClient createProxyHttpClient(String proxyHost, int proxyPort,int retryTimes, int connectTimeout, int connectionRequestTimeout, int socketTimeout) {
		// 构建请求配置
		Builder builder = RequestConfig.custom();
		// 设置连接超时时间，单位毫秒
		builder.setConnectTimeout(connectTimeout);
		// 设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
		builder.setConnectionRequestTimeout(connectionRequestTimeout);
		// 请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
		builder.setSocketTimeout(socketTimeout);
		RequestConfig defaultRequestConfig = builder.setCookieSpec(CookieSpecs.STANDARD_STRICT).setExpectContinueEnabled(true).setProxy(new HttpHost(proxyHost, proxyPort))
				.setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST)).setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();

		// 开启HTTPS支持
		// enableSSL();
		// 创建可用Scheme
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.INSTANCE).register("https", socketFactory).build();
		// 创建ConnectionManager，添加Connection配置信息
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		if (retryTimes > 0) {
			setRetryHandler(httpClientBuilder, retryTimes);
		}

		CloseableHttpClient httpClient = httpClientBuilder.setConnectionManager(connectionManager).setDefaultRequestConfig(defaultRequestConfig).build();

		return httpClient;
	}

//	public static void main(String[] args) throws Exception {
//		String result = getRemotePage("https://graph.qq.com/oauth2.0/me?access_token=D950FC6008DFBD470C49D83588FCBF11&unionid=1");
//		System.out.println(result);
//	}
}
