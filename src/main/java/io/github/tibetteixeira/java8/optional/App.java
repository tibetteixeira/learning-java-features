package io.github.tibetteixeira.java8.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Numero.imprimir(Numero.converteParaInteger("1"));
        Numero.imprimir(Numero.converteParaInteger("A"));

        Numero.imprimirPadrao(Numero.converteParaInteger("1"));
        Numero.imprimirPadrao(Numero.converteParaInteger("A"));

        Numero.imprimirPadraoComLambda(Numero.converteParaInteger("1"));
        Numero.imprimirPadraoComLambda(Numero.converteParaInteger("A"));

        Numero.imprimirComExcecao(Numero.converteParaInteger("1"));
//        imprimirComExcecao(converteParaInteger("A"));

        Lista.imprimirPrimeiroItem(lista10Itens());
        Lista.imprimirPrimeiroItemOuNumeroPadrao(lista10Itens());
        Lista.imprimirPrimeiroItemOuNumeroPadrao(Collections.EMPTY_LIST);
        Lista.imprimirPrimeiroItemOuNumeroPadraoComLambda(Collections.EMPTY_LIST);
        Lista.imprimirPrimeiroItemComExcecao(Collections.EMPTY_LIST);
    }

    private static List<Integer> lista10Itens() {
        return Arrays.asList(1, 2, 3);
    }

}
