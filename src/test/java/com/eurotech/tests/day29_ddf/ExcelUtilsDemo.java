package com.eurotech.tests.day29_ddf;

import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {


    @Test
    public void readExcelFile() {

        ExcelUtil testData = new ExcelUtil("src/test/resources/EurotechTest.xls","Test Data");

        //How many rows in the sheet
        System.out.println("testData.rowCount() = " + testData.rowCount());

        //how many columns in the sheet
        System.out.println("testData.columnCount() = " + testData.columnCount());

        //get all columns names
        System.out.println("testData.getColumnsNames() = " + testData.getColumnsNames());

        //get all data in list of maps

        List<Map<String, String>> dataList = testData.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println("oneRow = " + oneRow);

        }
        //get Oyku's password
        System.out.println("dataList.get(3).get(\"Password\") = " + dataList.get(3).get("Password"));

        //get Havva's company
        System.out.println("dataList.get(7).get(\"Company\") = " + dataList.get(7).get("Company"));

        //get Yusuf's username
        System.out.println("dataList.get(6).get(\"username\") = " + dataList.get(6).get("Username"));

        //get array
        String [][] dataArray= testData.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));


    }
}
