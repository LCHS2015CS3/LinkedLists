package cs3.lists;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests the implementation of {@code StringStack} in {@code SingleStringList}.
 * @author Mr. Nichols
 */
@Ignore   // remove this line to enable tests
public class StackTest {
    
    StringStack stack;

    public StackTest() {
    }

    @Before
    public void setup() {
	stack = new SingleStringList();
	stack.push("apple");
	stack.push("banana");
	stack.push("chocolate");
    }

    @Test
    public void testPush() {
	assertEquals(3, stack.size());
    }
    
    @Test
    public void testPop() {
	assertEquals(3, stack.size());
	assertEquals("chocolate", stack.pop());
	assertEquals(2, stack.size());
	assertEquals("banana", stack.pop());
	assertEquals(1, stack.size());
	assertEquals("apple", stack.pop());
	assertEquals(0, stack.size());
    }

    @Test
    public void testPeek() {
	assertEquals(3, stack.size());
	assertEquals("chocolate", stack.peek());
	assertEquals(3, stack.size());
    }

    @Test(expected = NoTengoNadaException.class)
    public void testEmpty() {
	StringStack foo = new SingleStringList();
	foo.pop();
    }

    @Test(expected = NoTengoNadaException.class)
    public void testEmpty2() {
	StringStack foo = new SingleStringList();
	foo.peek();
    }

    @Test
    public void testPushAndPop() {
	stack.pop();
	stack.push("coconut");
	assertEquals(3, stack.size());
	stack.push("date");
	assertEquals(4, stack.size());
	assertEquals("date", stack.pop());
	assertEquals("coconut", stack.pop());
	assertEquals("banana", stack.pop());
	assertEquals("apple", stack.pop());
	assertEquals(0, stack.size());
    }

    
}
