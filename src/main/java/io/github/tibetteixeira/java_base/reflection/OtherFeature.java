package io.github.tibetteixeira.java_base.reflection;

import io.github.tibetteixeira.java_base.reflection.model.Pessoa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class OtherFeature {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Pessoa pessoa = new Pessoa(1L, "12345678909", "Eu", "Euzinho");

        Class<?> clazz = Class.forName("io.github.tibetteixeira.java_base.reflection.model.Pessoa");

        System.out.println("Access modifier");
        int modifier = clazz.getModifiers();
        System.out.println("Private: " + Modifier.isPrivate(modifier));
        System.out.println("Public: " + Modifier.isPublic(modifier));
        System.out.println("Protected: " + Modifier.isProtected(modifier));
        System.out.println("\n----------------\n");

        System.out.println("Class package");
        System.out.println(clazz.getPackage());
        System.out.println("\n----------------\n");

        System.out.println("Super class");
        System.out.println(clazz.getSuperclass());
        System.out.println("\n----------------\n");

        System.out.println("Interface");
        Arrays.stream(clazz.getInterfaces()).forEach(i -> System.out.println(i.getCanonicalName()));
        System.out.println("\n----------------\n");
    }

}
