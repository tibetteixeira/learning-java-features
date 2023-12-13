package io.github.tibetteixeira.java8.stream;

import java.util.*;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Collect {

    public static void adicionarItemNaLista(List<Integer> lista) {

        // fornecedor - acumulação - combinação
        List<Integer> listaFinal = lista.stream()
                .collect(
                        () -> new ArrayList<>(), // fornecedor
                        (list, item) -> list.add(item), // acumulação
                        (lista1, lista2) -> lista1.addAll(lista2) // combinação
                );

        System.out.println("Utilizando Collect");
        System.out.println("lista original: " + lista);
        System.out.println("lista final: " + listaFinal);
        System.out.println("");
    }

    public static void adicionarItemNoSet(List<Integer> lista) {
        Set<Integer> set = lista.stream()
                .collect(Collectors.toSet());

        System.out.println("Utilizando Set");
        System.out.println("lista original: " + lista);
        System.out.println("Conjunto final: " + set);
        System.out.println("");
    }

    public static void adicionarItemNoMap(List<Integer> lista) {

        // keyMapper, valueMapper, mergeFunction
        java.util.Map<Integer, Integer> map = lista.stream()
                .collect(Collectors.toMap(Integer::intValue,
                        Function.identity(),
                        (existente, substituicao) -> existente));

        System.out.println("Utilizando Map");
        System.out.println("lista original: " + lista);
        System.out.println("Map final: " + map);
        System.out.println("");
    }

    public static void adicionarItemNoMapContandoQuantidade(List<Integer> lista) {

        // keyMapper, valueMapper, mergeFunction
        java.util.Map<Integer, Integer> map = lista.stream()
                .collect(Collectors.toMap(Integer::intValue,
                        item -> 1,
                        Math::addExact));

        System.out.println("Contando quantidade Map");
        System.out.println("lista original: " + lista);
        System.out.println("Map final: " + map);
        System.out.println("");
    }

    public static void adicionarItemEmUmaCollection(List<Integer> lista) {
        // É possível retornar os valores em qualquer Collection
        Set<Integer> set = lista.stream()
                .collect(Collectors.toCollection(HashSet::new));

        System.out.println("Utilizando toCollection");
        System.out.println("lista original: " + lista);
        System.out.println("Set final: " + set);
        System.out.println("");
    }

    public static void collectJoining(List<Integer> lista) {
        System.out.println("Join de stream de strings");
        System.out.println(lista.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(";")));
        System.out.println("");
    }

    public static void mediaLista(List<Integer> lista) {
        Double media = lista.stream()
                .collect(Collectors.averagingInt(Integer::intValue));

        System.out.println("Média da lista");
        System.out.println("lista original: " + lista);
        System.out.println("Média " + media);
        System.out.println("");
    }

    public static void somaLista(List<Integer> lista) {
        Integer soma = lista.stream()
                .collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Soma da lista");
        System.out.println("lista original: " + lista);
        System.out.println("Soma " + soma);
        System.out.println("");
    }

    public static void contarLista(List<Integer> lista) {
        Long count = lista.stream()
                .collect(Collectors.counting());

        System.out.println("Contagem da lista");
        System.out.println("lista original: " + lista);
        System.out.println("Count " + count);
        System.out.println("");
    }

    public static void sumarizarLista(List<Integer> lista) {
        IntSummaryStatistics stats = lista.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Sunarização da lista");
        System.out.println("lista original: " + lista);
        System.out.println("Sunarização " + stats);
        System.out.println("");
    }

    public static void collectGroupingBy(List<Integer> lista) {
        System.out.println("Agrupar lista");
        System.out.println(lista.stream().collect(Collectors.groupingBy(Integer::intValue)));
        System.out.println("");
    }

    public static void collectPartitionBy(List<Integer> lista) {
        System.out.println("Partição da lista");
        System.out.println(lista.stream().collect(Collectors.partitioningBy(item -> item % 2 == 0)));
        System.out.println("");
    }
}
