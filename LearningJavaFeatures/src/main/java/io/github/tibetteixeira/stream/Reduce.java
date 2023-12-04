package io.github.tibetteixeira.stream;

import java.util.List;

public class Reduce {
    // O reduce recebe uma expr lambda que realiza alguma operacao
    // é importante utilizar uma função assossiativa, pois o resultado pode ser diferente em execução paralela

    public static void somaTudo(List<Integer> lista) {
        System.out.println("Soma tudo");
        lista.stream()
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);
        System.out.println("");
    }

    public static void somaTudoComValorIdentidade(List<Integer> lista) {
        System.out.println("Soma tudo com valor identidade");
        Integer valorReduce = lista.stream().reduce(0, Integer::sum);
        System.out.println(valorReduce);
        System.out.println("");
    }

    public static void multiplicaTudo(List<Integer> lista) {
        System.out.println("Multiplica tudo");
        lista.stream()
                .filter(item -> item > 0)
                .reduce((n1, n2) -> n1 * n2)
                .ifPresent(System.out::println);
        System.out.println("");
    }

    public static void multiplicaTudoComValorIdentidade(List<Integer> lista) {
        System.out.println("Multiplica tudo com valor identidade");
        Integer valorReduce = lista.stream()
                .filter(item -> item > 0)
                 .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(valorReduce);
        System.out.println("");
    }

    public static void concatenaTudo(List<String> lista) {
        System.out.println("Concatena tudo");
        lista.stream()
                .reduce((str1, str2) -> str1.concat(str2))
                .ifPresent(System.out::println);
        System.out.println("");
    }

    public static void concatenaTudoComValorIdentidade(List<String> lista) {
        System.out.println("Concatena tudo com valor identidade");
        String valorReduce = lista.stream().reduce("", (str1, str2) -> str1.concat(str2));
        System.out.println(valorReduce);
        System.out.println("");
    }

    public static void menorItem(List<Integer> lista) {
        System.out.println("Menor item");
        lista.stream()
                .reduce((n1, n2) -> Math.min(n1, n2))
                .ifPresent(System.out::println);
        System.out.println("");
    }

    public static void menorItemComValorIdentidade(List<Integer> lista) {
        System.out.println("Menor item com valor identidade");
        Integer valorReduce = lista.stream().reduce(Integer.MAX_VALUE, (n1, n2) -> Math.min(n1, n2));
        System.out.println(valorReduce);
        System.out.println("");
    }



}
