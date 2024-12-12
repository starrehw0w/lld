package test;

import main.Level;
import main.Logger;

public class LoggerDemo {
    public static void main (String[] args){

        Logger logger = Logger.getLogger();

        logger.log(Level.INFO, "This is a info message");
        logger.log(Level.DEBUG, "This is a debug message");
        logger.log(Level.WARNING, "This is a warning message");
        logger.log(Level.ERROR, "This is an error message");
        logger.log(Level.FATAL, "This is a fatal message");
    }
}
