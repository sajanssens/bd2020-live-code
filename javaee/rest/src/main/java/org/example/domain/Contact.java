package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;

@Data
@Builder
@XmlRootElement // to be able to send xml response with JAX-B
@NoArgsConstructor // idem
@AllArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Contact.findAll",
                query = "select distinct c from Contact c LEFT OUTER JOIN c.laptops ls"),
        @NamedQuery(
                name = "Contact.search",
                query = "select c from Contact c " +
                        "where c.surname LIKE :q " +
                        "OR c.firstName LIKE :q " +
                        "OR c.email LIKE :q"),
})
public class Contact implements AbstractEntity<String> {

    @Id
    @GeneratedValue
    private String id;  // UUID Universally unique ID
    private String firstName;
    private String surname;
    private String email;

    @JsonbTransient // for example
    private LocalDate dateOfBirth;

    @ManyToOne(cascade = PERSIST)
    private Laptop laptop;

    @OneToMany(cascade = PERSIST)
    private List<Laptop> laptops;

    // @JsonIgnoreProperties??
    // @OneToMany(mappedBy = "owner")
    // private List<Laptop> laptopsBidi;

}
