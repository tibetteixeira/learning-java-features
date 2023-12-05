package parallelstream;

import java.util.*;
import java.util.stream.Collectors;

public class ParallelStream {

    // Utilizado para ganhar performance em algoritmos específicos
    // ParallelStream utiliza muito mais recurso que o Stream

    public static void listarComParallelStream() {
        List<Integer> inteiros = lista10Itens();

        System.out.println("Listando itens com parallel stream");
        inteiros.parallelStream().forEach(System.out::println);

        System.out.println("Listando itens de maneira ordenada");
        inteiros.parallelStream().forEachOrdered(System.out::println);
    }

    public static void findAnyComParallelStream() {
        List<Integer> inteiros = lista10Itens();

        System.out.println("Find any no parallel stream");
        inteiros.parallelStream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("Find any no stream");
        inteiros.stream()
                .findAny()
                .ifPresent(System.out::println);
    }

    public static void unorderedComParallelStream() {
        List<Integer> inteiros = lista10Itens();

        System.out.println("Unordered no parallel stream");
        inteiros.parallelStream()
                .unordered() // pode ser que ganhe muita performance, torna as threads mais independentes quando utilizado skip, limit, distinct
                .skip(1)
                .limit(5)
                .forEach(System.out::println);
    }

    public static void reduceComParallelStream() {
        List<Integer> inteiros = lista10Itens();
        List<String> hello = hello();

        System.out.println("Reduce acumulador com parallel stream");
        hello.parallelStream()
                .reduce((s1, s2) -> s1.concat(s2))
                .ifPresent(System.out::println);

        System.out.println("Reduce associativo com parallel stream");
        inteiros.parallelStream()
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);
    }

    public static void toMapComParallelStream() {
        List<Integer> inteiros = lista10Itens();

        System.out.println("toMap com parallel stream");

        // No caso de parallel stream, cada thread vai criar um HashMap e no final será necessário mergear esses maps
        // essas operações são pouco performaticas quando ha muitos elementos
        // não é thread safe
        inteiros.parallelStream()
                .collect(Collectors.toMap(n -> n, n -> n % 2 == 0))
                .forEach((k, V) -> System.out.println("Key: " + k + " Value: " + V));

        System.out.println("---");

        // Concurrent Map cria apenas um HashMap que pode ser acessado por todas as threads, tornando o código mais performatico
        // No método concurrent pode perder a ordem dos elementos
        inteiros.parallelStream()
                .collect(Collectors.toConcurrentMap(n -> n, n -> n % 2 == 0))
                .forEach((k, V) -> System.out.println("Key: " + k + " Value: " + V));
        System.out.println();
    }

    public static void groupingByComParallelStream() {
        List<Integer> inteiros = lista10Itens();

        System.out.println("groupingBy com parallel stream");

        // A diferença entre groupingBy e groupingByConcurrent é a mesma diferença encontrada no toMap
        // No método concurrent pode perder a ordem dos elementos
        inteiros.parallelStream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0))
                .forEach((k, V) -> System.out.println("Key: " + k + " Value: " + V));

        System.out.println("---");

        inteiros.parallelStream()
                .collect(Collectors.groupingByConcurrent(n -> n % 2 == 0))
                .forEach((k, V) -> System.out.println("Key: " + k + " Value: " + V));
    }

    private static List<Integer> lista10Itens() {
        return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    private static List<String> hello() {
        return new ArrayList<>(Arrays.asList("H", "e", "l", "l", "o"));
    }

    private static Map<Integer, String> map5Itens() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Numero 1");
        map.put(3, "Numero 3");
        map.put(5, "Numero 5");
        map.put(7, "Numero 7");
        map.put(9, "Numero 9");

        return map;
    }
}
