import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

public class TestCalendarManager {

    private CalendarManager calendarManager;

    @BeforeEach
    public void setUp() {
        calendarManager = new CalendarManager();
    }

    @Test
    public void testAjouterReunion() {
        calendarManager.ajouterReunion("Réunion", "Alice", LocalDateTime.of(2025, 10, 1, 10, 0), 60, "Salle 1", "Bob, Charlie");
        assertEquals(1, calendarManager.events.size());
        assertEquals("Réunion : Réunion à Salle 1 avec Bob, Charlie", calendarManager.events.get(0).description());
    }

    @Test
    public void testAjouterPeriodique() {
        calendarManager.ajouterPeriodique("Cours", "Bob", LocalDateTime.of(2025, 10, 1, 9, 0), 90, 7);
        assertEquals(1, calendarManager.events.size());
        assertEquals("Événement périodique : Cours tous les 7 jours", calendarManager.events.get(0).description());
    }

    @Test
    public void testAjouterRDVPerso() {
        calendarManager.ajouterRDVPerso("Consultation", "Charlie", LocalDateTime.of(2025, 10, 1, 11, 0), 30);
        assertEquals(1, calendarManager.events.size());
        assertEquals("RDV : Consultation à 2025-10-01T11:00", calendarManager.events.get(0).description());
    }

    @Test
    public void testEventsDansPeriodeAvecPeriodique() {
        calendarManager.ajouterPeriodique("Cours", "Bob", LocalDateTime.of(2025, 10, 1, 9, 0), 90, 7);

        List<Evenement> events = calendarManager.eventsDansPeriode(LocalDateTime.of(2025, 10, 1, 8, 0), LocalDateTime.of(2025, 10, 8, 12, 0));
        assertEquals(1, events.size());
    }

    @Test
    public void testEventsDansPeriodeSansResultats() {
        calendarManager.ajouterReunion("Réunion", "Alice", LocalDateTime.of(2025, 10, 1, 10, 0), 60, "Salle 1", "Bob, Charlie");

        List<Evenement> events = calendarManager.eventsDansPeriode(LocalDateTime.of(2025, 10, 2, 8, 0), LocalDateTime.of(2025, 10, 2, 12, 0));
        assertTrue(events.isEmpty());
    }

    @Test
    public void testConflitAvecChevauchement() {
        Evenement e1 = EventFactory.createReunion("Réunion", "Alice", LocalDateTime.of(2025, 10, 1, 10, 0), 60, "Salle 1", "Bob, Charlie");
        Evenement e2 = EventFactory.createRDVPerso("Consultation", "Charlie", LocalDateTime.of(2025, 10, 1, 10, 30), 60);

        assertTrue(calendarManager.conflit(e1, e2));
    }

    @Test
    public void testPasDeConflitSansChevauchement() {
        Evenement e1 = EventFactory.createReunion("Réunion", "Alice", LocalDateTime.of(2025, 10, 1, 10, 0), 60, "Salle 1", "Bob, Charlie");
        Evenement e2 = EventFactory.createRDVPerso("Consultation", "Charlie", LocalDateTime.of(2025, 10, 1, 11, 30), 60);

        assertFalse(calendarManager.conflit(e1, e2));
    }

    @Test
    public void testConflitAvecPeriodique() {
        Evenement e1 = EventFactory.createPeriodique("Cours", "Bob", LocalDateTime.of(2025, 10, 1, 9, 0), 90, 7);
        Evenement e2 = EventFactory.createReunion("Réunion", "Alice", LocalDateTime.of(2025, 10, 1, 10, 0), 60, "Salle 1", "Bob, Charlie");

        assertFalse(calendarManager.conflit(e1, e2));
    }
}
