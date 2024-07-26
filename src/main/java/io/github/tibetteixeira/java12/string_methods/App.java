package io.github.tibetteixeira.java12.string_methods;

public class App {

    public static void main(String[] args) {
        indent();
        transform();
    }

    private static void indent() {
        String str = "conteúdo";
        String anotherStr = "   outro conteúdo  conteúdo";
        System.out.println("String - indent");
        System.out.println(str.indent(4));
        System.out.println(str.indent(-1));
        System.out.println(str.indent(-10));
        System.out.println(str.indent(8));
        System.out.println(anotherStr.indent(13));
        System.out.println(anotherStr.indent(-3));
        System.out.println(anotherStr.indent(0));
        System.out.println("-----------\n");
    }

    private static void transform() {
        String str = "conteúdo";
        System.out.println("String - transform");
        String newString = str.transform(String::toUpperCase)
                .transform(s -> new StringBuilder(s).reverse().toString());
        System.out.println(newString);
    }
}
