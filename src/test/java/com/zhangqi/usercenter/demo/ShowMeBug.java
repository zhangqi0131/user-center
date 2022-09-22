//package com.zhangqi.usercenter.demo;
//
//import org.junit.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.io.*;
//
//
//// 请勿更改 `ShowMeBug` 类名以防执⾏失败
//@SpringBootTest
//public class ShowMeBug {
//
//
//    private int offset;
//
//    public ShowMeBug(int offset) {
//        // 你的实现
//        this.offset = offset;
//
//    }
//    public void setOffset(int offset) {
//        // 你的实现
//
//    }
//
//    public String encode(String input) {
//        // 你的实现
//        StringBuilder result = new StringBuilder();
//        for (char c : input.toCharArray()) {
//            if (c >= 'a' && c <= 'z') {
//                c += offset % 26; // 移动key%26位
//                if (c < 'a') {
//                    c += 26; // 向左超界
//                } else if (c > 'z') {
//                    c -= 26; // 向右超界
//                }
//            }
//            result.append(c);
//        }
//        return result.toString();
//    }
//    public OutputStream wrap(OutputStream output) throws IOException {
//        // 你的实现
//
//        String string = output.toString();
//        String encodeString = encode(string);
//
//        OutputStream os = System.out;
//        os.write(encodeString.getBytes());
//
//        output.flush();
//        return os;
//    }
//
//
//
//}