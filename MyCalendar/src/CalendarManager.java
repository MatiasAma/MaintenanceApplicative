import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public List<Evenement> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    public void ajouterPeriodique(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, int frequenceJours) {
        Periodique e = EventFactory.createPeriodique(title, proprietaire, dateDebut, dureeMinutes, frequenceJours);
        events.add(e);
    }

    public void ajouterRDVPerso(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        RDVPerso e = EventFactory.createRDVPerso(title, proprietaire, dateDebut, dureeMinutes);
        events.add(e);
    }

    public void ajouterReunion(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                               String lieu, String participants) {
        Reunion e = EventFactory.createReunion(title, proprietaire, dateDebut, dureeMinutes,lieu,participants);
        events.add(e);
    }

    public void ajouterAnnuelle(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        Annuelle e = EventFactory.createAnnuelle(title, proprietaire, dateDebut, dureeMinutes);
        events.add(e);
    }

    public List<Evenement> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Evenement> result = new ArrayList<>();
        for (Evenement e : events) {
            result = e.isInPeriode(debut,fin,result);
        }
        return result;
    }

    public boolean conflit(Evenement e1, Evenement e2) {
        return e1.conflit(e2);
    }

    public void afficherEvenements() {
        for (Evenement e : events) {
            System.out.println(e.description());
        }
    }
}