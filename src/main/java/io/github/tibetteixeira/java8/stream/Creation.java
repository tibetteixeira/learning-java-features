package io.github.tibetteixeira.java8.stream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Creation {

    private static final String PROJ_PATH = "/home/tesky/project/learning-java-features/LearningJavaFeatures/src/main/resource";

    public static void criarStreamComCollection() {
        System.out.println("Criando stream com Collection");

        List<Integer> inteiros = Arrays.asList(1, 2, 3, 4, 5);
        inteiros.stream().forEach(System.out::println);
    }

    public static void criarStreamComArray() {
        System.out.println("Criando stream com Array");

        Integer[] inteiros = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(inteiros).forEach(System.out::println);
    }

    public static void criarStreamComStreamOf() {
        System.out.println("Criando stream com Stream.of");

        Stream.of("A", 2, 5.3).forEach(System.out::println);
    }

    public static void criarStreamComIntStreamRange() {
        System.out.println("Criando stream com IntStream.range");

        IntStream.range(0, 5).forEach(System.out::println);

        System.out.println("Criando stream com IntStream.rangeClosed");
        IntStream.rangeClosed(0, 5).forEach(System.out::println);
    }

    public static void criarStreamComStreamIterate() {
        System.out.println("Criando stream com Stream.iterate");

        Stream.iterate(1, i -> i * 2)
                .limit(5)
                .forEach(System.out::println);
    }

    public static void criarStreamComBufferedReader() {
        // Ler linhas de um arquivo
        System.out.println("Criando stream com BufferedReader");

        try {
            File file = new File(PROJ_PATH + "/stream.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.lines().forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void criarStreamComFiles() {
        System.out.println("Criando stream com Files");

        Path path = Paths.get("");
        try {
            Files.list(path).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void criarStreamComRandom() {
        System.out.println("Criando stream com Random");

        new Random().ints()
                .limit(5)
                .forEach(System.out::println);
    }

    public static void criarStreamComPattern() {
        System.out.println("Criando stream com Pattern");

        Pattern pattern = Pattern.compile(" ");
        pattern.splitAsStream("Criando stream com Pattern").forEach(System.out::println);
    }


}
