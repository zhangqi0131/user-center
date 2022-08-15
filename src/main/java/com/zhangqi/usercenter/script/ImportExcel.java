package com.zhangqi.usercenter.script;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.util.ListUtils;

import java.io.File;
import java.util.List;

/**
 * @author ZhangQi
 * @Description
 * @createTime 2022年08月12日 15:32  周五
 */
public class ImportExcel {


    /**
     * 读取数据
     */
    public static void main(String[] args) {


        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "D:\\ideaProjects\\user-center\\src\\main\\resources\\testExcel.xlsx";

        //readByListener(fileName);

        synchronousRead(fileName);
    }

    /**
     * 监听器读取
     * @param fileName
     */
    public static void readByListener(String fileName) {
        EasyExcel.read(fileName, PlanetTableUserInfo.class, new TableListener()).sheet().doRead();

    }

    /**
     * 同步读
     * @param fileName
     */
    public static void synchronousRead(String fileName) {

        List<PlanetTableUserInfo> totalDataList =
                EasyExcel.read(fileName).head(PlanetTableUserInfo.class).sheet().doReadSync();

        for (PlanetTableUserInfo planetTableUserInfo : totalDataList) {
            System.out.println(planetTableUserInfo);
        }
    }

}
