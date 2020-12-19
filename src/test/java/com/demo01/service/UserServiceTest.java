package com.demo01.service;

import com.demo01.mybatis_mapper.MyBatisMapper;
import com.demo01.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Resource
    private MyBatisMapper mapper;

    @Test
    public void queryById() {
        User user = userService.queryById(1L);
        System.out.println(user);
    }
    @Test
    public void queryByLike() {
        List<User> list = mapper.findByLike("tf",10L);
        System.out.println(list);
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("123");
        user.setAge(10);
        user.setEmail("123@gmail.com");
        user.setPassword("12345");
        user.setPhoneNum("123-455");

        userService.saveUser(user);
    }
}