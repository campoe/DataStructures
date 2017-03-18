package tests.list;

import datastructures.list.DoublyLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by Coen on 18-3-2017.
 */
public class DoublyLinkedListTest {

    private DoublyLinkedList<Object> list;
    private Object first;
    private Object second;
    private Object third;

    @Before
    public void setUp() throws Exception {
        list = new DoublyLinkedList<>();
        first = new Object();
        second = new Object();
        third = new Object();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
        first = null;
        second = null;
        third = null;
    }

    @Test
    public void add() throws Exception {
        list.add(0, first);
        list.add(0, second);
        assertEquals(list.size(), 2);
        assertEquals(first, list.get(1));
        assertEquals(second, list.get(0));
    }

    @Test
    public void removeHead() throws Exception {
        list.add(0, first);
        list.add(1, second);
        list.add(2, third);
        list.remove(0);
        assertEquals(list.get(0), second);
        assertEquals(list.size(), 2);
    }

    @Test
    public void remove() throws Exception {
        list.add(0, first);
        list.add(1, second);
        list.add(2, third);
        list.remove(1);
        assertEquals(list.get(1), third);
        assertEquals(list.size(), 2);
    }

}