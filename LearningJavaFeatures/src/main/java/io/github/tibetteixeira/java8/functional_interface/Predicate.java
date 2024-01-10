package io.github.tibetteixeira.java8.functional_interface;

import java.util.stream.Stream;

public class Predicate {

    // Predicate é uma interface funcional que recebe um argumento e retorna um booleano
    // Exemplo: Predicate<Integer> predicate = (arg) -> arg > 0;

    // Ainda temos o BiPredicate, que é um Predicate que recebe dois argumentos

    public static void imprimeNumeroPar() {
        System.out.println("Imprimir numero par");
        Stream.of(1, 2, 3, 4, 5, 6)
                .filter(i -> verificarNumeroPar().test(i))
                .forEach(System.out::println);
    }

    private static java.util.function.Predicate<Integer> verificarNumeroPar() {
        java.util.function.Predicate<Integer> predicate = num -> num % 2 == 0;
        return  predicate;
    }
}
