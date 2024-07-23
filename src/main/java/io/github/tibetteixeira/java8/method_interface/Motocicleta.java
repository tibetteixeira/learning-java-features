package io.github.tibetteixeira.java8.method_interface;

public class Motocicleta implements Veiculo {

    private String modelo;
    private String marca;

    @Override
    public void abastecer(Double litros) {
        System.out.println("Abastecendo a moto");
    }
}
