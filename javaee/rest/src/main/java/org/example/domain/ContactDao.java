package org.example.domain;

import java.util.Arrays;
import java.util.List;

public class ContactDao {

    private List<Contact> contacts = Arrays.asList(
            Contact.builder().firstName("Sammie").surname("Smith").email("sam.smith@music.com").build(),
            Contact.builder().firstName("Frank").surname("Muscles").email("frank@muscles.com").build(),
            Contact.builder().firstName("Eddy").surname("Valentino").email("eddy@valfam.co.uk").build(),
            Contact.builder().firstName("Bram").surname("Janssens").email("s.a.janssens@gmail.com").build()
    );

    public List<Contact> getAll() { return contacts; }
}
