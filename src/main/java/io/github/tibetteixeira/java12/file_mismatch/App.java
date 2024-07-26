package io.github.tibetteixeira.java12.file_mismatch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class App {

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String RESOURCE_PATH = PROJECT_PATH + "/src/main/resource";

    public static void main(String[] args) throws IOException {

        File file = new File(RESOURCE_PATH + "/files.txt");
        File fileCopy = new File(RESOURCE_PATH + "/files_copy.txt");
        File anotherFile = new File(RESOURCE_PATH + "/another_file.txt");

        long result1 = Files.mismatch(file.toPath(), fileCopy.toPath());
        long result2 = Files.mismatch(file.toPath(), anotherFile.toPath());

        System.out.println("Resultado 1 " + result1); // -1 os arquivos são idênticos
        System.out.println("Resultado 2 " + result2); // >= 0 indica a posição onde eles se deiferenciam
    }
}
