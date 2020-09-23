package org.example.h9;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

    private String voornaam;
    private String achternaam;
    private final int leeftijd;
    private int schoenmaat;
    private Gender gender;

}



