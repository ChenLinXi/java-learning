package com.jason.singleton;

/**
 * Compare to static instance
 * Load resource later in this way
 */
public class StaticFactory {

    private static StaticFactory instance = null;

    static {
        instance = new StaticFactory();
    }

    private StaticFactory() {
    }

    public static StaticFactory getInstance() {
        return instance;
    }

}
