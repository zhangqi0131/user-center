package com.zhangqi.usercenter.script;
import java.util.Date;

import com.zhangqi.usercenter.mapper.UserMapper;
import com.zhangqi.usercenter.model.domain.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * @author ZhangQi
 * @Description
 * @createTime 2022年08月20日 00:02  周六
 */
@Component
public class InsertUsers {

    @Resource
    private UserMapper userMapper;

    /**
     * 插入用户
     */
    //@Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final int number = 1000;
        for (int i = 0; i < number; i++) {
            User user = new User();
            user.setUsername("测试用户");
            user.setUserAccount("测试账号");
            user.setAvatarUrl("https://www.toopic.cn/public/uploads/small/1637562996238163756299635.png");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("123");
            user.setEmail("123");
            user.setTags("java");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("1111");

            userMapper.insert(user);

        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }


}
