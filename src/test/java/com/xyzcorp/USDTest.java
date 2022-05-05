package com.xyzcorp;

import org.junit.Test;

import static org.junit.Assert.*;

public class USDTest {
    @Test
    public void testComparison() {
        USD usd0 = new USD(30);
        USD usd1 = new USD(-50);
        System.out.println(usd1.compareTo(usd0));
        System.out.println(usd0.compareTo(usd1));
    }
}
