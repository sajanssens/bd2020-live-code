package org.example;

import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@EnableAutoWeld
// welke classes moeten DI-enabled zijn in deze test?
@AddBeanClasses(GreeterService.class)
@AddBeanClasses(Greeting.class)
@AddBeanClasses(LoggerProducer.class)
class GreeterServiceTest {

    @Inject private GreeterService target;

    @Test
    void test() {
        String s = target.saySomething();
        System.out.println(s);
    }
}
