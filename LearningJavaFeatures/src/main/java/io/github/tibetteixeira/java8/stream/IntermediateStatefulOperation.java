package io.github.tibetteixeira.java8.stream;

import java.util.Comparator;
import java.util.List;

public class IntermediateStatefulOperation {

    // Todas são operações intermediárias que retém o estado do objeto que será processado
    // ou seja, requer a retenção das informações dos elementos que ela processou até agora para processar o elemento atual
    // Como essas operações retém esse estado, pode haver comportamentos não determinísticos, principalmente em processos paralelos

    public static void skip(List<Integer> lista, Integer skip) {
        System.out.println("Skip");
        lista.stream()
                .skip(skip)
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }

    public static void limit(List<Integer> lista, Integer limit) {
        System.out.println("Limit");
        lista.stream()
                .limit(limit)
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }

    public static void distinct(List<Integer> lista) {
        System.out.println("Distinct");
        lista.stream()
                .distinct() // utiliza comparação do equals e hashcode
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }

    public static void sorted(List<Integer> lista) {
        System.out.println("Sorted");
        lista.stream()
                .sorted()
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }

    public static void sortedReverse(List<Integer> lista) {
        System.out.println("Sorted reverse");
        lista.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }
}
