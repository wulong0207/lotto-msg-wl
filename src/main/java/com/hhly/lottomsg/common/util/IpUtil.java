package com.hhly.lottomsg.common.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import com.hhly.lottomsg.base.exception.ServiceRuntimeException;

/**
 * @desc 获取ip
 * @author jiangwei
 * @date 2017年7月26日
 * @company 益彩网络科技公司
 * @version 1.0
 */
public abstract class IpUtil {
	/**
     * 获取本地IP地址
     *
     * @throws SocketException
     */
    public static String getLocalIP(){
    	try {
    		if (isWindowsOS()) {
                return InetAddress.getLocalHost().getHostAddress();
            } else {
                return getLinuxLocalIp();
            }
		} catch (Exception e) {
			throw new ServiceRuntimeException("获取ip异常",e);
		}
        
    }
    /**
     * 判断操作系统是否是Windows
     *
     * @return
     */
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }
    /**
     * 获取Linux下的IP地址
     *
     * @return IP地址
     * @throws SocketException
     */
    private static String getLinuxLocalIp() throws SocketException {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                                ip = ipaddress;
                            }
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            ip = "127.0.0.1";
            ex.printStackTrace();
        }
        return ip;
    }
}
