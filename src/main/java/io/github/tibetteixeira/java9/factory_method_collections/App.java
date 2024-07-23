package io.github.tibetteixeira.java9.factory_method_collections;

import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        System.out.println("Lista");
        List<String> lista = List.of("elemento 1", "elemento 2", "elemento 3");
        lista.forEach(System.out::println);

        System.out.println("Set");
        Set<String> set = Set.of("elemento 1", "elemento 2", "elemento 3");
        set.forEach(System.out::println);
    }
}
