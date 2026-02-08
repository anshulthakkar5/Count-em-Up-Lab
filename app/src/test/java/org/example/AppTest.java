package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testInitialValue() {
        GroceryCounter counter = new GroceryCounter();
        assertEquals("$0.00", counter.total());
    }

    @Test
    void testIncrementMethods() {
        GroceryCounter counter = new GroceryCounter();

        counter.ones();        // +1.00
        counter.tenths();      // +0.10
        counter.hundredths();  // +0.01

        assertEquals("$1.11", counter.total());
    }

    @Test
    void testFormatting() {
        GroceryCounter counter = new GroceryCounter();

        counter.ones();
        counter.hundredths(); // should be $1.01 NOT $1.1

        assertEquals("$1.01", counter.total());
    }

    @Test
    void testOverflow() {
        GroceryCounter counter = new GroceryCounter();

        for(int i = 0; i < 1000; i++) {
            counter.tens(); // forces wrap past 9999
        }

        assertTrue(counter.overflows() > 0);
    }

    @Test
    void testClear() {
        GroceryCounter counter = new GroceryCounter();

        counter.ones();
        counter.clear();

        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }
}

