package utils;

import drivers.DriverFactory;

import java.util.Random;

public class UtilsHelper extends DriverFactory {

    public int generateRandomNumber(int size){
        Random random = new Random();
        return random.nextInt(size);
    }

}
