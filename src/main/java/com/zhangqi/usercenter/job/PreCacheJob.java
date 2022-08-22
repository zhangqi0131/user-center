package com.zhangqi.usercenter.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangqi.usercenter.mapper.UserMapper;
import com.zhangqi.usercenter.model.domain.User;
import com.zhangqi.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangQi
 * @Description 预热缓存
 * @createTime 2022年08月22日 01:21  周一
 */
@Component
@Slf4j
public class PreCacheJob {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    List<Long> mainUserList = Arrays.asList(1L);


    @Scheduled(cron = "0 42 1 * * ? ")
    public void doCacheRecommendUser() {

        for (Long userId : mainUserList) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
            String redisKey = String.format("yupao:user:recommed:%s", userId);
            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
            try {
                valueOperations.set(redisKey, userPage, 30000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                // 缓存写失败了也可以把数据库查出来的值返回给前端
                log.error("redis set key error", e);
            }
        }

    }
}
