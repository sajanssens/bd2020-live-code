package org.pubs.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tuple {
    public final List content = new ArrayList();

    public Tuple(Object... objects) {
        content.addAll(Arrays.asList(objects));
    }

    public List getContent() {
        return content;
    }

    @Override public String toString() {
        return "Tuple{" +
                "content=" + content +
                '}';
    }
}
