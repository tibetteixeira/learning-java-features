package io.github.tibetteixeira.java9.private_interface;

public interface LogEventos {

    default void logInfo(String mensagem) {
        log(mensagem, "INFO");
    }
    default void logWarn(String mensagem) {
        log(mensagem, "WARN");
    }

    default void logError(String mensagem) {
        log(mensagem, "ERROR");
    }

    default void logFatal(String mensagem) {
        log(mensagem, "FATAL");
    }

    private void log(String mensagem, String level) {
        System.out.println("[INICIO] ");
        System.out.println(level + ": " + mensagem);
        System.out.println("[FIM]");
    }

}
