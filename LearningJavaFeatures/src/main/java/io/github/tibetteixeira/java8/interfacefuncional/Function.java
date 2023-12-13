package io.github.tibetteixeira.java8.interfacefuncional;

import java.util.stream.Stream;

public class Function {

    // Function é a interface funcional mais generica. Ela recebe um argumento e retorna um valor
    // Exemplo: Function<Integer, Integer> function = (arg) -> arg * 2;

    // Ainda temos a BiFunction, que é uma Function que recebe dois argumentos

    public static void imprimeDobroDoNumero() {
        System.out.println("Imprimir dobro do numero");
        Stream.of(1, 2, 3, 4, 5, 6)
                .forEach(i -> System.out.println(dobrarNumero().apply(i)));
    }

    private static java.util.function.Function<Integer, Integer> dobrarNumero() {
        java.util.function.Function<Integer, Integer> function = num -> num * 2;
        return  function;
    }

}
