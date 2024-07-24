package io.github.tibetteixeira.java11.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class App {
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String RESOURCE_PATH = PROJECT_PATH + "/src/main/resource";

    public static void main(String[] args) throws IOException {
        final String filename = "files.txt";
        final String conteudo = "Este é o conteúdo";

        Files.writeString(new File(RESOURCE_PATH.concat("/").concat(filename)).toPath(), conteudo);
        String conteudoRetornado = Files.readString(new File(RESOURCE_PATH.concat("/").concat(filename)).toPath());
        System.out.println("Conteúdo do arquivo: " + conteudoRetornado);
    }
}
