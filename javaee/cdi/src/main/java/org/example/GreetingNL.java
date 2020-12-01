package org.example;

import javax.enterprise.context.Dependent;

@Dependent // maak hier een CDI-bean van, dus laat CDI een instantie van deze class maken en onthouden en managen, en waar nodig injecteren.
@NL
public class GreetingNL implements Greetable {

    public String greet() {
        return "Hallo wereld!";
    }

}
