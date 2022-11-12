package ru.unecon.factory;

public class FactorySingleton {
    private static FactorySingleton singleton = null;

    private FactorySingleton() {}

    public static FactorySingleton getSingleton() {
        if (singleton == null) {
            singleton = new FactorySingleton();
        }
        return singleton;
    }
}
