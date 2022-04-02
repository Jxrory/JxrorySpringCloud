package com.jxrory.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * IP处理工具类
 *
 * @author Rory
 * @date 2022/03/16
 */
@Slf4j
public class NetworkUtils {

    private static final String UNKNOWN_STR = "unknown";
    private static final String LOCAL_LOOP_IP = "127.0.0.1";
    private static final int SINGLE_IP_MAX_LENGTH = 15;

    private static final String[] IP_HEADERS = new String[]{
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_CLIENT_IP",
            "HTTP_X_FORWARDED_FOR"
    };

    /**
     * 获取请求主机IP地址
     * 如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request 网络请求
     * @return ip 地址
     */
    public static String getIpAddress(HttpServletRequest request) {

        String ip = "";

        for (String headerStr : IP_HEADERS) {
            ip = request.getHeader(headerStr);
            if (StringUtils.isNotBlank(ip) && !UNKNOWN_STR.equalsIgnoreCase(ip)) {
                log.debug("getIpAddress(HttpServletRequest) - {} - String ip={}", headerStr, ip);
                break;
            }
        }

        if (StringUtils.isBlank(ip) || UNKNOWN_STR.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            log.debug("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
            if (LOCAL_LOOP_IP.equals(ip)) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (Exception e) {
                    log.warn("getIpAddress InetAddress.getLocalHost() error={}", e.getMessage());
                }
            }
        }

        if (ip.length() > SINGLE_IP_MAX_LENGTH) {
            // 多个代理的情况, 第一个IP为客户端真实IP, 多个IP按照','分割
            String[] ips = ip.split(",");
            for (String strIp : ips) {
                if (!(UNKNOWN_STR.equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
