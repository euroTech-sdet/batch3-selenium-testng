package com.eurotech.tests.day29_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFwithDataProvider {


    @DataProvider
    public Object [][] test123(){
       String [][]data ={{"Turkey","Ankara"},
               {"Germany","Berlin"},
               {"UK","London"},
               {"Scotland","Edinburgh"},
               {"Netherlands","Amsterdam"},
               {"Saudi Arabia","Riyad"},
               {"United Arab Emirates","Abu Dabi"}
    };
       return data;
}

    @Test(dataProvider = "test123")
    public void testCity(String country, String capitalCity) {
        System.out.println("Country: "+country+" capital city "+capitalCity);

    }
}

