package io.github.tibetteixeira.java8.stream;

import java.util.List;

public class ForEach {

    public static void dobroDeCadaItem(List<Integer> lista) {
        System.out.println("[Filter] Dobro de cada item");
        lista.stream().forEach(item -> System.out.println(item + " -> " + item * 2));
        System.out.println("");
    }

}
