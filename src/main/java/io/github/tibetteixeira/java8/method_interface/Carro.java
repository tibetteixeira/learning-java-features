package io.github.tibetteixeira.java8.method_interface;

public class Carro implements Veiculo {

    private String modelo;
    private String marca;

    // Essa é a unica forma de utilizar Veiculo.calcularVelocidade sendo chamada pela classe que herda
    public Double calcularVelocidade(Double distancia, Double tempo) {
        return Veiculo.calcularVelocidade(distancia, tempo);
    }

}
