package cs3.lists;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for {@code SingleStringList}.
 * @author Mr. Nichols
 */
public class SingleStringListTest {
    private StringList sl;
    
    public SingleStringListTest() {
    }
    
    @Before
    public void setUp() {
	sl = new SingleStringList();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * A list should be empty to start with.
     */
    @Test
    public void testEmpty() {
	assertEquals(0, sl.size());
    }

    /**
     * Adding strings should increase the size of the list.
     */
    @Test
    public void testSize() {
	sl.add("Apple");
	assertEquals(1, sl.size());
	sl.add("Banana");
	assertEquals(2, sl.size());
    }

    /**
     * Can't get from empty list.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testBadGet() {
	sl.get(0);
    }

    /**
     * Can't do get with negative index.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testBadGet2() {
	sl.add("Aardvark");
	sl.get(-1);
    }

    /**
     * Can't get past end of list.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testBadGet3() {
	sl.add("aardvark");
	sl.add("zebra");
	sl.add("splat");
	sl.get(3);
    }

    /**
     * Get should return added items in the correct order.
     */
    @Test
    public void testOrder() {
	Arrays.stream(strs).forEach(sl::add);
	for(int i=0; i<3; i++) {
	    assertEquals(strs[i], sl.get(i));
	}
    }
    private static final String[] strs = new String[] { "aardvark", "zebra", "splat" };

    @Test
    public void testAddBeginning() {
	Arrays.stream(strs).forEach(sl::add);
	sl.add(0,"foobar");
	assertEquals("foobar",sl.get(0));
	assertEquals("aardvark", sl.get(1));
	assertEquals("zebra", sl.get(2));
	assertEquals("splat", sl.get(3));
    }

    @Test
    public void testAddMiddle() {
	Arrays.stream(strs).forEach(sl::add);
	sl.add(1,"meow");
	assertEquals("aardvark", sl.get(0));
	assertEquals("meow", sl.get(1));
	assertEquals("zebra", sl.get(2));
	assertEquals("splat", sl.get(3));
    }

    @Test
    public void testAddEnd() {
	Arrays.stream(strs).forEach(sl::add);
	sl.add(3,"woof");
	assertEquals("aardvark", sl.get(0));
	assertEquals("zebra", sl.get(1));
	assertEquals("splat", sl.get(2));
	assertEquals("woof", sl.get(3));
    }

    @Test
    public void testAddNextToEnd() {
	Arrays.stream(strs).forEach(sl::add);
	sl.add(2,"woof");
	assertEquals("aardvark", sl.get(0));
	assertEquals("zebra", sl.get(1));
	assertEquals("splat", sl.get(3));
	assertEquals("woof", sl.get(2));
    }


}
