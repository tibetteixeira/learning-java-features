package io.github.tibetteixeira.java8.stream;

import java.util.List;

public class Filter {

    public static void itensPares(List<Integer> lista) {
        System.out.println("Itens pares");
        lista.stream()
                .filter(item -> item % 2 == 0)
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }

    public static void itensImpares(List<Integer> lista) {
        System.out.println("Itens ímpares");
        lista.stream()
                .filter(item -> item % 2 == 1)
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }

    public static void maiorQue(List<Integer> lista, Integer numero) {
        System.out.println("Itens maior que (" + numero + ")");
        lista.stream()
                .filter(item -> item > numero)
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }

    public static void menorQue(List<Integer> lista, Integer numero) {
        System.out.println("Itens menor que (" + numero + ")");
        lista.stream()
                .filter(item -> item < numero)
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }
}
