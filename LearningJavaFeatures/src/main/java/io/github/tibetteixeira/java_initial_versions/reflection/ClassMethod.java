package io.github.tibetteixeira.java_initial_versions.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassMethod {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("io.github.tibetteixeira.java_initial_versions.reflection.model.Pessoa");
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("Methods");
        Arrays.stream(methods).forEach(method -> {
            System.out.println(method);

            System.out.println("Parameters");
            Class<?>[] parameters = method.getParameterTypes();

            Arrays.stream(parameters).forEach(System.out::println);
            System.out.println();
        });
    }
}
