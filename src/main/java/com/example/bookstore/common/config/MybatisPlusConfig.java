package com.example.bookstore.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 * @author chrimer
 * <p>
 * MapperScan("com.xmut.edu.cn.mapper")：
 * 扫描指定包中的接口
 * <p>
 * MapperScan("com.xmut.edu.cn.*.mapper")：
 * 一个*代表任意字符串，但只代表一级包,比如可以扫到com.xmut.edu.cn.aaa.mapper,
 * 不能扫到com.xmut.edu.cn.aaa.bbb.mapper
 * <p>
 * MapperScan("com.xmut.edu.cn.**.mapper")：
 * 两个*代表任意个包,比如可以扫到com.xmut.edu.cn.aaa.mapper,
 * 也可以扫到com.xmut.edu.cn.aaa.bbb.mapper
 * <p>
 * 多个包
 * @MapperScan({"com.mysiteforme.admin.dao","com.zipon.tpf.dao"})
 */
@Configuration
@MapperScan("com.example.bookstore.**.mapper")
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

}
