package com.example.marsi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestCrap {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        if (3>4)
            fail("we failed");
    }

    @Test
    void test2() {
        assertEquals("ABC", "ABC");
    }

    @Test
    void testDiv0() {
        int i = 10;
        int y = 0;
        assertEquals(0, i/y);
    }

}
