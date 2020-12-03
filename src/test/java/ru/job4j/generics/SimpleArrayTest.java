package ru.job4j.generics;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterator.FlatMap;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    SimpleArray<Integer> array = new SimpleArray<>();

    @Test
    public void name() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.remove(1);
        assertThat(array.get(0), is(1));
        assertThat(array.get(1), is(3));
    }

    @Test
    public void iterator() {
        Iterator<Integer> it = List.of(1).iterator();

        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
    }
}
