package com.eurotech.tests.day29_ddf;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {


    @DataProvider
    public Object [] [] userData(){
        ExcelUtil testData =new ExcelUtil("src/test/resources/EurotechTest.xls","Test Data");

        String [][] dataArray= testData.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test
    public void ddfLoginTest() {
    }
}
