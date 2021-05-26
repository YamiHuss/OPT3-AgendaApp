import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    @Test
    public void rejectEvent(){
        assertTrue(new Agenda ("", "20-06-2021", "11:00").rejectEvent());
        assertTrue(new Agenda ("Doctor", "", "11:00").rejectEvent());
        assertTrue(new Agenda ("Doctor", "20-06-2021", "").rejectEvent());
        assertFalse(new Agenda ("Doctor", "20-06-2021", "11:00").rejectEvent());
    }

}