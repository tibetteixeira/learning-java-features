package io.github.tibetteixeira.java8.stream;

import java.util.List;

public class Map {
    public static void dobroDeCadaItem(List<Integer> lista) {
        System.out.println("[MAP] Dobro de cada item");
        lista.stream()
                .map(item -> item * 2)
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }

}
