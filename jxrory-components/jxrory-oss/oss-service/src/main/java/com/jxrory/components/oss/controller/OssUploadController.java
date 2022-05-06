package com.jxrory.components.oss.controller;

import com.jxrory.common.api.CommonErrorCode;
import com.jxrory.common.exception.BizException;
import com.jxrory.components.oss.service.IOssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Rory
 * @since 2022-04-28
 */
@Slf4j
@RestController
@RequestMapping("/oss/upload")
@ConditionalOnProperty(prefix = "oss.controller", name = "enable", havingValue = "true", matchIfMissing = true)
@ConditionalOnBean(IOssService.class)
public class OssUploadController {

    @Resource
    private IOssService ossService;

    @PostMapping("/")
    public ResponseEntity<String> upload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        String url = "";
        try {
            url = ossService.upload(name, file);
        } catch (Exception e) {
            log.error("err={}", e.getMessage(), e);
            throw new BizException(CommonErrorCode.NETWORK_ERR);
        }
        return new ResponseEntity<>(url, HttpStatus.OK);
    }
}
