package org.example;

import org.slf4j.Logger;

import javax.inject.Inject;

public class GreeterService {

    @Inject
    private Logger log;

    private Greetable greeting; // talk to an interface, not an implementation

    @Inject // constructor injection
    public GreeterService(Greetable greeting) {
        this.greeting = greeting;
    }

    public String saySomething() {
        log.debug("saySomething");
        return greeting.greet();
    }

    public void setGreeting(Greetable greeting) {
        this.greeting = greeting;
    }
}
