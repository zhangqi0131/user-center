package com.zhangqi.usercenter.service;

import com.zhangqi.usercenter.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    void testAlgorithmTagList() {
        List<String> tagList1 = Arrays.asList("Java", "大一", "男");
        List<String> tagList2 = Arrays.asList("Java", "大一", "女");
        List<String> tagList3 = Arrays.asList("Python", "大二", "女");

        int score1 = AlgorithmUtils.minDistance(tagList1, tagList2);
        int score2 = AlgorithmUtils.minDistance(tagList1, tagList3);
        int score3 = AlgorithmUtils.minDistance(tagList2, tagList3);

        System.out.println(score1);
        System.out.println(score2);
        System.out.println(score3);
    }
}
