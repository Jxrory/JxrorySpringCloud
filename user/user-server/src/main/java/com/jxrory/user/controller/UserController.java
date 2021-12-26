package com.jxrory.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxrory.user.entity.User;
import com.jxrory.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jxrory
 * @since 2021-10-06
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${spring.datasource.url}")
    private String mysqlUrl;

    @Resource
    private IUserService iUserService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<User>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        log.info("mysqlUrl={}", mysqlUrl);
        Page<User> aPage = iUserService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(iUserService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody User params) {
        iUserService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        iUserService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> delete(@RequestBody User params) {
        iUserService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
