package com.jxrory.user.service.impl;

import com.jxrory.user.entity.User;
import com.jxrory.user.mapper.UserMapper;
import com.jxrory.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jxrory
 * @since 2021-10-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
