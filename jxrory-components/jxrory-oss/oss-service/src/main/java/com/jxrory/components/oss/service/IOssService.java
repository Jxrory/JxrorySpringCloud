package com.jxrory.components.oss.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Rory
 * @since 2022-04-14
 */
public interface IOssService {

    /**
     * 文件上传
     *
     * @param pathName 文件路径+名字
     * @param file     文件
     * @return url 访问路径
     * @throws IOException IO 异常
     */
    String upload(String pathName, MultipartFile file) throws IOException;
}
