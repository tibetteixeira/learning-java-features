package io.github.tibetteixeira.java8.functional_interface;

import java.util.Random;
import java.util.stream.Stream;

public class Supplier {

    // Supplier é uma interface funcional que não recebe argumentos e retorna um resultado
    // Exemplo: Supplier<LocalDate> supplierLocalDate = () -> LocalDate.now();

    public static void gerarNumeroAleatorio() {
        System.out.println("Gerando numero aleatorio");
        Stream.generate(() -> new Random().nextInt()) // () -> new Random().nextInt() é o Supplier
                .limit(1)
                .forEach(System.out::println);
    }

    public static void gerarNumeroAleatorioComSupplierExplicito() {
        System.out.println("Gerando numero aleatorio com Supplier explicito");
        Stream.generate(geradorNumeroAleatorio()) // Utilização do Supplier explicito
                .limit(1)
                .forEach(System.out::println);

        System.out.println("Numero aleatorio " + geradorNumeroAleatorio().get()); // executando a função do Supplier
    }

    private static java.util.function.Supplier<Integer> geradorNumeroAleatorio() {
        java.util.function.Supplier<Integer> supplier = () -> new Random().nextInt();
        return supplier;
    }
}
