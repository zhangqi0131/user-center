package com.zhangqi.usercenter.service;

import java.util.Date;

import com.zhangqi.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ZhangQi
 * @version 1.0.0
 * @Description 用户服务测试
 * @createTime 2022年03月14日 21:03  周一
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("testzq");
        user.setUserAccount("123");
        user.setAvatarUrl("https://www.toopic.cn/public/uploads/small/1637562996238163756299635.png");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("123");
        user.setEmail("123");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);

    }


    @Test
    void userRegister() {
        //String userAccount = "zqqq";
        //String password = "12345678";
        //String checkPassword = "12345678";
        //userService.userRegister(userAccount, password, checkPassword);



        //long result =  userService.userRegister("zhangqiqi", "123456789", "123456789");
        //System.out.println(result);
        //Assertions.assertEquals(-1, result);
        //
        //userAccount = "zha";
        //result = userService.userRegister(userAccount, password, checkPassword);
        //Assertions.assertEquals(-1, result);
        //
        //userAccount = "zhangqi";
        //password = "123456";
        //result = userService.userRegister(userAccount, password, checkPassword);
        //Assertions.assertEquals(-1, result);
        //
        //
        //password = "12345689";
        //checkPassword = "1234567";
        //result = userService.userRegister(userAccount, password, checkPassword);
        //Assertions.assertEquals(-1, result);
        //
        //userAccount = "zhang qi";
        //password = "1234567";
        //result = userService.userRegister(userAccount, password, checkPassword);
        //Assertions.assertEquals(-1, result);
        //
        //userAccount = "zhangqi";
        //result = userService.userRegister(userAccount, password, checkPassword);
        //Assertions.assertTrue(result > 0);
    }
}