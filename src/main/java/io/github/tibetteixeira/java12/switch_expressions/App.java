package io.github.tibetteixeira.java12.switch_expressions;

public class App {

    public static void main(String[] args) {
        String dia = "domingo";

        String resultado = switch (dia) {
            case "segunda", "terça", "quarta", "quinta" -> "dia útil";
            case "sexta" -> "sextou";
            case "sábado", "domingo" -> "final de semana";
            default -> "dia inválido";
        };

        System.out.println(resultado);
    }


}
