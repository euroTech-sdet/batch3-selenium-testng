package com.eurotech.day10;

import com.github.javafaker.Faker;

public class FirstClass {

    public static void main(String[] args) {


        System.out.println("Hello Selenium");

        Faker faker = new Faker();
        String name = faker.name().firstName();
        System.out.println(name);

        String name2 = faker.harryPotter().character();
        System.out.println("name2 = " + name2);

        String pass = faker.internet().password();

        System.out.println(pass);

        String card = faker.finance().creditCard();
        System.out.println("card = " + card);


    }

}
