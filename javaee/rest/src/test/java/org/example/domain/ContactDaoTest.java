package org.example.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContactDaoTest {

    private final ContactDao target = new ContactDao();

    @Test
    void add() {
        int before = target.getAll().size();
        target.add(new Contact());
        int after = target.getAll().size();

        assertThat(after - before).isEqualTo(1);
    }
}
