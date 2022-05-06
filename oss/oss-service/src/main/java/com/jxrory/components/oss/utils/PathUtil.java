package com.jxrory.components.oss.utils;

import java.nio.file.Paths;

/**
 * @author Rory
 * @since 2022-04-28
 */
public class PathUtil {

    private static final String HTTP_STR = "http://";
    private static final String HTTPS_STR = "https://";

    public static String filePath(String first, String... more) {
        return Paths.get(first, more).toString();
    }

    /**
     * 剔除路径中的双'/'
     *
     * @param first
     * @param more
     * @return
     */
    public static String urlPath(String first, String... more) {
        String urlProtocol = "";
        String urlFirst = first;
        if (first.startsWith(HTTP_STR)) {
            urlFirst = first.substring(HTTP_STR.length());
            urlProtocol = HTTP_STR;
        } else if (first.startsWith(HTTPS_STR)) {
            urlFirst = first.substring(HTTPS_STR.length());
            urlProtocol = HTTPS_STR;
        }

        StringBuilder sb = new StringBuilder(urlFirst);
        for (String s : more) {
            sb.append('/').append(s);
        }

        return urlProtocol + sb.toString().replace(" ", "").replaceAll("/+", "/");
    }
}
