package com.zhangqi.usercenter.service;

import com.zhangqi.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * @author ZhangQi
 * @Description
 * @createTime 2022年08月21日 14:35  周日
 */
@SpringBootTest
public class RedisTest {


    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @Test

    public void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("zqString", "cat");
        //valueOperations.set("zqString1", 1);
        //valueOperations.set("zqString2", 2.4);
        //User user = new User();
        //user.setUsername("zqzqzq");
        //user.setId(1L);
        //
        //valueOperations.set("zqString3", user);

        Object zqString = valueOperations.get("zqString");
        Assertions.assertTrue("cat".equals((String)zqString));
        //
        //zqString = valueOperations.get("zqString1");
        //Assertions.assertTrue(1 == (Integer) zqString);
        //
        //
        //zqString=valueOperations.get("zqString2");
        //Assertions.assertTrue(2.4 == (Double) zqString);
        //
        //zqString=valueOperations.get("zqString3");
        //System.out.println(zqString);

    }
}
