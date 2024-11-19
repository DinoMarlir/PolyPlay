package com.github.dinomarlir.polyplay.core.instance;

import java.util.Optional;

/**
 * Interface for a class provider.
 * used to get and set instances of classes.
 */
public interface IClassProvider {

    /**
     * Get an instance of a class.
     *
     * @param clazz class to get instance of
     * @param <T>   type of the class
     * @return instance of the class
     */
    <T> Optional<T> getInstanceOf(Class<T> clazz);

    /**
     * Set an instance of a class.
     *
     * @param clazz    class to set instance of
     * @param instance instance of the class
     * @param <T>      type of the class
     */
    <T> void setInstanceOf(Class<T> clazz, T instance);

    /**
     * Remove an instance of a class.
     *
     * @param clazz class to remove instance of
     */
    void removeInstanceOf(Class<?> clazz);
}
