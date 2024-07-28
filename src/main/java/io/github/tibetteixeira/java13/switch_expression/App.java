package io.github.tibetteixeira.java13.switch_expression;

public class App {

    public static void main(String[] args) {
        String dia = "segunda";

        // Utilização da palavra yield para retornar o valor. O break foi abolido;
        String resultado = switch (dia) {
            case "segunda":
                yield "dia útil";
            case "terça":
                yield "dia útil";
            case "quarta":
                yield "dia útil";
            case "quinta":
                yield "dia útil";
            case "sexta":
                yield "sextou";
            case "sábado":
                yield "final de semana";
            case "domingo":
                yield "final de semana";
            default:
                yield "dia inválido";
        };

        System.out.println(resultado);
    }
}
