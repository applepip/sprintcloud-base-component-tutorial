package com.example.demo.userservice.impl;

import com.example.demo.userservice.UserFeignClient;
import org.springframework.stereotype.Component;


//容错备份方案
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public String login() {
        return "异常";
    }
}

//@Component
//public class UserFeignClientFallback implements UserFeignClient {
//
//    @Override
//    public String login(int count) {
//        return "异常";
//    }
//}
