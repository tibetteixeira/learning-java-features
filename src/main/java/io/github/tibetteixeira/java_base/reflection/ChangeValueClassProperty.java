package io.github.tibetteixeira.java_base.reflection;

import io.github.tibetteixeira.java_base.reflection.model.Pessoa;

import java.lang.reflect.Field;

public class ChangeValueClassProperty {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Pessoa pessoa = new Pessoa(1L, "12345678909", "Eu", "Euzinho");

        Class<?> clazz = Class.forName("io.github.tibetteixeira.java_base.reflection.model.Pessoa");
        Field cpf = clazz.getDeclaredField("cpf");
        cpf.setAccessible(true); // Utilizado para propriedades privadas
        cpf.set(pessoa, "55566677789");

        System.out.println(pessoa.getCpf());
    }
}
