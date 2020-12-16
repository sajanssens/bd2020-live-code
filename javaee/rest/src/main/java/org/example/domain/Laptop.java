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
// @JsonIgnoreProperties({"owner"})
@NamedQuery(name = "Laptop.findAll", query = "select c from Laptop c")
public class Laptop implements AbstractEntity<String> {

    @Id
    private String id; // UUID Universally unique ID
    private String brand;
    private double price;

    // JEE7 JSON-P Processing API
    // JEE8 JSON-B Binding API .. @JsonbTransient/@JsonbIgnore

    // @ManyToOne
    // @JoinColumn(name = "ownerId")
    // private Contact owner;

}
