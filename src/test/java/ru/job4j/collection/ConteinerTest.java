package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Objects;

public class ConteinerTest {
    @Test
    public void get() {
        Conteiner<Integer> conteiner = new Conteiner<>();
        int index = 0;
        int size = 5;
        //Conteiner.Node<Integer> find = this.node;
        conteiner.add(15);
        Objects.checkIndex(index, size);
        Integer result = conteiner.get(index);
        assertThat(result, is(15));
    }
}
