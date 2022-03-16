package com.jxrory.msg.controller;

import com.jxrory.msg.EmailMsgService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Rory
 * @date 2022/03/16
 */
@RestController
@RequestMapping("/api/msg/email")
public class EmailController {

    @Resource
    private EmailMsgService emailMsgService;

    @PostMapping("/code")
    public void sendCodeMsg() {
        emailMsgService.send("rory@jxrory.com", "test email", "test content" + new Date().toString());
    }
}
