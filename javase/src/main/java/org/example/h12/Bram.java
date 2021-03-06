package org.example.h12;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, METHOD, FIELD})
@Retention(RUNTIME) // tot waar moet de annotatie behouden blijven?
public @interface Bram {

    String[] value() default "";

    int age() default 0;
}
