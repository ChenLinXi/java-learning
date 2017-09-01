package com.jason.singleton;

/**
 * StaticInstance
 * 1. create new final instance
 * 2. get instance
 */
public class StaticInstance {

    // default constructor
    private StaticInstance() {
    }

    // get singleton instance
    // final: can't access by reflect
    public static final StaticInstance getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // new singleton instance
    private static class SingletonHolder {
        // final: can't access by reflect
        private static final StaticInstance INSTANCE = new StaticInstance();
    }
}
