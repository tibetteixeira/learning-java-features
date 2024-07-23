package io.github.tibetteixeira.java9.inferencia_tipo;

public class App {

    public static void main(String[] args) {
        somarDouble();
        concatenarString();
    }

    // Inferencia de tipo em classe interna anonima
    private static void somarDouble() {
        SomaTudo<Double> somaDouble = new SomaTudo<>() {
            @Override
            public Double soma(Double a, Double b) {
                return a + b;
            }
        };

        System.out.println(somaDouble.soma(1.0, 2.0));
    }

    private static void concatenarString() {
        SomaTudo<String> concatenaString = new SomaTudo<>() {
            @Override
            public String soma(String a, String b) {
                return a + b;
            }
        };

        System.out.println(concatenaString.soma("Hello", "World"));
    }
}
