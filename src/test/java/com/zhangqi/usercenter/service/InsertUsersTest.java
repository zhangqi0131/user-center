package com.zhangqi.usercenter.service;

import com.zhangqi.usercenter.mapper.UserMapper;
import com.zhangqi.usercenter.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ZhangQi
 * @Description
 * @createTime 2022年08月20日 00:16  周六
 */
@SpringBootTest
public class InsertUsersTest {

    @Resource
    private UserService userService;

    private ExecutorService executorService = new ThreadPoolExecutor(60, 100, 10000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10000));


    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final int number = 100000;
        List<User> userList = new ArrayList<>();
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

            userList.add(user);

        }
        userService.saveBatch(userList, 10000);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());

        // 17秒100000条
    }

    @Test
    public void doConcurrencyInsertUsers() {


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        final int number = 100000;
        // 分成10组

        int j = 0;
        int batchSize = 5000;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            List<User> userList = new ArrayList<>();

            while (true) {
                j++;
                User user = new User();
                user.setUsername("测试用户");
                user.setUserAccount("测试账号");
                user.setAvatarUrl("https://www.toopic.cn/public/uploads/small/1637562996238163756299635.png");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setPhone("123");
                user.setEmail("123");
                user.setTags("[]");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setPlanetCode("1111");

                userList.add(user);

                if (j % batchSize == 0) {
                    break;
                }
            }
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("Thread name: " + Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            }, executorService);
            futureList.add(future);
        }

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();

        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());

    }

}
