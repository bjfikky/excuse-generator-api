package com.benorim.excusegeneratorapi.Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersUtilTest {

    @Test
    void getRandomNumber() {
        int randomNumber = NumbersUtil.getRandomNumber(1);
        assertEquals(0, randomNumber);
    }
}