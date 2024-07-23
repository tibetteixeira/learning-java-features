package io.github.tibetteixeira.java9.trycatch_atualizado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String RESOURCE_PATH = PROJECT_PATH + "/src/main/resource/";


    // Try-catch com recurso é uma funcionalidade adicionada ao Java 7, mas que houve atualização no Java 9

    public static void main(String[] args) throws IOException {
        estruturaClassica(RESOURCE_PATH + "stream.txt");
        estruturaJava7(RESOURCE_PATH + "stream.txt");
        estruturaJava9(RESOURCE_PATH + "stream.txt");
    }

    // Antes do Java 7
    public static void estruturaClassica(String path) throws IOException {
        System.out.println("estruturaClassica");
        String linha = "";
        BufferedReader br = new BufferedReader(new FileReader(path));

        try {
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (br != null)
                br.close();
        }
    }

    // Java 7
    public static void estruturaJava7(String path) throws IOException {
        System.out.println("estruturaJava7");
        String linha = "";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }

    // Java 9: É possível definir a variável testada(br) fora do escopo try
    public static void estruturaJava9(String path) throws IOException {
        System.out.println("estruturaJava9");
        String linha = "";
        BufferedReader br = new BufferedReader(new FileReader(path));

        try (br) {
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }

}
