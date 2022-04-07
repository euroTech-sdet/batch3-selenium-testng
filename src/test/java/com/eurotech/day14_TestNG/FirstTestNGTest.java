package com.eurotech.day14_TestNG;

import org.testng.annotations.Test;

public class FirstTestNGTest {


        @Test
        public void test1(){

                System.out.println("Web driver setup, browser opening");
                System.out.println("First Test Case");
                System.out.println("Closing Browser , quit");

        }
        @Test
        public void test2(){

                System.out.println("Test case 2");
        }


}
