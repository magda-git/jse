package m04.s08;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import m1.s29.Simple;

public class Main {
    private static final Logger log;

    static {
        try {
            LogManager.getLogManager()
                    .readConfiguration(Main.class.getClassLoader().getResourceAsStream("m1/s30/logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            log = Logger.getLogger(Main.class.getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("main");
        log.finest("finest message");
        log.finer("finer message");
        log.fine("fine message");
        log.config("config message");
        log.info("info message");
        log.warning("warning message");
        log.severe("severe message");

        Other other = new Other();
        other.f();

        Simple simple = new Simple();
        simple.f();

        System.out.println("Some risky code");
        try {
            int x = 7 / 0;
            System.out.println("x = " + x);
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Can't divide an integer by zero", ex);
        }

    }
}