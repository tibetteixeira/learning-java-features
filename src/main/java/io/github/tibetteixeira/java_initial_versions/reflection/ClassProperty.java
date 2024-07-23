package io.github.tibetteixeira.java_initial_versions.reflection;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class ClassProperty {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("io.github.tibetteixeira.java_initial_versions.reflection.model.Pessoa");
        Field[] allFields = clazz.getDeclaredFields();
        Field[] publicFields = clazz.getFields();

        System.out.println("All fields");
        Stream.of(allFields).forEach(System.out::println);

        System.out.println("Public fields");
        Stream.of(publicFields).forEach(System.out::println);
    }
}
