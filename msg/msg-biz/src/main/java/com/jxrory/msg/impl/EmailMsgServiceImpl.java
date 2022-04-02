package com.jxrory.msg.impl;

import com.jxrory.common.api.CommonErrorCode;
import com.jxrory.msg.EmailMsgService;
import com.jxrory.msg.model.dto.SendCodeRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Rory
 * @date 2022/03/06
 */
@Slf4j
@Service
public class EmailMsgServiceImpl implements EmailMsgService {

    @Value("${spring.mail.properties.from}")
    private String emailSendFrom;

    @Resource
    private JavaMailSenderImpl mailSender;

    @Override
    public SendCodeRespDto send(String email, String title, String content) {
        log.debug("emailFrom=, emailTo={}, title={}, content={}", email, title, content);
        // send message
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(emailSendFrom);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(content);
        mailSender.send(simpleMailMessage);

        return new SendCodeRespDto(CommonErrorCode.OK);
    }
}
