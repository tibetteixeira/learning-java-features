package io.github.tibetteixeira.java10.inferencia_tipo_variavel;

import java.util.List;

public class App {
    public static void main(String[] args) {
        var nome = "Meu Nome";
        var idade = 29;
        var disciplinas = List.of("Matemática", "Português", "Filosofia");

        System.out.println("nome " + nome + " [" + nome.getClass() + "]");
        System.out.println("idade " + idade);
        System.out.println("disciplinas " + disciplinas + " [" + disciplinas.getClass() + "]");

        System.out.println("\nFOR");
        for (var disciplina : disciplinas) {
            System.out.println(disciplina);
        }
    }
}
