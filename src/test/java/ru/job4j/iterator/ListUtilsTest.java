package ru.job4j.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.addAfter(input, 1, 3);
        assertThat(Arrays.asList(1, 2, 3), is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.addBefore(input, 2, 3);
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> out = ListUtils.removeIf(input, num -> num > 2);
        assertThat(Arrays.asList(1, 2), is(out));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> out = ListUtils.replaceIf(input, num -> num > 2, 5);
        assertThat(Arrays.asList(1, 2, 5), is(out));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> in1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        List<Integer> in2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> out = ListUtils.removeAll(in1, in2);
        assertThat(Arrays.asList(5, 7), is(out));
    }
}
