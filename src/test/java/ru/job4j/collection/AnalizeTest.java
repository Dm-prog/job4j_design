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
        Analize.User current = new Analize.User(5, null);
        List<Analize.User> prev = Arrays.asList(previos);
        List<Analize.User> cur = Arrays.asList(current);
        Analize.Info diff = analize.diff(prev, cur);
        assertThat(diff.getAdded(), is(1));
    }

    @Test
    public void whenChang() {
        Analize.User previos = new Analize.User(1, "Andrey");
        Analize.User current = new Analize.User(1, "Ivan");
        List<Analize.User> prev = Arrays.asList(previos);
        List<Analize.User> cur = Arrays.asList(current);
        Analize.Info diff = analize.diff(prev, cur);
        assertThat(diff.getChanged(), is(1));
    }

    @Test
    public void whenDelete() {
        Analize.User previos1 = new Analize.User(1, "Andrey");
        Analize.User previos2 = new Analize.User(1, "Andrey");
        Analize.User current = new Analize.User(2, "Ivan");
        List<Analize.User> prev = Arrays.asList(previos1, previos2);
        List<Analize.User> cur = Arrays.asList(current);
        Analize.Info diff = analize.diff(prev, cur);
        assertThat(diff.getDeleted(), is(2 + 2 - 1)); //previous.size() + info.added - current.size();
    }
}
