package io.github.tibetteixeira.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.github.tibetteixeira.optional.Numero.*;
import static io.github.tibetteixeira.optional.Lista.*;

public class App {
    public static void main(String[] args) {
        imprimir(converteParaInteger("1"));
        imprimir(converteParaInteger("A"));

        imprimirPadrao(converteParaInteger("1"));
        imprimirPadrao(converteParaInteger("A"));

        imprimirPadraoComLambda(converteParaInteger("1"));
        imprimirPadraoComLambda(converteParaInteger("A"));

        imprimirComExcecao(converteParaInteger("1"));
//        imprimirComExcecao(converteParaInteger("A"));

        imprimirPrimeiroItem(lista10Itens());
        imprimirPrimeiroItemOuNumeroPadrao(lista10Itens());
        imprimirPrimeiroItemOuNumeroPadrao(Collections.EMPTY_LIST);
        imprimirPrimeiroItemOuNumeroPadraoComLambda(Collections.EMPTY_LIST);
        imprimirPrimeiroItemComExcecao(Collections.EMPTY_LIST);
    }

    private static List<Integer> lista10Itens() {
        return Arrays.asList(1, 2, 3);
    }

}
