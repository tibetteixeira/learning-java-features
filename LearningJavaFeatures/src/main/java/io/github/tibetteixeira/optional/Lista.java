package io.github.tibetteixeira.optional;

import java.util.List;

public class Lista {

    public static void imprimirPrimeiroItem(List<Integer> lista) {
        System.out.println("Imprimir primeiro item");
        lista.stream().findFirst().ifPresent(System.out::println);
        System.out.println("");
    }

    public static void imprimirPrimeiroItemOuNumeroPadrao(List<Integer> lista) {
        System.out.println("Imprimir primeiro item ou numero padrão");
        Integer numero = lista.stream().findFirst().orElse(10);
        System.out.println(numero);
        System.out.println("");
    }

    public static void imprimirPrimeiroItemOuNumeroPadraoComLambda(List<Integer> lista) {
        System.out.println("Imprimir primeiro item ou numero padrão com lambda");
        Integer numero = lista.stream().findFirst().orElseGet(() -> 10);
        System.out.println(numero);
        System.out.println("");
    }

    public static void imprimirPrimeiroItemComExcecao(List<Integer> lista) {
        System.out.println("Imprimir primeiro item com exceção");
        Integer numero = lista.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("Valor fornecido não é um número"));
        System.out.println(numero);
        System.out.println("");
    }
}
