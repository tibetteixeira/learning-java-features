package io.github.tibetteixeira.stream;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ForEach.dobroDeCadaItem(lista10Itens());

        IntermediateStatefulOperation.skip(lista10Itens(), 5);
        IntermediateStatefulOperation.limit(lista10Itens(), 5);
        IntermediateStatefulOperation.sorted(lista10Itens());
        IntermediateStatefulOperation.sortedReverse(lista10Itens());
        IntermediateStatefulOperation.distinct(lista10ItensComRepeticoes());

        Filter.itensPares(lista10Itens());
        Filter.itensImpares(lista10Itens());
        Filter.maiorQue(lista10Itens(), 5);
        Filter.menorQue(lista10Itens(), 5);

        Map.dobroDeCadaItem(lista10Itens());

        TerminalOperation.count(lista10Itens());
        TerminalOperation.min(lista10Itens());
        TerminalOperation.max(lista10Itens());
        TerminalOperation.collectToList(lista10Itens());
        TerminalOperation.collectGroupingBy(lista10Itens());
        TerminalOperation.collectJoining(lista10Itens());

        Reduce.somaTudo(lista10Itens());
        Reduce.multiplicaTudo(lista10Itens());
        Reduce.concatenaTudo(listaHello());

        Reduce.somaTudoComValorIdentidade(lista10Itens());
        Reduce.multiplicaTudoComValorIdentidade(lista10Itens());
        Reduce.concatenaTudoComValorIdentidade(listaHello());
        Reduce.menorItem(lista10Itens());
        Reduce.menorItemComValorIdentidade(lista10Itens());

        Collect.adicionarItemNaLista(lista10Itens());
        Collect.adicionarItemNoSet(lista10ItensComRepeticoes());
        Collect.adicionarItemNoMap(lista10ItensComRepeticoes());
        Collect.adicionarItemNoMapContandoQuantidade(lista10ItensComRepeticoes());
        Collect.adicionarItemEmUmaCollection(lista10ItensComRepeticoes());
        Collect.mediaLista(lista10Itens());
        Collect.somaLista(lista10Itens());
        Collect.contarLista(lista10Itens());
        Collect.sumarizarLista(lista10Itens());
        Collect.collectGroupingBy(lista10ItensComRepeticoes());
        Collect.collectPartitionBy(lista10ItensComRepeticoes());

        Creation.criarStreamComCollection();
        Creation.criarStreamComArray();
        Creation.criarStreamComStreamOf();
        Creation.criarStreamComIntStreamRange();
        Creation.criarStreamComStreamIterate();
        Creation.criarStreamComBufferedReader();
        Creation.criarStreamComFiles();
        Creation.criarStreamComRandom();
        Creation.criarStreamComPattern();
    }

    private static List<Integer> lista10Itens() {
        return Arrays.asList(3, 8, 9, 0, 6, 1, 4, 7, 2, 5);
    }

    private static List<Integer> lista10ItensComRepeticoes() {
        return Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4);
    }

    private static List<String> listaHello() {
        return Arrays.asList("h","e","l","l","o");
    }
}
