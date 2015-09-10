package cs3.lists;

import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Unit tests for {@code StringQueue}.
 * @author Mr. Nichols
 */
@Ignore   // remove this line to enable tests
public class StringQueueTest {
    
    private StringQueue q;

    public StringQueueTest() {
    }
    
    @Before
    public void setUp() {
	q = new DoubleStringList();
	Stream.of("apple", "banana", "chocolate").forEach(q::enqueue);
    }

    /**
     * Test of enqueue method, of class StringQueue.
     */
    @Test
    public void testEnqueue() {
	assertEquals(3, q.size());
    }
    
    /**
     * Test of dequeue method, of class StringQueue.
     */
    @Test
    public void testDequeue() {
	assertEquals(3, q.size());
	assertEquals("apple", q.dequeue());
	assertEquals(2, q.size());
	assertEquals("banana", q.dequeue());
	assertEquals(1, q.size());
	assertEquals("chocolate", q.dequeue());
	assertEquals(0, q.size());
    }
    
    /**
     * Test of head method, of class StringQueue.
     */
    @Test
    public void testHead() {
	assertEquals(3, q.size());
	assertEquals("apple", q.head());
	assertEquals(3, q.size());
    }
    
    /**
     * Test of tail method, of class StringQueue.
     */
    @Test
    public void testTail() {
	assertEquals(3, q.size());
	assertEquals("chocolate", q.tail());
	assertEquals(3, q.size());
    }
    
    @Test(expected = NoTengoNadaException.class)
    public void testBadDequeue() {
	StringQueue qq = new DoubleStringList();
	qq.dequeue();
    }

    @Test(expected = NoTengoNadaException.class)
    public void testBadHead() {
	StringQueue qq = new DoubleStringList();
	qq.head();
    }

    @Test(expected = NoTengoNadaException.class)
    public void testBadTail() {
	StringQueue qq = new DoubleStringList();
	qq.tail();
    }

    @Test
    public void testEnDequeue() {
	assertEquals(3, q.size());
	assertEquals("apple", q.dequeue());
	assertEquals(2, q.size());
	q.enqueue("hummus");
	assertEquals(3, q.size());
	q.enqueue("ice cream");
	assertEquals(4, q.size());
	assertEquals("banana", q.dequeue());
	assertEquals("chocolate", q.dequeue());
	assertEquals("hummus", q.dequeue());
	assertEquals("ice cream", q.dequeue());
	assertEquals(0, q.size());
    }

}