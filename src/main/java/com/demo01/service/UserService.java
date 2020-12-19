package com.demo01.service;

import com.demo01.mapper.UserMapper;
import com.demo01.mybatis_mapper.MyBatisMapper;
import com.demo01.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private MyBatisMapper myBatisMapper;

    //根据id查询
    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> findByLike(String username, Long id){
        return myBatisMapper.findByLike(username,id);
    }

    public List<User> findAll(){return userMapper.selectAll();}

    //新增保存用户, @Transactional 添加事务
    @Transactional
    public void saveUser(User user){
        if(user==null){return;}
        System.out.println("新增用户");
        user.setId(null);
        int query = userMapper.insertSelective(user);
        System.out.println(query+"条信息已被存进数据库");
    }
    //更新用户, @Transactional 添加事务
    @Transactional
    public void updateUserByID(User user){
        if(user==null){return;}
        System.out.println("更新用户");
        int query = userMapper.updateByPrimaryKey(user);
        System.out.println(query+"条信息已被存进数据库");
    }

    //删除指定用户, @Transactional 添加事务
    @Transactional
    public void deleteUserByID(Long id){
        if(id==null){return;}
        System.out.println("删除用户");
        int query = userMapper.deleteByPrimaryKey(id);
        System.out.println(query+"条信息已被移除出数据库");
    }

}
