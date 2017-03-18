package tests.queue;

import datastructures.queue.Queue;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Coen on 18-3-2017.
 */
public class QueueTest {

    private Queue<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue<>();
    }

    @After
    public void tearDown() throws Exception {
        queue.clear();
        queue = null;
    }

    @Test
    public void clear() throws Exception {
        queue.enqueue(1);
        assertTrue(queue.size() == 1);
        queue.clear();
        assertTrue(queue.size() == 0);
    }

    @Test
    public void dequeue() throws Exception {
        queue.enqueue(2);
        queue.enqueue(1);
        int size = queue.size();
        assertTrue(queue.dequeue() == 2);
        assertTrue(queue.size() == size - 1);
    }

    @Test
    public void enqueue() throws Exception {
        int size = queue.size();
        assertTrue(queue.enqueue(1) == 1);
        assertTrue(queue.size() == size + 1);
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void peek() throws Exception {
        queue.enqueue(2);
        queue.enqueue(1);
        int size = queue.size();
        assertTrue(queue.peek() == 2);
        assertTrue(queue.size() == size);
    }

    @Test
    public void size() throws Exception {
        assertTrue(queue.size() == 0);
        queue.enqueue(1);
        assertTrue(queue.size() == 1);
    }

}