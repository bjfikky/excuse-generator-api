package com.benorim.excusegeneratorapi.Util;

import java.util.Random;

public class NumbersUtil {

    public static int getRandomNumber(int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound);
    }
}
