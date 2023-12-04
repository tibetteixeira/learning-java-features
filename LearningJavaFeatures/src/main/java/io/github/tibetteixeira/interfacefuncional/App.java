package io.github.tibetteixeira.interfacefuncional;

public class App {
    public static void main(String[] args) {
        Supplier.gerarNumeroAleatorio();
        Supplier.gerarNumeroAleatorioComSupplierExplicito();
        Consumer.imprimirComConsumer();
        Consumer.concatenarTextoComConsumer();
        Predicate.imprimeNumeroPar();
        Function.imprimeDobroDoNumero();
    }
}
