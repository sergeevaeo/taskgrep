package edu.spbpu.grep;

import edu.spbpu.grep.Grep;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    List<String> lines = new ArrayList<>();

    @Test
    public void g() {
        //given
        lines.add("qwertyu  iop");
        lines.add("qweasdfghjkl");

        //when
        List<String> actual = null;
        try {
            actual = Grep.lines(false, false, false, "qwe", "inputFile");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        assertEquals(lines, actual);
    }

    @Test
    public void r() {
        //given
        lines.add("qwertyu  iop");

        //when
        List<String> actual = null;
        try {
            actual = Grep.lines(true, false, false, "[iop]", "inputFile");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        assertEquals(lines, actual);
    }

    @Test
    public void v() {
        //given
        lines.add("qweasdfghjkl");

        //when
        List<String> actual = null;
        try {
            actual = Grep.lines(true, true, false, "[iop]", "inputFile");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        assertEquals(lines, actual);
    }

    @Test
    public void i() {
        //given
        lines.add("qwertyu  iop");

        //when
        List<String> actual = null;
        try {
            actual = Grep.lines(false, false, true, "Iop", "inputFile");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        assertEquals(lines, actual);
    }
}

