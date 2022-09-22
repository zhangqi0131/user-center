package com.zhangqi.usercenter.service;

import com.zhangqi.usercenter.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangQi
 * @Description 算法工具测试
 * @createTime 2022年09月22日 15:35  周四
 */
public class AlgorithmTest {


    @Test
    void testAlgorithm() {
        String a = "zzq";
        String b = "abzq";
        String c = "zqqqq";

        //2
        int score1 = AlgorithmUtils.minDistance(a, b);
        //3
        int score2 = AlgorithmUtils.minDistance(a, c);

        System.out.println("score1=" + score1);
        System.out.println("score2=" + score2);

    }
}
