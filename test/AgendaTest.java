import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    @Test
    public void rejectEvent(){
        assertTrue(new Agenda ("", "20-06-2021", "11:00").rejectEvent());
        assertTrue(new Agenda ("Doctor", "", "11:00").rejectEvent());
        assertTrue(new Agenda ("Doctor", "20-06-2021", "").rejectEvent());
        assertFalse(new Agenda ("Doctor", "20-06-2021", "11:00").rejectEvent());
    }

    @Test
    public void testTimeInHours() throws ParseException {

        assertEquals("Event is vandaag",new Agenda("test","26-5-2021","22:34").timeInHours());
        assertEquals("Event is vandaag",new Agenda("test","27-5-2021","21:34").timeInHours());
        assertEquals("Event is morgen",new Agenda("test","27-5-2021","22:34").timeInHours());
        assertEquals("Event is morgen",new Agenda("test","27-5-2021","23:34").timeInHours());
        assertEquals("Event is morgen",new Agenda("test","28-5-2021","21:34").timeInHours());
        assertEquals("Event is morgen",new Agenda("test","28-5-2021","22:34").timeInHours());
        assertEquals("Event is overmorgen of later",new Agenda("test","28-5-2021","23:34").timeInHours());

    }

    @Test
    public void testLicense(){

        assertEquals(5.00 ,new Agenda("", "", "").license(16, true, false, true));
        assertEquals(7.50 ,new Agenda("", "", "").license(16, false, false, false));

        assertEquals(8.50 ,new Agenda("", "", "").license(23, false, true, true));
        assertEquals(7.50 ,new Agenda("", "", "").license(23, true, false, true));

        assertEquals(12.50 ,new Agenda("", "", "").license(35, true, false, true));
        assertEquals(13.50 ,new Agenda("", "", "").license(35, false, true, true));

    }

}