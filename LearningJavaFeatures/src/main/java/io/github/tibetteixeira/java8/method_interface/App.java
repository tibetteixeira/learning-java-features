package io.github.tibetteixeira.java8.method_interface;

public class App {
    public static void main(String[] args) {
        System.out.println("Velocidade média: (veículo) " + Veiculo.calcularVelocidade(2.5, 3.0));
        System.out.println("Velocidade média: (carro) " + new Carro().calcularVelocidade(2.5, 3.0));

        new Carro().abastecer(2.0);
        new Motocicleta().abastecer(2.0);
    }
}
