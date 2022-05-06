package com.jxrory.components.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.jxrory.common.exception.BizException;
import com.jxrory.components.oss.config.AliOssConfig;
import com.jxrory.components.oss.exception.OssErrorCode;
import com.jxrory.components.oss.service.IOssService;
import com.jxrory.components.oss.utils.PathUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Rory
 * @since 2022-04-28
 */
@Slf4j
@Service
@ConditionalOnBean(AliOssConfig.class)
public class AliOssServiceImpl implements IOssService {

    private static OSS ossClient;

    @Resource
    private AliOssConfig aliOssConfig;

    @PostConstruct
    public void initOssClient() {
        log.debug("Ali oss begin initOssClient");
        if (null == ossClient && aliOssConfig != null && StringUtils.isNotBlank(aliOssConfig.getOssUrl())) {
            ossClient = new OSSClientBuilder().build(aliOssConfig.getOssUrl(), aliOssConfig.getAccessId(), aliOssConfig.getAccessKey());
        }
        log.debug("Ali oss end initOssClient");
    }

    @Override
    public String upload(String pathName, MultipartFile file) throws IOException {
        if (aliOssConfig != null) {
            // 阿里云存储配置不正确
            throw new BizException(OssErrorCode.ALI_OSS_CONFIG_ERROR);
        }
        if (ossClient == null) {
            // 阿里云存储初始化异常
            throw new BizException(OssErrorCode.ALI_OSS_INIT_FAILED);
        }

        log.info("oss upload image start ... param : {}", pathName);
        String fileName = PathUtil.urlPath(aliOssConfig.getPath(), pathName);
        ossClient.putObject(aliOssConfig.getBucketName(), fileName, file.getInputStream());
        log.info("oss upload image end ...");

        return PathUtil.urlPath(aliOssConfig.getHttpUrl(), fileName);
    }
}
