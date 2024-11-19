package com.github.dinomarlir.polyplay.core;

import com.github.dinomarlir.polyplay.core.instance.IClassProvider;
import lombok.val;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Singleton class implementing IClassProvider.
 *
 * Used to get and set instances of classes.
 * @see IClassProvider
 */
public class PolyPlay implements IClassProvider {

    /**
     * Singleton instance of PolyPlay.
     */
    private static final PolyPlay instance = new PolyPlay();
    /**
     * Map of instances.
     */
    private final Map<Class<?>, Object> instances = new HashMap<>();

    /**
     * returns the singleton instance of PolyPlay.
     * @return singleton instance of PolyPlay
     */
    public static PolyPlay getInstance() {
        return instance;
    }

    @Override
    public <T> Optional<T> getInstanceOf(Class<T> clazz) {
        val value = clazz.cast(instances.get(clazz));
        return value == null ? Optional.empty() : Optional.of(value);
    }

    @Override
    public <T> void setInstanceOf(Class<T> clazz, T instance) {
        instances.put(clazz, instance);
    }

    @Override
    public void removeInstanceOf(Class<?> clazz) {
        instances.remove(clazz);
    }

    /**
     * Empty constructor.
     * Used to create an instance of PolyPlay.
     * @see PolyPlay#getInstance()
     */
    public PolyPlay() {
        // Empty constructor
    }
}