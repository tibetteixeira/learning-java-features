package io.github.tibetteixeira.java8.method_interface;

public interface Veiculo {

    // Não é uma boa prática utilizar interface para colocar vários métodos estáticos (utilizar como Utils)
    // Não fazem parte da API da interface, ou seja, não pode ser chamado pelas classes que a implementam
    static Double calcularVelocidade(Double distancia, Double tempo) {
        return distancia / tempo;
    }

    // Métodos Default em interfaces são para evitar que você tenha que fornecer uma implementação para um novo método em uma interface

    // Em caso de herança multipla em que ambas as interfaces contenham um método default com a mesma assinatura
    // é necessário que a classe que a implementa sobrescreva o método e defina qual default method será utilizado
    default void abastecer(Double litros) {
        System.out.println("Abastacendo...");
    }
}
