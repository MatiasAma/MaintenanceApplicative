import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

public class CalendarManagerTest {

    private CalendarManager calendarManager;

    @BeforeEach
    public void before() {
        calendarManager = new CalendarManager();
    }

    @Test
    public void testAjouterEventReunion() {
        calendarManager.ajouterEvent("REUNION", "Réunion", "Alice", LocalDateTime.of(2025, 10, 1, 10, 0), 60, "Salle 1", "Bob, Charlie", 0);
        assertEquals(1, calendarManager.events.size());
        assertEquals("Réunion", calendarManager.events.get(0).title);
    }

    @Test
    public void testAjouterEventPeriodique() {
        calendarManager.ajouterEvent("PERIODIQUE", "Cours", "Bob", LocalDateTime.of(2025, 10, 1, 9, 0), 90, "Salle 2", "Alice, Charlie", 7);
        assertEquals(1, calendarManager.events.size());
        assertEquals("Cours", calendarManager.events.get(0).title);
    }

    @Test
    public void testAjouterEventRDV() {
        calendarManager.ajouterEvent("RDV", "Consultation", "Charlie", LocalDateTime.of(2025, 10, 1, 11, 0), 30, "Clinique", "Docteur", 0);
        assertEquals(1, calendarManager.events.size());
        assertEquals("Consultation", calendarManager.events.get(0).title);
    }

    @Test
    public void testEventsDansPeriodeAvecPeriodique() {
        calendarManager.ajouterEvent("PERIODIQUE", "Cours", "Bob", LocalDateTime.of(2025, 10, 1, 9, 0), 90, "Salle 2", "Alice, Charlie", 7);

        List<Event> events = calendarManager.eventsDansPeriode(LocalDateTime.of(2025, 10, 1, 8, 0), LocalDateTime.of(2025, 10, 8, 12, 0));
        assertEquals(1, events.size());
    }

    @Test
    public void testEventsDansPeriodeSansResultats() {
        calendarManager.ajouterEvent("REUNION", "Réunion", "Alice", LocalDateTime.of(2025, 10, 1, 10, 0), 60, "Salle 1", "Bob, Charlie", 0);

        List<Event> events = calendarManager.eventsDansPeriode(LocalDateTime.of(2025, 10, 2, 8, 0), LocalDateTime.of(2025, 10, 2, 12, 0));
        assertTrue(events.isEmpty());
    }

    @Test
    public void testConflitAvecChevauchement() {
        Event e1 = new Event("REUNION", "Réunion", "Alice", LocalDateTime.of(2025, 10, 1, 10, 0), 60, "Salle 1", "Bob, Charlie", 0);
        Event e2 = new Event("RDV", "Consultation", "Charlie", LocalDateTime.of(2025, 10, 1, 10, 30), 60, "Clinique", "Docteur", 0);

        assertTrue(calendarManager.conflit(e1, e2));
    }

    @Test
    public void testPasDeConflitSansChevauchement() {
        Event e1 = new Event("REUNION", "Réunion", "Alice", LocalDateTime.of(2025, 10, 1, 10, 0), 60, "Salle 1", "Bob, Charlie", 0);
        Event e2 = new Event("RDV", "Consultation", "Charlie", LocalDateTime.of(2025, 10, 1, 11, 30), 60, "Clinique", "Docteur", 0);

        assertFalse(calendarManager.conflit(e1, e2));
    }

    @Test
    public void testConflitAvecPeriodique() {
        Event e1 = new Event("PERIODIQUE", "Cours", "Bob", LocalDateTime.of(2025, 10, 1, 9, 0), 90, "Salle 2", "Alice, Charlie", 7);
        Event e2 = new Event("REUNION", "Réunion", "Alice", LocalDateTime.of(2025, 10, 1, 10, 0), 60, "Salle 1", "Bob, Charlie", 0);

        assertFalse(calendarManager.conflit(e1, e2));
    }
}
