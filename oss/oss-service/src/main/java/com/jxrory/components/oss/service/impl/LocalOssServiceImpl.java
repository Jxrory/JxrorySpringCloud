package com.jxrory.components.oss.service.impl;

import com.jxrory.components.oss.config.LocalOssConfig;
import com.jxrory.components.oss.service.IOssService;
import com.jxrory.components.oss.utils.PathUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author Rory
 * @since 2022-04-28
 */
@Service
@ConditionalOnBean(LocalOssConfig.class)
public class LocalOssServiceImpl implements IOssService {

    @Resource
    private LocalOssConfig localOssConfig;

    @Override
    public String upload(String pathName, MultipartFile file) throws IOException {

        String fileName = PathUtil.filePath(localOssConfig.getPath(), pathName);

        File saveFile = new File(fileName);

        // 如果文件夹不存在则创建文件夹
        File dir = saveFile.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        file.transferTo(saveFile);

        if (StringUtils.isBlank(localOssConfig.getHttpUrl())) {
            return "";
        }
        return PathUtil.urlPath(localOssConfig.getHttpUrl(), localOssConfig.getPath(), pathName);
    }
}
