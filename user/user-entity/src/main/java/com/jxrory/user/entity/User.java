package com.jxrory.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jxrory
 * @since 2021-10-08
 */
@Data
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 是否可用, 1、是, 0、否
     */
    private Integer usable;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 性别, 1 男, 2 女
     */
    private Integer gender;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像url
     */
    private String avatarUrl;

    /**
     * 微信 openId
     */
    private String openId;

    /**
     * 微信 union_id
     */
    private String unionId;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 语言
     */
    private String language;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 评论
     */
    private String remarks;

    /**
     * 最后密码修改时间
     */
    private Date lastPasswordResetTime;

}
