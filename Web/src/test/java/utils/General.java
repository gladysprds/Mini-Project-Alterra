package utils;

import java.util.Random;

public class General {
    Random rand = new Random();

    public String randomUsername(){
        return "gladys" + + rand.nextInt(1000);
    }

    public String randomEmail(){
        return "gladys" + + rand.nextInt(1000) + "@gmail.com";
    }
}