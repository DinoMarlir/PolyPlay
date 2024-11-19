package com.github.dinomarlir.polyplay.core.kt

import java.util.*
import com.github.dinomarlir.polyplay.core.PolyPlay as JavaPolyPlay

/**
 * The PolyPlay instance.
 * @see JavaPolyPlay
 */
val PolyPlay: JavaPolyPlay by lazy { JavaPolyPlay.getInstance() }

/**
 * A transaction block to make it easier to work with PolyPlay.
 * @param block The transaction block.
 * @see Transaction
 */
fun JavaPolyPlay.transaction(block: Transaction.() -> Unit) {
    val transaction = Transaction(PolyPlay)
    transaction.block()
}

/**
 * The class for the transaction block.
 * @param polyPlay The PolyPlay instance.
 */
class Transaction(val polyPlay: JavaPolyPlay) {

    /**
     * Registers an instance of a class.
     * @param clazz The class.
     * @param instance The instance.
     * @see JavaPolyPlay.setInstanceOf
     */
    fun <T> instance(clazz: Class<T>, instance: T) {
        polyPlay.setInstanceOf(clazz, instance)
    }

    /**
     * Registers an instance of a class.
     * @param clazz The class.
     * @param block The block to create the instance.
     * @see JavaPolyPlay.setInstanceOf
     */
    fun <T> instance(clazz: Class<T>, block: () -> T) {
        polyPlay.setInstanceOf(clazz, block())
    }

    /**
     * Gets an instance of a class.
     * @param clazz The class.
     * @return The instance.
     * @see JavaPolyPlay.getInstanceOf
     */
    fun <T> instance(clazz: Class<T>): T? {
        return polyPlay.getInstanceOf(clazz).orElse(null)
    }

    /**
     * Gets an instance of a class.
     * @param clazz The class.
     * @return The instance.
     * @see JavaPolyPlay.getInstanceOf
     */
    fun <T : Any> instanceOptional(clazz: Class<T>): Optional<T> {
        return polyPlay.getInstanceOf(clazz)
    }

    /**
     * Removes an instance of a class.
     * @param clazz The class.
     * @see JavaPolyPlay.removeInstanceOf
     */
    fun removeInstance(clazz: Class<*>) {
        polyPlay.removeInstanceOf(clazz)
    }
}