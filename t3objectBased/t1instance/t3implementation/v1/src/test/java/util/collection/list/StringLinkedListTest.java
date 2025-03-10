package util.collection.list;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringLinkedListTest {

    @Test
    public void testConstructorNoArgs() {
        StringLinkedList list = new StringLinkedList();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testConstructorWithElements() {
        StringLinkedList list = new StringLinkedList("a", "b", "c");
        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
    }

    @Test
    public void testAdd() {
        StringLinkedList list = new StringLinkedList();
        list.add("a");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("a", list.get(0));
    }

    @Test
    public void testIsEmpty() {
        StringLinkedList list = new StringLinkedList();
        assertTrue(list.isEmpty());
        list.add("a");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        StringLinkedList list = new StringLinkedList();
        assertEquals(0, list.size());
        list.add("a");
        assertEquals(1, list.size());
        list.add("b");
        assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        StringLinkedList list = new StringLinkedList("a", "b", "c");
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
    }

    @Test
    public void testToString() {
        StringLinkedList list = new StringLinkedList("a", "b", "c");
        assertEquals("{a,b,c}", list.toString());
    }
}