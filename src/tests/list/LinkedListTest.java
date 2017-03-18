package tests.list;

import datastructures.list.LinkedList;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Coen on 18-3-2017.
 */
public class LinkedListTest {

    private LinkedList<Object> list;
    private Object first;
    private Object second;
    private Object third;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<>();
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
        list.add(1, second);
        assertEquals(list.size(), 2);
        assertEquals(first, list.get(0));
        assertEquals(second, list.get(1));
    }

    @Test
    public void removeHead() throws Exception {
        list.add(0, first);
        list.add(1, second);
        list.add(2, third);
        list.remove(first);
        assertEquals(list.get(0), second);
        assertEquals(list.size(), 2);
    }

    @Test
    public void remove() throws Exception {
        list.add(0, first);
        list.add(1, second);
        list.add(2, third);
        list.remove(second);
        assertEquals(list.get(1), third);
        assertEquals(list.size(), 2);
    }

}