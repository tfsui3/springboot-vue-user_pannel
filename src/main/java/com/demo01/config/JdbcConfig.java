package com.demo01.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@EnableConfigurationProperties(JdbcProperties.class)
//public class JdbcConfig {

    //@ConfigurationProperties(prefix = "jdbc")
    /*springboot 自动引入配置类中的相关属性的set方法并注入属性*/
    /*注意：配置类中必须要有对应的set方法！*/
//    @Bean
//    @ConfigurationProperties(prefix = "jdbc")
//    public DataSource dataSource() {
//        return new DruidDataSource();
//    }

//    @Bean("dataSource")
//    public DataSource dataSource(JdbcProperties jdbcProperties) {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
//        dataSource.setUsername(jdbcProperties.getUsername());
//        dataSource.setPassword(jdbcProperties.getPassword());
//        dataSource.setUrl(jdbcProperties.getUrl());
//        return dataSource;
//    }
//}
