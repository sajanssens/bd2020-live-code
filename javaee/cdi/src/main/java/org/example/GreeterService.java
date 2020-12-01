package org.example;

import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@Dependent // maak hier een CDI-bean van, dus laat CDI een instantie van deze class maken en onthouden en managen, en waar nodig injecteren.
public class GreeterService {

    @Inject
    private Logger log;

    // @Inject
    private Greetable defaultGreeting; // talk to an interface, not an implementation

    @Inject @NL
    private Greetable nlgreeting; // talk to an interface, not an implementation

    @Inject @Any
    private Instance<Greetable> allGreetings; // talk to an interface, not an implementation

    @Inject // constructor injection
    public GreeterService(Greetable greeting) {
        this.defaultGreeting = greeting;
    }

    public String saySomething() {
        log.debug("saySomething");
        return defaultGreeting.greet();
    }

    public String sayNl() {
        // log.debug("saySomething");
        return nlgreeting.greet();
    }

    public String sayAll() {
        String result = "";
        for (Greetable greeting : allGreetings) {
            result += greeting.greet() + " ";
        }

        return result;
    }

    // @Inject
    // public void setGreeting(Greetable greeting) {
    //     this.greeting = greeting;
    // }
}
