package com.github.dinomarlir.polyplay.core.kt

import com.github.dinomarlir.polyplay.core.PolyPlay as JavaPolyPlay
import java.util.Optional

val PolyPlay: JavaPolyPlay by lazy { JavaPolyPlay.getInstance() }

fun JavaPolyPlay.transaction(block: Transaction.() -> Unit) {
    val transaction = Transaction(PolyPlay)
    transaction.block()
}

class Transaction(val polyPlay: JavaPolyPlay) {

    fun <T> instance(clazz: Class<T>, instance: T) {
        polyPlay.setInstanceOf(clazz, instance)
    }

    fun <T> instance(clazz: Class<T>, block: () -> T) {
        polyPlay.setInstanceOf(clazz, block())
    }

    fun <T> instance(clazz: Class<T>): T? {
        return polyPlay.getInstanceOf(clazz).orElse(null)
    }

    fun <T : Any> instanceOptional(clazz: Class<T>): Optional<T> {
        return polyPlay.getInstanceOf(clazz)
    }

    fun removeInstance(clazz: Class<*>) {
        polyPlay.removeInstanceOf(clazz)
    }
}