package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AnalizeTest {

    Analize analize;

    @Before
    public void before() {
        analize = new Analize();
    }

    @Test
    public void whenAdd() {
        Analize.User previos = new Analize.User(1, "Andrey");
        Analize.User current = new Analize.User(2, "Ivan");
        List<Analize.User> prev = Arrays.asList(previos);
        List<Analize.User> cur = Arrays.asList(current);
        Analize.Info diff = analize.diff(prev, cur);
        //assertThat(diff, is());
    }

    @Test
    public void whenChang() {
        Analize.User previos = new Analize.User(1, "Andrey");
        Analize.User current = new Analize.User(2, "Ivan");
        List<Analize.User> prev = Arrays.asList(previos);
        List<Analize.User> cur = Arrays.asList(current);
        Analize.Info diff = analize.diff(prev, cur);
        //assertThat(diff, is());
    }

    @Test
    public void whenDelete() {
        Analize.User previos = new Analize.User(1, "Andrey");
        Analize.User current = new Analize.User(2, "Ivan");
        List<Analize.User> prev = Arrays.asList(previos);
        List<Analize.User> cur = Arrays.asList(current);
        Analize.Info diff = analize.diff(prev, cur);
        //assertThat(diff, is());
    }
}
