package com.eurotech.day14_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionDemo {

    @BeforeMethod
    public void setup(){
        System.out.println("WebDriver open , browser setup");
    }

    @Test
    public void test1() {

        System.out.println("First Assertion");
        Assert.assertEquals("Title","Title"); //fail

        System.out.println("Second Assertion");
        Assert.assertEquals("URL","URy"); //pass

    }

    @Test
    public void test2() {

        Assert.assertEquals("TEST 2      passed","TEST 2 passed");
        System.out.println("TEST 2 passed");

    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Close Driver");
    }
}
