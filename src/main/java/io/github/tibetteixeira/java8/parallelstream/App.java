package io.github.tibetteixeira.java8.parallelstream;

public class App {

    public static void main(String[] args) {
        ParallelStream.listarComParallelStream();
        ParallelStream.findAnyComParallelStream();
        ParallelStream.unorderedComParallelStream();
        ParallelStream.reduceComParallelStream();
        ParallelStream.toMapComParallelStream();
        ParallelStream.groupingByComParallelStream();
    }
}
