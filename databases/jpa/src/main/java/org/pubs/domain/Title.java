package org.pubs.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "titles")
public class Title {

    @Id
    @Column(name = "TITLE_ID")
    private String id;

    @Column(name = "titles")
    private String title;

    private BigDecimal advance;

    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PUB_ID")
    private Publisher publisher;

    public Title() {
    }

    public Title(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
