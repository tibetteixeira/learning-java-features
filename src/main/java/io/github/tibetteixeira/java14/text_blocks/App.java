package io.github.tibetteixeira.java14.text_blocks;

public class App {

    public static void main(String[] args) {

        // Inclusão dos caracteres
        // '\' ignora quebra de linha e é utilizada apenas no final da linha
        // '\s' para indicar espaço
        String text = """
                linha 1 \
                linha 2\s|
                linha 3\s
                """;

        System.out.println(text);
    }
}
