package com.github.dinomarlir.polyplay.core.tests

import com.github.dinomarlir.polyplay.core.kt.PolyPlay
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test

class KotlinPolyPlayTests {

    @Test
    @Order(1)
    fun `Test if PolyPlay instance is not null`() = assertNotNull(PolyPlay)


    @Test
    @Order(2)
    fun `Test if you can register and get an instance`() {
        PolyPlay.setInstanceOf(String::class.java, "Hello, World!")
        Assertions.assertEquals("Hello, World!", PolyPlay.getInstanceOf(String::class.java).get())
    }

    @Test
    @Order(3)
    fun `Test if you can remove an instance`() {
        PolyPlay.setInstanceOf(String::class.java, "Hello, World!")
        PolyPlay.removeInstanceOf(String::class.java)
        Assertions.assertEquals(true, PolyPlay.getInstanceOf(String::class.java).isEmpty)
    }
}