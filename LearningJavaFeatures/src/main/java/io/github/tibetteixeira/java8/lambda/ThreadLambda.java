package io.github.tibetteixeira.java8.lambda;

public class ThreadLambda {

    public static void threadExplicita() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                esperar(5);
                System.out.println("Thread explícita");
            }
        }).run();
    }

    // O Uso de lambda só é possível pois a classe Runnable possui apenas um metodo abstrato
    // Para garantir que ela sempre possua apenas um método abstrato é utilizada a anotação @FunctionalInterface
    // Ela garante o padão SAM - Single abstract method
    public static void threadLambda() {
        new Thread(() -> {
            esperar(2);
            System.out.println("Thread usando lambda");
        }).run();
    }

    private static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
        }
    }
}
