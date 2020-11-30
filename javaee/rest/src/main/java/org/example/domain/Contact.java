package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@XmlRootElement // to be able to send xml response with JAX-B
@NoArgsConstructor // idem
@AllArgsConstructor
@Entity
@NamedQuery(name = "Contact.findAll", query = "select c from Contact c")
public class Contact {

    @Id
    @GeneratedValue
    private String id;  // UUID Universally unique ID
    private String firstName;
    private String surname;
    private String email;

    @ManyToOne
    private Laptop laptop;

}
