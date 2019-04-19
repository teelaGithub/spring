package com.demo.service.impl;

import com.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author litinglan 2019/4/15 10:38
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    @Transactional
    public String getByName(String name) {
        System.out.println("执行业务代码");
        return name;
    }
}
