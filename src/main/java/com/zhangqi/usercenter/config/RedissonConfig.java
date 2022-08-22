package com.zhangqi.usercenter.config;

import io.lettuce.core.RedisClient;
import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.api.RedissonRxClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhangQi
 * @Description
 * @createTime 2022年08月22日 23:37  周一
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonConfig {

    private String host;

    private String port;


    @Bean
    public RedissonClient redissonClient() {

        // 1. 创建配置
        Config config = new Config();
        // "redis://127.0.0.1:7181"
        String redisAddress = String.format("redis://%s:%s", host, port);
        config.useSingleServer().setAddress(redisAddress).setDatabase(3);

        // 2. 创建Redisson实例
        // Sync and Async API
        RedissonClient redisson = Redisson.create(config);

        return redisson;
    }


}
