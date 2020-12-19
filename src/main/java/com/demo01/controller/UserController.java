package com.demo01.controller;

import com.demo01.pojo.User;
import com.demo01.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.List;

@RestController
/* @CrossOrigin 此注解解决跨域问题*/
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

//    @Value("${abc.a}")
//    private String abcA;

    @GetMapping("hello")
    public String hello(){
        //System.out.println("abcA = "+ abcA);
        System.out.println(dataSource);
        return "hello Spring";
    }

    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id){
        User user = userService.queryById(id);

        return user;
    }

    @PostMapping("/findByLike")
    //如果要获取{id}，一定要在括号内声明参数 (@PathVariable Long id)
    public List<User> queryByLike(@RequestBody User user) {
        System.out.println("根据:username和id,进行模糊查询");
        return userService.findByLike(user.getUsername(),user.getId());
    }

    @GetMapping("/findAll")
    public List<User> queryById(){
        List<User> list = userService.findAll();

        return list;
    }

    @PostMapping("/save")
    //注意！！！！！
    //如果要获取request的参数，一定要加@RequestBody!!!!!
    public void save(@RequestBody User user) {
        System.out.println("添加用户:"+user);
        userService.saveUser(user);
    }

    @PostMapping("/update")
    public void update(@RequestBody User user) {
        System.out.println("更新User:"+user);
        if(user.getId()==null){return;}
        userService.updateUserByID(user);
    }

    @PostMapping("/delete/{id}")
    //如果要获取{id}，一定要在括号内声明参数 (@PathVariable Long id)
    public void delete(@PathVariable Long id) {
        System.out.println("删除id:"+id);
        userService.deleteUserByID(id);
    }


}
