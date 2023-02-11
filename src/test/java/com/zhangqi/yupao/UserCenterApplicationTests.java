package com.zhangqi.yupao;

import com.zhangqi.yupao.mapper.UserMapper;
import com.zhangqi.yupao.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
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
