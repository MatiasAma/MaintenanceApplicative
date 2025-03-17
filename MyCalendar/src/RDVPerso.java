import ValueObjects.*;

import java.time.LocalDateTime;

public class RDVPerso implements Evenement{
    public Type type; // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"
    public Title title;
    public Proprietaire proprietaire;
    public DateDebut dateDebut;
    public DureeEvenement dureeMinutes;

    public RDVPerso(Type type, Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeEvenement dureeMinutes) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    @Override
    public String description() {
        return "RDV : " + title.getTitle() + " à " + dateDebut.toString();
    }
}
