package org.example.h12;

@Bram
public class AnnotationsDemo {

    @Bram
    public void someMethod() {

    }

    @Bram("Janssens")
    public void someMethod2() {

    }

    @Bram(value="Janssens", age = 41)
    public void someMethod3() {

    }

}
