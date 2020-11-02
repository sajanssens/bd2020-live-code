package org.pubs;

import org.junit.jupiter.api.Test;
import org.pubs.dao.PublisherDao;
import org.pubs.domain.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

class PubsIT {

    private final EntityManager em = Persistence.createEntityManagerFactory("pubs").createEntityManager();
    private final PublisherDao target = new PublisherDao(em);

    @Test
    void whenPublisherIsSavedAndGottenThenIsHasAnId() {
        String id = "0011";
        target.save(new Publisher(id, "ABC"));
        Publisher publisher = target.get(id);

        assertThat(publisher.getId()).isEqualTo(id);
    }
}
