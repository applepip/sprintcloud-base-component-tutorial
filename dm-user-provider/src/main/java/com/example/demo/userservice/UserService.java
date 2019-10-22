package com.example.demo.userservice;

import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserService {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() throws Exception{
        return "用户已验证";
    }

//    //传参数
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public boolean login(@RequestParam("name") String name, @RequestParam("pwd") String pwd) throws Exception{
//        return "admin".equals(name) && "123456".equals(pwd);
//    }

//    //中间件传参数
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public boolean login(@RequestBody User user) throws Exception{
//        return "admin".equals(user.getUsername()) && "123456".equals(user.getPassword());
//    }
//
//    //熔断
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login() throws Exception{
//        return "用户已验证";
//    }

//    //ribbon负债均衡
//    private Logger logger = LoggerFactory.getLogger(UserService.class);
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestParam("count") int count) throws Exception{
//        logger.info("access @ provider 8080" + count);
//        return "用户已验证";
//    }

}
