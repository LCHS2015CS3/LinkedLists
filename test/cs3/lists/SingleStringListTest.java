package cs3.lists;

import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@code SingleStringList}.
 *
 * @author Mr. Nichols
 */
public class SingleStringListTest {

    private static final String[] strs = new String[]{"aardvark", "zebra", "splat"};
    private StringList sl;

    public SingleStringListTest() {
    }

    @Before
    public void setUp() {
        sl = new SingleStringList();
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
        for (int i = 0; i < 3; i++) {
            assertEquals(strs[i], sl.get(i));
        }
    }

    /**
     * Adding to beginning of the list.
     */
    @Test
    public void testAddBeginning() {
        Arrays.stream(strs).forEach(sl::add);
        sl.add(0, "foobar");
        assertEquals("foobar", sl.get(0));
        assertEquals("aardvark", sl.get(1));
        assertEquals("zebra", sl.get(2));
        assertEquals("splat", sl.get(3));
    }

    /**
     * Adding to the middle of the list.
     */
    @Test
    public void testAddMiddle() {
        Arrays.stream(strs).forEach(sl::add);
        sl.add(1, "meow");
        assertEquals("aardvark", sl.get(0));
        assertEquals("meow", sl.get(1));
        assertEquals("zebra", sl.get(2));
        assertEquals("splat", sl.get(3));
    }

    /**
     * Using add(int,String) to add to the end of the list.
     */
    @Test
    public void testAddEnd() {
        Arrays.stream(strs).forEach(sl::add);
        sl.add(3, "woof");
        assertEquals("aardvark", sl.get(0));
        assertEquals("zebra", sl.get(1));
        assertEquals("splat", sl.get(2));
        assertEquals("woof", sl.get(3));
    }

    /**
     * Adding just before the last element.
     */
    @Test
    public void testAddNextToEnd() {
        Arrays.stream(strs).forEach(sl::add);
        sl.add(2, "woof");
        assertEquals("aardvark", sl.get(0));
        assertEquals("zebra", sl.get(1));
        assertEquals("splat", sl.get(3));
        assertEquals("woof", sl.get(2));
    }

    /**
     * Attempting to remove from an empty list.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveNothing() {
        sl.remove(0);
    }

    /**
     * Test removal from the middle of the list.
     */
    @Test
    public void testRemove() {
        Arrays.stream(strs).forEach(sl::add);
        sl.remove(1);
        assertEquals(2, sl.size());
        assertEquals("aardvark", sl.get(0));
        assertEquals("splat", sl.get(1));
    }

    /**
     * Test removal of a single element from a singleton list.
     */
    @Test
    public void testRemove2() {
        sl.add("foo");
        assertEquals(1, sl.size());
        sl.remove(0);
        assertEquals(0, sl.size());
    }

    /**
     * Test removal of the first element of a list.
     */
    @Test
    public void testRemove3() {
        Arrays.stream(strs).forEach(sl::add);
        sl.remove(0);
        assertEquals(2, sl.size());
        assertEquals("zebra", sl.get(0));
        assertEquals("splat", sl.get(1));
    }

    /**
     * Test removal of the last element of a list.
     */
    @Test
    public void testRemove4() {
        Arrays.stream(strs).forEach(sl::add);
        sl.remove(2);
        assertEquals(2, sl.size());
        assertEquals("aardvark", sl.get(0));
        assertEquals("zebra", sl.get(1));
    }

    /**
     * Test invalid removal operation.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testBadRemove() {
        Arrays.stream(strs).forEach(sl::add);
        sl.remove(3);
    }

    /**
     * Test invalid removal operation.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testBadRemove2() {
        Arrays.stream(strs).forEach(sl::add);
        sl.remove(-1);
    }

    /**
     * Test indexOf method.
     */
    @Test
    public void testIndexOf() {
        Arrays.stream(strs).forEach(sl::add);
        assertEquals(1, sl.indexOf("zebra"));
        assertEquals(0, sl.indexOf("aardvark"));
        assertEquals(2, sl.indexOf("splat"));
        assertEquals(-1, sl.indexOf("porcupine"));
    }

    /**
     * Test indexOf on empty list.
     */
    @Test
    public void testIndexOf2() {
        assertEquals(-1, "foo");
    }

    /**
     * Test indexOf on strings appearing more than once in the list.
     */
    @Test
    public void testIndexOf3() {
        sl.add("foo");
        sl.add("splat");
        sl.add("aardvark");
        sl.add("spam");
        sl.add("aardvark");
        assertEquals(2, sl.indexOf("aardvark"));
    }

    /**
     * Test contains method.
     */
    @Test
    public void testContains() {
        Arrays.stream(strs).forEach(sl::add);
        assertTrue(sl.contains("aardvark"));
        assertTrue(sl.contains("splat"));
        assertTrue(sl.contains("zebra"));
        assertFalse(sl.contains("computer"));
    }

    /**
     * Test of toArray method.
     */
    @Test
    public void testToArray() {
        Arrays.stream(strs).forEach(sl::add);
        assertArrayEquals(strs, sl.toArray());
    }

    /**
     * Test of toString method.
     */
    @Test
    public void testToString() {
        Arrays.stream(strs).forEach(sl::add);
        assertEquals("[aardvark, zebra, splat]", sl.toString());
    }

    /**
     * Null check test on add(String).
     */
    @Test(expected = NullPointerException.class)
    public void testNullCheck1() {
        sl.add(null);
    }

    /**
     * Null check test on add(int,String).
     */
    @Test(expected = NullPointerException.class)
    public void testNullCheck2() {
        sl.add(0, null);
    }

    /**
     * Null check test on indexOf.
     */
    @Test(expected = NullPointerException.class)
    public void testNullCheck3() {
        sl.add("foo");
        sl.indexOf(null);
    }

    /**
     * Null check test on contains.
     */
    @Test(expected = NullPointerException.class)
    public void testNullCheck4() {
        sl.add("foo");
        sl.contains(null);
    }

}
