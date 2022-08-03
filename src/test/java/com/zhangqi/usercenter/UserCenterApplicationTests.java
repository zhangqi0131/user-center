package com.zhangqi.usercenter;

import com.zhangqi.usercenter.mapper.UserMapper;
import com.zhangqi.usercenter.model.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SpringBootTest()
//@RunWith(SpringRunner.class)

class UserCenterApplicationTests {

    @Resource
    private UserMapper userMapper;


    @Test
    void testDigest() throws NoSuchAlgorithmException {
        String newPassword = DigestUtils.md5DigestAsHex(("abcd" + "mypassword").getBytes());
        String result = new String(newPassword);
        System.out.println(result);
    }




    @Test
    public void testSelect() {

        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);

    }



}
