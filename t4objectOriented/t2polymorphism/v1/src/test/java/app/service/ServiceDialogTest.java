package app.service;

import org.junit.jupiter.api.Test;
import util.values.Date;
import util.values.Interval;
import util.values.Pair;
import util.values.Time;

import static org.junit.jupiter.api.Assertions.*;

class ServiceDialogTest {

    @Test
    void testCreate() {
        ServiceDialog dialog = new ServiceDialog("Test Dialog");
        String input = "2023-10-01;08:00-12:00"; // Example input
        Pair<Date, Interval<Time>> result = dialog.create(input);

        assertNotNull(result);
        assertEquals("2023-10-01", result.getKey().toString());
        assertEquals("08:00-12:00", result.getValue().toString());
    }

}
