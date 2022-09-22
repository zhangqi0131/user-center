package com.zhangqi.usercenter.script;

import io.github.classgraph.utils.WorkQueue;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ZhangQi
 * @Description
 * @createTime 2022年08月25日 15:46  周四
 */
public class Singleton {

    //private volatile static Singleton uniqueInstance;
    //
    //private Singleton() {
    //}
    //
    //public static synchronized Singleton getUniqueInstance() {
    //    //先判断对象是否已经实例过，没有实例化过才进入加锁代码
    //    if (uniqueInstance == null) {
    //        //类对象加锁
    //        synchronized (Singleton.class) {
    //            if (uniqueInstance == null) {
    //                uniqueInstance = new Singleton();
    //            }
    //        }
    //    }
    //    return uniqueInstance;
    //}
    //
    //public void threadTest() {
    //}


    private static volatile Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


}
