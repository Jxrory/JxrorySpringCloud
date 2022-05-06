package com.jxrory.components.oss.service;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Rory
 * @since 2022-04-28
 */
@Component
public class OssServiceContext {

    @Resource
    private Map<String, IOssService> ossServiceMap;

    public IOssService getOssService(String name) {
        return ossServiceMap.get(name);
    }
}
