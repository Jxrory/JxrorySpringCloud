package com.jxrory.order.controller;

import com.jxrory.user.api.UserApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jxrory
 * @date 2021/12/26 下午11:53
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @DubboReference
    private UserApi userApi;

    @GetMapping
    public ResponseEntity<String> getOrderInfo() {

        Set<Serializable> list = new HashSet<>();
        list.add(1L);
        list.add(5L);
        Map<Serializable, Object> res = userApi.findUserByIds(list);
        log.info("res: {}", res);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
