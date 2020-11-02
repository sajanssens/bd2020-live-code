package org.pubs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @Column(name = "PUB_ID")
    private String id;

    @Column(name = "PUB_NAME")
    private String name;

    private String city;

    private String state;

}
