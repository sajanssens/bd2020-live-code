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

    public Publisher() {
    }

    public Publisher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @Override public String toString() {
        return "Publisher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
