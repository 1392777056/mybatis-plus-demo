package com.dezhe.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dezhe.mapper.UserMapper;
import com.dezhe.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author dezhe
 * @Date 2019/8/1 12:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectTest(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void selectByIdTest(){
        User user = userMapper.selectById(3L);
        System.out.println(user);
    }

    @Test
    public void selectListTest(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("age",20);
        wrapper.like("name","o");
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void save(){
        User user = new User();
        user.setName("张三测试1");
        user.setAge(18);
        user.setEmail("1325474545@qq.com");
        userMapper.insert(user);
    }

    @Test
    public void deleteById(){
        userMapper.deleteById(7L);
        System.out.println("删除成功");
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(6L);
        user.setName("wangwu1");
        userMapper.updateById(user);
    }

    @Test
    public void selectPageList(){
        Page<User> page = new Page<>(3,2);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);
    }

}
