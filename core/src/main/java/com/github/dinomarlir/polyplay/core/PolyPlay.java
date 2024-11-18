package com.github.dinomarlir.polyplay.core;

import com.github.dinomarlir.polyplay.core.instance.IClassProvider;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PolyPlay implements IClassProvider {

    /**
     * Singleton instance of PolyPlay.
     */
    @Getter
    private static PolyPlay instance = new PolyPlay();

    /**
     * Map of instances.
     */
    private final Map<Class<?>, Object> instances = new HashMap<>();

    @Override
    public <T> Optional<T> getInstanceOf(Class<T> clazz) {
        return Optional.of(clazz.cast(instances.get(clazz)));
    }

    @Override
    public <T> void setInstanceOf(Class<T> clazz, T instance) {
        instances.put(clazz, instance);
    }

    @Override
    public void removeInstanceOf(Class<?> clazz) {
        instances.remove(clazz);
    }
}