//package com.zhangqi.usercenter.demo;
//
//import java.util.Arrays;
//
///**
// * @author ZhangQi
// * @Description
// * @createTime 2022年09月13日 22:25  周二
// */
//public class Card1 {
//
//
//    public int[] sort(int[] sourceArray) {
//        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
//
//        // 总共要经过 N-1 轮比较
//        for (int i = 0; i < arr.length - 1; i++) {
//            int min = i;
//
//            // 每轮需要比较的次数 N-i
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
//
//        }
//        return arr;
//    }
//
//}
