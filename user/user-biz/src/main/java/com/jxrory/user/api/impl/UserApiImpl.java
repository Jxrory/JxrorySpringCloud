package com.jxrory.user.api.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jxrory.user.api.UserApi;
import com.jxrory.user.entity.User;
import com.jxrory.user.service.IUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jxrory
 * @date 2021/12/26 下午10:36
 */
@DubboService(protocol = "dubbo")
@Service
public class UserApiImpl implements UserApi {

    @Resource
    private IUserService userService;

    @Override
    public Map<Serializable, Object> findUserByIds(Set<Serializable> ids) {
        Map<Serializable, Object> res = new HashMap<>();
        userService.listByIds(ids).forEach(item -> res.put(item.getUserId(), item));
        return res;
    }
}
