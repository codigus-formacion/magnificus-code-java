package util.collection.set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedSetTest {

    @Test
    void testAddElement() {
        LinkedSet<String> set = new LinkedSet<>();
        assertTrue(set.add("Element1"));
        assertTrue(set.add("Element2"));
        assertFalse(set.add("Element1")); // Duplicate element
    }

    @Test
    void testRemoveElement() {
        LinkedSet<String> set = new LinkedSet<>();
        set.add("Element1");
        assertNotNull(set.remove("Element1"));
        assertNull(set.remove("Element1")); // Element already removed
    }

    @Test
    void testContainsElement() {
        LinkedSet<String> set = new LinkedSet<>();
        set.add("Element1");
        assertTrue(set.contains("Element1"));
        assertFalse(set.contains("Element2"));
    }

    @Test
    void testSize() {
        LinkedSet<String> set = new LinkedSet<>();
        assertEquals(0, set.size());
        set.add("Element1");
        set.add("Element2");
        assertEquals(2, set.size());
    }

    @Test
    void testClear() {
        LinkedSet<String> set = new LinkedSet<>();
        set.add("Element1");
        set.add("Element2");
        set.clear();
        assertEquals(0, set.size());
        assertFalse(set.contains("Element1"));
    }
}
