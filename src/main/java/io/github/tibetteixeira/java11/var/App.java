package io.github.tibetteixeira.java11.var;

import java.util.List;
import java.util.function.Function;

public class App {

    public static void main(String[] args) {
        // Utilização de var como parametro de função lambda
        Function<String, String> concat = (var s) -> s + ". ";

        List<String> strings = List.of("lista 1", "lista 2");

        strings.stream().map(concat).forEach(System.out::println);
    }
}
