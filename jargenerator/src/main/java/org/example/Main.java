package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) { new Main().log(); }

    private void log() {
        log.trace("Trace world!");
        log.debug("Debug world!");
        log.info("Hello world!");
        log.warn("Warning world!");
        log.error("Error world!");

        /*
        The five logging levels used by SLF4J are (in order):
            trace (the least serious)
            debug
            info
            warn
            error (the most serious)

            fatal doesn't exist: http://www.slf4j.org/faq.html#fatal
        */
    }
}
