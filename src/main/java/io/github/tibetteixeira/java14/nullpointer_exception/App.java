package io.github.tibetteixeira.java14.nullpointer_exception;

import lombok.AllArgsConstructor;

public class App {

    // A partir do java 14, NPE tem uma explicação mais detalhada do erro
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Eu", new Cartao(null));

        System.out.println(pessoa.nome);
        System.out.println(pessoa.cartao.numero);
        System.out.println(pessoa.cartao.numero.toUpperCase());
    }
}

@AllArgsConstructor
class Pessoa {
    String nome;
    Cartao cartao;

}

@AllArgsConstructor
class Cartao {
    String numero;
}
