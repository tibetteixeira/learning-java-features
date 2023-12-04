package io.github.tibetteixeira.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOperation {

    public static void count(List<Integer> lista) {
        System.out.println("Count");
        System.out.println(lista.stream().count());
        System.out.println("");
    }

    public static void min(List<Integer> lista) {
        System.out.println("Minimo");
        System.out.println(lista.stream().min(Comparator.naturalOrder()).get());
        System.out.println("");
    }

    public static void max(List<Integer> lista) {
        System.out.println("Maximo");
        System.out.println(lista.stream().max(Comparator.naturalOrder()).get());
        System.out.println("");
    }

    public static void collectToList(List<Integer> lista) {
        System.out.println("Transformar em lista");
        System.out.println(lista.stream().collect(Collectors.toList()));
        System.out.println("");
    }

    public static void collectGroupingBy(List<Integer> lista) {
        System.out.println("Agrupar lista");
        System.out.println(lista.stream().collect(Collectors.groupingBy(item -> item % 2)));
        System.out.println("");
    }

    public static void collectJoining(List<Integer> lista) {
        System.out.println("Join de stream de strings");
        System.out.println(lista.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(";")));
        System.out.println("");
    }
}
