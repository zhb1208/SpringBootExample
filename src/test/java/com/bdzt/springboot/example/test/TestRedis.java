package com.bdzt.springboot.example.test;

import com.bdzt.springboot.example.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * TODO:add description of class here, then delete the line.
 *
 * @author zhanghongbing
 * @version 17/10/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        User user=new User();
        user.setId(1);
        user.setName("张三");
        user.setPassword("123456");
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("com.bdzt.example.a", user);
        operations.set("com.bdzt.example.f", user,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        User user1 =  operations.get("com.bdzt.example.a");
        System.out.println("user:" + user1);
        boolean exists1=redisTemplate.hasKey("com.bdzt.example.a");
        if(exists1){
            System.out.println("exists1 is true");
        }else{
            System.out.println("exists1 is false");
        }
        boolean exists2=redisTemplate.hasKey("com.bdzt.example.f");
        if(exists2){
            System.out.println("exists2 is true");
        }else{
            System.out.println("exists2 is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}
