package io.github.tibetteixeira.java9.private_interface;

public class App {
    public static void main(String[] args) {
        Log log = new Log();

        log.logInfo("mensagem");
        log.logWarn("mensagem");
        log.logError("mensagem");
        log.logFatal("mensagem");
    }
}
