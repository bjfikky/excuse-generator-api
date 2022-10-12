package com.benorim.excusegeneratorapi.Util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersUtilTest {

    @Test
    void getRandomNumber() {
        int randomNumber = NumbersUtil.getRandomNumber(3);
        assertTrue(List.of(0, 1, 2).contains(randomNumber));
    }
}