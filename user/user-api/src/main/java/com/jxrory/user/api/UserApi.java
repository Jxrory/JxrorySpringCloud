package com.jxrory.user.api;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * @author jxrory
 * @date 2021/12/26 下午10:30
 */
public interface UserApi {

    /**
     * 根据id查询用户
     *
     * @param ids 用户 ID
     * @return {@link Map<Long, Object>}
     */
    Map<Serializable, Object> findUserByIds(Set<Serializable> ids);
}
