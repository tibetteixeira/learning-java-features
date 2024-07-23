package io.github.tibetteixeira.java_initial_versions.reflection;

import io.github.tibetteixeira.java_initial_versions.reflection.model.Pessoa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeMethod {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Pessoa pessoa = new Pessoa(1L, "12345678909", "Eu", "Euzinho");

        Class<?> clazz = Class.forName("io.github.tibetteixeira.java_initial_versions.reflection.model.Pessoa");

        Method getCpf = clazz.getMethod("getCpf");
        Object resultGetCpf = getCpf.invoke(pessoa);
        System.out.println(resultGetCpf);


        Method setCpf = clazz.getMethod("setCpfComRetorno", String.class); // Metodo com parametro
        Object[] parameters = new Object[1];
        parameters[0] = "55566677789";
        Object resultSetCpf = setCpf.invoke(pessoa, parameters);
        System.out.println(resultSetCpf);
    }
}
