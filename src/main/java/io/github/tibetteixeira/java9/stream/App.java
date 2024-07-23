package io.github.tibetteixeira.java9.stream;

import java.util.List;

public class App {

    public static void main(String[] args) {
        filter();
        takeWhile();
        dropWhile();
    }

    // Filtra os itens da lista e para imediatamente quando o predicado resulta em falso
    public static void takeWhile() {
        System.out.println("Take while");
        List<String> produtos = List.of("Televisão 50'", "Fogão", "Televisão 55'", "Mesa");
        produtos.stream()
                .takeWhile(item -> item.contains("Televisão"))
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }

    // Filtra os itens da lista e começa imediatamente quando o predicado resulta em falso
    public static void dropWhile() {
        System.out.println("Drop while");
        List<String> produtos = List.of("Televisão 50'", "Televisão 60'", "Fogão", "Televisão 55'", "Mesa");
        produtos.stream()
                .dropWhile(item -> item.contains("Televisão"))
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }

    public static void filter() {
        System.out.println("Filter");
        List<String> produtos = List.of("Televisão 50'", "Fogão", "Televisão 55'", "Mesa");
        produtos.stream()
                .filter(item -> item.contains("Televisão"))
                .forEach(item -> System.out.print(item + " - "));
        System.out.println("\n");
    }
}
