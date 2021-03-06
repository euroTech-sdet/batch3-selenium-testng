package com.eurotech.tests.day14_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAfterClass {

    @BeforeClass
    public void setUpClass(){
        System.out.println("-----BEFORE CLASS----");
        System.out.println("Her classtan once 1 kere calistir");
    }

    @Test
    public void test1() {

        System.out.println("First Test Case");
    }

    @BeforeMethod    //Her method oncesi calisir
    public void setup(){
        System.out.println("WebDriver setup, Opening Browser");
        System.out.println("driver.manage.windows.maximize");
    }

    @AfterMethod    //Her Method sonrasi calisir
    public void tearDown(){
        System.out.println("Closing Browser");
    }

    @Test
    public void test2() {

        System.out.println("Test case 2");
    }

    @Ignore @Test
    public void test3() {

        System.out.println("IGNORE");
    }

    @Test
    public void test4() {
        String email ="rasgele@gmail.com";

//        if(email.contains("@")){
//            System.out.println("Pass");
//        }else {
//            System.out.println("Fail");
//        }

        Assert.assertTrue(email.contains("@")&email.contains(".com"),"verify email contains @");

    }

    @Test
    public void test5() {

        Assert.assertFalse(0>1,"verify that 0 1 den buyuk degildir");


    }

    @Test
    public void test6() {

        Assert.assertNotEquals("ali","ahmet","Ali ve ahmet isimleri ayni degildir");


    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("----AFTER CLASS------");
        System.out.println("SOON Reporting Code HERE");
    }

}
