package com.zhangqi.usercenter.script;

import com.alibaba.excel.EasyExcel;

import java.util.List;

/**
 * @author ZhangQi
 * @Description
 * @createTime 2022年08月12日 16:55  周五
 */
public class ImportPlanetUser {

    public static void main(String[] args) {
        String fileName = "D:\\ideaProjects\\user-center\\src\\main\\resources\\testExcel.xlsx";


        List<PlanetTableUserInfo> totalDataList =
                EasyExcel.read(fileName).head(PlanetTableUserInfo.class).sheet().doReadSync();

        for (PlanetTableUserInfo planetTableUserInfo : totalDataList) {
            System.out.println(planetTableUserInfo);
        }
    }
}
