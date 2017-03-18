package tests.list;

import datastructures.list.SelfOrganizingList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Coen on 18-3-2017.
 */
public class SelfOrganizingListTest {

    private SelfOrganizingList<Object> list;
    private Object first;
    private Object second;
    private Object third;

    @Before
    public void setUp() throws Exception {
        list = new SelfOrganizingList<>();
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
    public void insert() throws Exception {
        list.insert(first);
        list.insert(second);
        assertEquals(list.size(), 2);
        assertEquals(list.get(1), second);
        assertEquals(list.get(0), first);
    }

    @Test
    public void remove() throws Exception {
        list.insert(first);
        list.insert(second);
        list.remove(1);
        assertEquals(list.size(), 1);
        list.remove(first);
        assertEquals(list.size(), 0);
    }

    @Test
    public void contains() throws Exception {
        list.insert(first);
        list.insert(second);
        list.contains(second);
        assertEquals(list.get(0), second);
    }

}