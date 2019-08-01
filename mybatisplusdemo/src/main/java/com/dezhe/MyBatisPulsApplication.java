package com.dezhe;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author dezhe
 * @Date 2019/8/1 12:48
 */
@MapperScan("com.dezhe.mapper")
@SpringBootApplication
public class MyBatisPulsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPulsApplication.class);
    }

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}
