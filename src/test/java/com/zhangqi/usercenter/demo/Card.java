//package com.zhangqi.usercenter.demo;
//
//import org.apache.ibatis.logging.stdout.StdOutImpl;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//
///**
// * @author ZhangQi
// * @Description
// * @createTime 2022年09月13日 21:48  周二
// */
//@SpringBootTest
//public class Card {
//
//    @Test
//    public void solution() {
//        int[] hands1 = {1, 2, 3};
//        int[] hands2 = {2, 2, 3};
//
//        int[] sortedHands1 = sort(hands1);
//        int[] sortedHands2 = sort(hands2);
//
//        int sum1 = sumArray(sortedHands1);
//        int sum2 = sumArray(sortedHands2);
//
//        if (sum1 > sum2) {
//            System.out.println(sum1);
//        }
//        if (sum1 < sum2) {
//            System.out.println(sum2);
//        }
//    }
//
//    public int[] sort(int[] sourceArray) {
//        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            int min = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[min]) {
//                    // 记录目前能找到的最小值元素的下标
//                    min = j;
//                }
//            }
//
//            // 将找到的最小值和i位置所在的值进行交换
//            if (i != min) {
//                int tmp = arr[i];
//                arr[i] = arr[min];
//                arr[min] = tmp;
//            }
//        }
//        return arr;
//    }
//
//    public int sumArray(int[] hand) {
//        int sum = 0;
//        for (int i = hand.length - 1; i > hand.length - 4; i--) {
//            sum += hand[i];
//        }
//        return sum;
//    }
//}
