package com.example.demo.userservice;


import com.example.demo.model.User;
import com.example.demo.userservice.impl.UserFeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "dm-user-provider")
//熔断备份方案
@FeignClient(name = "dm-user-provider", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login();

//    //调传的参数
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public boolean login(@RequestParam("name") String name, @RequestParam("pwd") String pwd);

//    //中间件调传的参数
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public boolean login(@RequestBody User user);

//    //hystrix熔断
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login();

//    //ribbon负债均衡
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestParam("count") int count);

}