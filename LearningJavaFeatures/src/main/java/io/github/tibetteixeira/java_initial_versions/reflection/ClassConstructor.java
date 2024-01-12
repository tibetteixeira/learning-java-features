package io.github.tibetteixeira.java_initial_versions.reflection;

import java.lang.reflect.Constructor;
import java.util.stream.Stream;

public class ClassConstructor {

    // Existe a alternativa org.springframework.util.ReflectionUtils com muitos métodos implementados

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("io.github.tibetteixeira.java_initial_versions.reflection.model.Pessoa");
        Constructor<?>[]  constructors = clazz.getDeclaredConstructors();

        Stream.of(constructors).forEach(System.out::println);

    }
}
