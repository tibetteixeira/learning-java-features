package io.github.tibetteixeira.java8.interfacefuncional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Consumer {

    // Consumer é uma interface funcional que recebe um argumento e produz um resultado, porem não retorna nada
    // Exemplo: Consumer<String> consumer = (arg) -> System.out.println(arg);

    // Ainda temos o BiConsumer, que é um Consumer que recebe dois argumentos

    public static void imprimirComConsumer() {
        System.out.println("Imprimir texto com consumer");

        Stream.of(1, 2, 3)
                .map(e -> String.valueOf(e))
                .forEach(e -> imprimir().accept(e)); // para executar o consumer, necessário chamar o accept
    }

    public static void concatenarTextoComConsumer() {
        System.out.println("Concatenar texto com consumer");
        StringBuilder texto = new StringBuilder();
        java.util.function.Consumer<String> concatena = concatenar(texto);

        Stream.of("h","e","l","l","o")
                .peek(e -> System.out.println(texto))
                .forEach(s -> concatena.accept(s));

//        System.out.println(texto);

        concatena.accept(" ");
        concatena.accept("world!");

        System.out.println(texto);
    }

    private static java.util.function.Consumer<String> imprimir() {
        java.util.function.Consumer<String> consumer = texto -> System.out.println(texto);

        return consumer;
    }

    private static java.util.function.Consumer<String> concatenar(StringBuilder builder) {
        return texto -> builder.append(texto);
    }

    private static List<String> listaHello() {
        return Arrays.asList("h","e","l","l","o");
    }
}
