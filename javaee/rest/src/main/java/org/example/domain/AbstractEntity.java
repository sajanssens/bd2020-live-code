package org.example.domain;

public interface AbstractEntity<I> {
    I getId();

    void setId(I id);
}
