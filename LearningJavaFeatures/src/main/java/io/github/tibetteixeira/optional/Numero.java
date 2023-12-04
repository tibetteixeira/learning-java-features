package io.github.tibetteixeira.optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class Numero {
    // É possível utilizar Optional de tipos primitivos
    // Como OptionalInt, OptionalLong, OptionalDouble
    // Importante ressaltar que é bom evitar receber Optional como param de método, pois pode tornar a manutenção do param complicada

    public static Optional<Integer> converteParaInteger(String valor) {
        try {
            Integer numero = Integer.valueOf(valor);

            // diferente de Optional.of, o Optional.ofNullable pode receber um valor nulo
            // nesse caso, seu retorno será um Optional.empty
            return java.util.Optional.ofNullable(numero);
        } catch (Exception e) {
            return java.util.Optional.empty();
        }
    }

    public static void imprimir(Optional<Integer> numeroOpt) {
        System.out.println("Imprimir");
        numeroOpt.ifPresent(System.out::println);
        System.out.println("");
    }

    public static void imprimirPadrao(Optional<Integer> numeroOpt) {
        System.out.println("Imprimir padrão");
        Integer numero = numeroOpt.orElse(10);
        System.out.println(numero);
        System.out.println("");
    }

    public static void imprimirPadraoComLambda(Optional<Integer> numeroOpt) {
        System.out.println("Imprimir padrão com lambda");

        // orElseGet recebe uma expr lambda
        Integer numero = numeroOpt.orElseGet(() -> 10);
        System.out.println(numero);
        System.out.println("");
    }

    public static void imprimirComExcecao(Optional<Integer> numeroOpt) {
        System.out.println("Imprimir com exceção");

        Integer numero = numeroOpt.orElseThrow(() -> new IllegalArgumentException("Valor fornecido não é um número"));
        System.out.println(numero);
        System.out.println("");
    }




}
