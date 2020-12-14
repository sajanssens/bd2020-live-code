package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Data
@Builder
@XmlRootElement // to be able to send xml response with JAX-B
@NoArgsConstructor // idem
@AllArgsConstructor
@Entity
@NamedQuery(name = "Contact.findAll", query = "select c from Contact c")
public class Contact implements AbstractEntity<String> {

    @Id
    @GeneratedValue
    private String id;  // UUID Universally unique ID
    private String firstName;
    private String surname;
    private String email;

    private LocalDate dateOfBirth;

    @ManyToOne
    private Laptop laptop;

}
