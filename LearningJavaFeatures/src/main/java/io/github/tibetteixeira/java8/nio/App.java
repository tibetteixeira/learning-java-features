package io.github.tibetteixeira.java8.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class App {


    private static final String PROJECT_NAME = "/LearningJavaFeatures";
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String RESOURCE_PATH = PROJECT_PATH + "/src/main/resource";

    public static void main(String[] args) throws IOException {
        System.out.println("Resource path " + RESOURCE_PATH);
        getFilename();
        createDirectories();
        fileMethods();
        normalize();
        changeModifiedDate();
        showBasicFileAttributes();
        changeBasicFileAttributes();
        showBasicFileAttributes();
        attributesDosFileAttributes();
        attributesPosixFileAttributes();
        showFilesFromDirectory();
        showAllFilesFromDirectory();
        zipFile();
        matchPath();
    }

    private static void getFilename() {
        Path p1 = Paths.get(RESOURCE_PATH, "stream.txt");
        Path p2 = Paths.get("home", "tesky", "project", "learning-java-features", "LearningJavaFeatures", "src", "main", "resource", "stream.txt");

        System.out.println("NIO - get filename");
        System.out.println(p1.getFileName()); // equivalente a new File("path")
        System.out.println(p2.getFileName());
        System.out.println("\n--------\n");
    }

    private static void createDirectories() throws IOException {
        Path p1 = Paths.get(RESOURCE_PATH, "/newDirectory");
        Path p2 = Paths.get(RESOURCE_PATH, "/directory/subdirectory");

        Path directory;
        if (Files.notExists(p1))
            // Lança exceção caso tente criar uma estrutura do tipo /directory/subdirectory e directory não existe
            // Lança exceção caso p1 já exista
            directory = Files.createDirectory(p1);
        else
            directory = Paths.get(p1.toString());

        // Cria a estrutura do tipo /directory/subdirectory mesmo directory não existindo
        // Não lança exceção caso p2 já exista
        Path directories = Files.createDirectories(p2);

        System.out.println("NIO - Create directory");
        System.out.println("P1 " + directory);
        System.out.println("P2 " + directories);
        System.out.println("\n--------\n");
    }

    private static void fileMethods() throws IOException {
        Path p2 = Paths.get(RESOURCE_PATH, "/directory/subdirectory");
        Path directories = Files.createDirectories(p2);
        Path file = Paths.get(directories.toString(), "newFile.txt");

        Path newFile = createFile(file);
        Path copyFile = copyFile(file);

        System.out.println("NIO - Working with files");
        System.out.println("Creating new file " + newFile);
        System.out.println("Copy new file " + copyFile);
        System.out.println("\n--------\n");
    }

    private static Path createFile(Path file) throws IOException {
        Path newFile;
        if (Files.notExists(file))
            newFile = Files.createFile(file); // Cria a estrutura /directory/subdirectory caso não exista
        else
            newFile = Paths.get(file.toString());

        return newFile;
    }

    private static Path copyFile(Path file) throws IOException {
        Path copyFile;
        Path source = file;
        Path target = Paths.get(file.getParent().toString(), "file_copied.txt");

        if (Files.notExists(target))
            copyFile = Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        else
            copyFile = Paths.get(target.toString());

        return copyFile;
    }

    private static void normalize() {
        Path testPath = Paths.get(RESOURCE_PATH, "..", "..", "test");
        Path normalizeTestPath = testPath.normalize();

        System.out.println("NIO - Normalize");
        System.out.println("original test path " + testPath);
        System.out.println("normalized test path " + normalizeTestPath);
        System.out.println("\n--------\n");
    }

    private static void changeModifiedDate() throws IOException {
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        Path path = Paths.get(RESOURCE_PATH, "modified_file.txt");

        if (Files.notExists(path))
            Files.createFile(path);

        FileTime fileTimeYesterday = FileTime.from(yesterday.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(path, fileTimeYesterday);

        System.out.println("NIO - BasicFileAttributes");
        System.out.println("is writable " + Files.isWritable(path));
        System.out.println("is readable " + Files.isReadable(path));
        System.out.println("is executable " + Files.isExecutable(path));
        System.out.println("\n--------\n");
    }

    private static void showBasicFileAttributes() throws IOException {
        Path path = Paths.get(RESOURCE_PATH, "modified_file.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();

        System.out.println("NIO - BasicFileAttributes");
        System.out.println("BasicFileAttributes type " + basicFileAttributes.getClass());
        System.out.println("Creation time " + creationTime);
        System.out.println("Last Access time " + lastAccessTime);
        System.out.println("Last Modified time " + lastModifiedTime);
        System.out.println("\n--------\n");
    }

    private static void changeBasicFileAttributes() throws IOException {
        Path path = Paths.get(RESOURCE_PATH, "modified_file.txt");
        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

        FileTime creationTime = FileTime.from(LocalDateTime.now().minusDays(360).toInstant(ZoneOffset.UTC)); // na implementação do método, o create date só é alterado através do lastModifiedTime
        FileTime lastAccessTime = FileTime.from(LocalDateTime.now().minusDays(10).toInstant(ZoneOffset.UTC));
        FileTime lastModifiedTime = FileTime.from(LocalDateTime.now().minusDays(30).toInstant(ZoneOffset.UTC));

        basicFileAttributeView.setTimes(lastModifiedTime, lastAccessTime, creationTime);

        System.out.println("NIO - BasicFileAttributes (modifying...)");
        System.out.println("\n--------\n");
    }


    private static void attributesDosFileAttributes() throws IOException {
        // Métodos que funcionam em ambientes Dos
        Path path = Paths.get(RESOURCE_PATH, "dos_file.txt");

        if (Files.notExists(path))
            Files.createFile(path);

        Files.setAttribute(path, "dos:hidden", true);
        Files.setAttribute(path, "dos:readonly", true);

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);

        System.out.println("NIO - DosFileAttributes");
        System.out.println("-- Before using DosFileAttributeView --");
        System.out.println("is hidden " + dosFileAttributes.isHidden());
        System.out.println("is read only " + dosFileAttributes.isReadOnly());

        DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);

        dosFileAttributeView.setHidden(false);
        dosFileAttributeView.setReadOnly(false);

        System.out.println("-- After using DosFileAttributeView --");
        System.out.println("is hidden " + dosFileAttributeView.readAttributes().isHidden());
        System.out.println("is read only " + dosFileAttributeView.readAttributes().isReadOnly());
        System.out.println("\n--------\n");
    }

    private static void attributesPosixFileAttributes() throws IOException {
        // Métodos que funcionam em ambientes Unix
        Path path = Paths.get(RESOURCE_PATH, "posix_file.txt");

        if (Files.notExists(path))
            Files.createFile(path);

        PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);

        System.out.println("NIO - PosixFileAttributes");
        System.out.println("-- Before using PosixFileAttributeView --");
        System.out.println("permissions " + posixFileAttributes.permissions());

        PosixFileAttributeView posixFileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        posixFileAttributeView.setPermissions(PosixFilePermissions.fromString("rwxr--rw-"));

        System.out.println("-- After using PosixFileAttributeView --");
        System.out.println("permissions " + posixFileAttributeView.readAttributes().permissions());
        System.out.println("\n--------\n");
    }

    private static void showFilesFromDirectory() {
        Path resourcePath = Paths.get(RESOURCE_PATH);

        System.out.println("NIO - DirectoryStream");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(resourcePath)) {
            stream.forEach(path -> System.out.println(path.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n--------\n");
    }

    private static void showAllFilesFromDirectory() throws IOException {
        System.out.println("NIO - SimpleFileVisitor - show all files from directory");
        Path resourcePath = Paths.get(RESOURCE_PATH);
        Files.walkFileTree(resourcePath, new ListAllFiles());
        System.out.println("\n--------\n");
    }

    private static void zipFile() {
        Path zipFile = Paths.get(RESOURCE_PATH, "file.zip");
        Path fileToZip = Paths.get(RESOURCE_PATH, "directory/subdirectory");

        System.out.println("NIO - ZipOutputStream");
        zip(zipFile, fileToZip);
        System.out.println("\n--------\n");
    }

    private static void zip(Path zipFile, Path fileToZip) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
             DirectoryStream<Path> directoryStream = Files.newDirectoryStream(fileToZip)) {
            for (Path file : directoryStream) {
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zipOutputStream.putNextEntry(zipEntry); // zipa apenas o arquivo vazio
                Files.copy(file, zipOutputStream); // copia o conteudo do arquivo para o zip
                zipOutputStream.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void matchPath() {
        Path bkp = Paths.get(RESOURCE_PATH, "file.bkp");
        Path txt = Paths.get(RESOURCE_PATH, "file.txt");
        Path java = Paths.get(RESOURCE_PATH, "file.java");

        System.out.println("NIO - PathMatcher");
        matches(bkp, "glob:*.bkp"); // Glob é parecido com Regex, mas tem sua sintaxe própria
        matches(bkp, "glob:**/*.bkp");
        matches(bkp, "glob:**/*.{bkp,java}");
        matches(txt, "glob:**/*.{bkp,java,tx}");
        matches(java, "glob:**/*.{bkp,java}");
        matches(java, "glob:**/*.???");
        matches(java, "glob:**/*.????");
        matches(java, "glob:**/file.????");
        matches(java, "glob:**/file.???");
        matches(txt, "glob:**/file.???");
        matches(txt, "glob:**/file.????");
        System.out.println("\n--------\n");
    }

    private static void matches(Path path, String glob) {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + pathMatcher.matches(path));
    }

}

class ListAllFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        System.out.println(path.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        System.out.println("Pre visit " + path.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException {
        System.out.println("Visit file " + path.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
        System.out.println("Post visit " + path.getFileName());
        return FileVisitResult.CONTINUE;
    }
}