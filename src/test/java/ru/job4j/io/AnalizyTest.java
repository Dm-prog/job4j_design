package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class AnalizyTest {
    Analizy analizy;

    @Before
    public void analizy() {
        analizy = new Analizy();
    }

    @Test
    public void unavailable() throws IOException {
        TemporaryFolder folder = new TemporaryFolder();
        File fileLog = folder.newFile("server.log");
        File fileCsv = folder.newFile("unavailable.csv");
        List<String> list = new ArrayList<>();
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(fileLog))) {
            pw.println("200 10:56:01");
            pw.println("200 10:57:01");
            pw.println("400 10:58:01");
            pw.println("200 10:59:01");
            pw.println("500 11:01:02");
            pw.println("200 11:02:02");
        } catch (IOException e) {
            e.printStackTrace();
        }
        analizy.unavailable("server.log", "unavailable.csv");

        try(BufferedReader br = new BufferedReader(new FileReader(fileCsv))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> exp = List.of("10:58:01;10:59:01;", "11:01:02;11:02:02;");
        assertThat(list, is(exp));
    }
}