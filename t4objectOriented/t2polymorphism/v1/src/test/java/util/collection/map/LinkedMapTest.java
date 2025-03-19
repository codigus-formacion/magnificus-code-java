package util.collection.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedMapTest {

    @Test
    void testPutElement() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Key1", "Value1");
        assertEquals("Value1", map.get("Key1"));
    }

    @Test
    void testRemoveElement() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Key1", "Value1");
        map.remove("Key1");
        assertEquals(null, map.get("Key1"));
    }

}
