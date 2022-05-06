package com.eurotech.tests.day23_properties_singleton;

public class Singleton {

    // Singleton class will have private constructor
    // So other classes cannot create object of this class

    private Singleton() {};

    private static String str;

    public static String getInstance() {

        // if str has no value, initialize it and then return
        if(str == null) {
            System.out.println("str is null, assigning a value to it");
            str = "abcdef";
        }else {

            // if it has value, just return it
            System.out.println("str has a value, just returning it");
        }
        return str;
    }

}
