package ru.unecon.reflection;

public class ClassNames {
    private static void printNames(Class<?> clazz) {
        System.out.format("Name: %s, Simple: %s, Canonical: %s\n",
                clazz.getName(), clazz.getSimpleName(), clazz.getCanonicalName());
    }

    public static void main(String[] args) {
        printNames(String.class);
        printNames(java.util.Iterator.class);
        printNames(int.class);
        printNames(double[][].class);
        printNames(String[].class);
        printNames(System[].class);
        try {
            printNames(Class.forName("[Ljava.lang.System;"));
        } catch (ClassNotFoundException ex) {
            System.out.println("Class \"[Ljava.lang.System;\" not found");
        }
    }

}
