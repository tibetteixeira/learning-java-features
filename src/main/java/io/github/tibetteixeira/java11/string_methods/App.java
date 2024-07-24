package io.github.tibetteixeira.java11.string_methods;

public class App {

    public static void main(String[] args) {
        isBlank();
        lines();
        repeat();
    }

    private static void isBlank() {
        String str1 = "";
        String str2 = "       ";
        String str3 = "Com conteúdo";
        String str4 = null; // causa NPE

        System.out.println("String - isBlank");
        System.out.println("str1 is blank? " + str1.isBlank());
        System.out.println("str2 is blank? " + str2.isBlank());
        System.out.println("str3 is blank? " + str3.isBlank());
//        System.out.println("str4 is blank? " + str4.isBlank());
        System.out.println("-----------");
    }

    private static void lines() {
        String str = "conteúdo1\nconteúdo2\nconteúdo3";
        System.out.println("String - lines");
        str.lines().forEach(System.out::println);
        System.out.println("-----------\n");
    }


    private static void repeat() {
        String str = "conteúdo";
        System.out.println("String - repeat");
        System.out.println(str.repeat(3));
        System.out.println("-----------\n");
    }
}
