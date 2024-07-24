package io.github.tibetteixeira.java_base.collection;

import java.util.*;

public class CollectionMethod {

    public static void imprimirLista() {
        System.out.println("ForEach da List");
        lista10Itens().forEach(System.out::print);
        System.out.println();
    }

    public static void imprimirListaRemovendoItens() {
        System.out.println("RemoveIf da List");
        List<Integer> inteiros = lista10Itens();
        inteiros.removeIf(n -> n % 2 == 0);
        inteiros.forEach(System.out::print);
        System.out.println();
    }

    public static void imprimirListaSubstituindoItens() {
        System.out.println("ReplaceAll da List");
        List<Integer> inteiros = lista10Itens();
        inteiros.replaceAll(n -> n * 2);
        inteiros.forEach(System.out::println);
        System.out.println();
    }

    public static void imprimirMap() {
        System.out.println("ForEach do Map");
        map5Itens().forEach((k, V) -> System.out.println("Key: " + k + " Value: " + V));
        System.out.println();
    }

    public static void computeMap() {
        System.out.println("Compute do Map");
        Map<Integer, String> map = map5Itens();
        map.compute(3, (k, V) -> V + " alteração de um elemento de acordo com a chave");
        map.forEach((k, V) -> System.out.println("Key: " + k + " Value: " + V));
        System.out.println();
    }

    public static void mergeMap() {
        System.out.println("Merge do Map");
        Map<Integer, String> map = map5Itens();
        map.merge(5, "Valor a ser mergeado", (valorExistente, valorNovo) -> valorExistente.concat(" ").concat(valorNovo));
        map.forEach((k, V) -> System.out.println("Key: " + k + " Value: " + V));
        System.out.println();
    }

    public static void imprimirMapSubstituindoItens() {
        System.out.println("ReplaceAll do Map");
        Map<Integer, String> map = map5Itens();
        map.replaceAll((k, V) -> V.concat(" Alterado"));
        map.forEach((k, V) -> System.out.println("Key: " + k + " Value: " + V));
        System.out.println();
    }

    private static List<Integer> lista10Itens() {
        return new ArrayList<>(Arrays.asList(3, 8, 9, 0, 6, 1, 4, 7, 2, 5));
    }

    private static Map<Integer, String> map5Itens() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Numero 1");
        map.put(3, "Numero 3");
        map.put(5, "Numero 5");
        map.put(7, "Numero 7");
        map.put(9, "Numero 9");

        return map;
    }

}
