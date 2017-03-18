package tests.stack;

import datastructures.stack.Stack;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Coen on 18-3-2017.
 */
public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
    }

    @After
    public void tearDown() throws Exception {
        stack.clear();
        stack = null;
    }

    @Test
    public void clear() throws Exception {
        stack.push(1);
        assertTrue(stack.size() == 1);
        stack.clear();
        assertTrue(stack.size() == 0);
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void peek() throws Exception {
        stack.push(2);
        stack.push(1);
        int size = stack.size();
        assertTrue(stack.peek() == 1);
        assertTrue(stack.size() == size);
    }

    @Test
    public void pop() throws Exception {
        stack.push(2);
        stack.push(1);
        int size = stack.size();
        assertTrue(stack.pop() == 1);
        assertTrue(stack.size() == size - 1);
    }

    @Test
    public void push() throws Exception {
        int size = stack.size();
        assertTrue(stack.push(1) == 1);
        assertTrue(stack.size() == size + 1);
    }

    @Test
    public void search() throws Exception {
        int item = stack.push(1);
        assertTrue(stack.search(item) == 1);
        int item2 = stack.push(2);
        assertTrue(stack.search(item) == 1);
        assertTrue(stack.search(item2) == 2);
    }

    @Test
    public void size() throws Exception {
        assertTrue(stack.size() == 0);
        stack.push(1);
        assertTrue(stack.size() == 1);
    }

}