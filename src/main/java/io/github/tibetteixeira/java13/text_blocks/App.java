package io.github.tibetteixeira.java13.text_blocks;

public class App {

    public static void main(String[] args) {
        String text = "linha 1\n" +
                "linha 2\n" +
                "linha 3";

        System.out.println(text);

        text = """
                linha 1
                linha 2
                linha 3
                """;

        System.out.println(text);
    }
}
