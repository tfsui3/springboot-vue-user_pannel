package com.demo01.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data在编译阶段会根据注解自动生成getter，setter，hashcode，equals，toString等方法
@Data
@Table(name = "user")
public class User {

    @Id
    //主键回填：如果id值是自增值，新增一个user后，会自动将id值回填到 对象中
    @KeySql(useGeneratedKeys = true)
    private Long id;

    //@Column(name = "***")，当数据库命名不规则时
    //user_name --> userName, 符合驼峰规则，可以自动对应
    private String username;
    private Integer age;
    private String email;
    private String password;
    @Column(name="phoneNum")
    private String phoneNum;

}