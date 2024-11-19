package com.github.dinomarlir.polyplay.core.tests;

import com.github.dinomarlir.polyplay.core.PolyPlay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PolyPlayTests {

    @Test
    @DisplayName("Test if PolyPlay instance is not null")
    @Order(1)
    public void testPolyPlayInstance() {
        PolyPlay polyPlay = PolyPlay.getInstance();
        assertNotNull(polyPlay);
    }

    @Test
    @DisplayName("Test if you can register and get an instance")
    @Order(2)
    public void testRegisterAndGetInstanceOf() {
        PolyPlay polyPlay = PolyPlay.getInstance();
        polyPlay.setInstanceOf(String.class, "Hello, World!");
        assertEquals("Hello, World!", polyPlay.getInstanceOf(String.class).get());
    }

    @Test
    @DisplayName("Test if you can remove an instance")
    @Order(3)
    public void testRemoveInstanceOf() {
        PolyPlay polyPlay = PolyPlay.getInstance();
        polyPlay.setInstanceOf(String.class, "Hello, World!");
        polyPlay.removeInstanceOf(String.class);
        assertEquals(true, polyPlay.getInstanceOf(String.class).isEmpty() );
    }
}