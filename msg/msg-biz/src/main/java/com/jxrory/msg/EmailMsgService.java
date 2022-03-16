package com.jxrory.msg;

import com.jxrory.msg.model.dto.SendCodeRespDto;

/**
 * 手机发送消息的服务
 *
 * @author Rory
 * @date 2022/03/02
 */
public interface EmailMsgService {

    /**
     * 发送邮箱信息
     *
     * @param email email
     * @param title title
     * @param content 内容
     * @return 返回值
     */
    SendCodeRespDto send(String email, String title, String content);

}
