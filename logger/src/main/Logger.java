package main;

public class Logger {
    private static volatile Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void log(Level logLevel, String message) {

        Message logMessage = new Message(message);

        System.out.printf(
            "[%s] %d : %s \n",
            logLevel, logMessage.getTimestamp(), logMessage.getMessage()
        );
    }

}
