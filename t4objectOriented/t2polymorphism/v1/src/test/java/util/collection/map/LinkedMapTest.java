package util.collection.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedMapTest {

    @Test
    void testPutElement() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
        map.put("Key3", "Value3");
        assertEquals("Value3", map.get("Key3"));
        assertEquals("Value2", map.get("Key2"));
        assertEquals("Value1", map.get("Key1"));
        assertEquals(null, map.get("Key0"));
    }

    @Test
    void testRemoveElement() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Key1", "Value1");
        map.put("Key2", "Value2");
        map.put("Key3", "Value3");
        map.remove("Key1");
        assertNull(map.get("Key1"));
        assertEquals(null, map.get("Key2"));
        assertEquals(null, map.get("Key3"));
        map.remove("Key3");
        assertNull(map.get("Key1"));
        assertEquals(null, map.get("Key2"));
        assertNull(map.get("Key3"));
    }

}
