package io.github.tibetteixeira.java16.classe_baseada_valor;

public class App {

    public static void main(String[] args) {
        // Classes baseadas em valor (Double, Integer, Optional) tiveram seus construtores depreciados
        // a intenção é que essas classes se tornem classes primitivas
        //
        Integer i = new Integer(5);
        System.out.println(i);

        // Nova inicialização dessas classes
        Double d = 2.1;
        System.out.println(d);

        // No futuro, poderemos substituir o equals por ==
        // isso pode acarretar bugs em comprações que hoje verificam as referências do objeto em memória
        Double d2 = 2.1;
        System.out.println(d == d2);
    }
}
