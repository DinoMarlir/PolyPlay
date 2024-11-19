package com.github.dinomarlir.polyplay.core.tests

import com.github.dinomarlir.polyplay.core.kt.PolyPlay
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test

class KotlinPolyPlayTests {

    @Test
    @DisplayName("Test if PolyPlay instance is not null")
    @Order(1)
    fun testPolyPlayInstance() = assertNotNull(PolyPlay)


    @Test
    @DisplayName("Test if you can register and get an instance")
    @Order(2)
    fun testRegisterAndGetInstanceOf() {
        PolyPlay.setInstanceOf(String::class.java, "Hello, World!")
        Assertions.assertEquals("Hello, World!", PolyPlay.getInstanceOf(String::class.java).get())
    }

    @Test
    @DisplayName("Test if you can remove an instance")
    @Order(3)
    fun testRemoveInstanceOf() {
        PolyPlay.setInstanceOf(String::class.java, "Hello, World!")
        PolyPlay.removeInstanceOf(String::class.java)
        Assertions.assertEquals(true, PolyPlay.getInstanceOf(String::class.java).isEmpty)
    }
}