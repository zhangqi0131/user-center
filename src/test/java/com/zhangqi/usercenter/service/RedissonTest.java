package com.zhangqi.usercenter.service;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangQi
 * @Description
 * @createTime 2022年08月22日 23:48  周一
 */
@SpringBootTest
public class RedissonTest {


    @Resource
    private RedissonClient redissonClient;


    @Test
    void test() {

        // list
        List<String> list = new ArrayList<>();
        list.add("zq");

        list.get(0);
        System.out.println(list);

        RList<String> rList = redissonClient.getList("test-list");
        rList.add("zqq");
        rList.get(0);

        System.out.println("rList" + rList);



        // map
        Map<String, Integer> map = new HashMap<>();

        map.put("zq", 1);

        RMap<String, Integer> zqqq = redissonClient.getMap("zqqq");
        zqqq.put("zq", 10);


        // set



    }
}
