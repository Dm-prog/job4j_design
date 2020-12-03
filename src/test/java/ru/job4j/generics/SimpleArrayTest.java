package ru.job4j.generics;

import org.junit.Test;

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
        array.add(1);
        Iterator<Integer> simpleArray = array.iterator();
        assertThat(simpleArray.next(), is(1));
        assertThat(simpleArray.hasNext(), is(false));
    }
}
