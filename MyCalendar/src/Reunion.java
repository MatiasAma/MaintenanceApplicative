import ValueObjects.*;

import java.time.LocalDateTime;

public class Reunion implements Evenement{
    public Type type; // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"
    public Title title;
    public Proprietaire proprietaire;
    public DateDebut dateDebut;
    public DureeEvenement dureeMinutes;
    public LieuEvenement lieu; // utilisé seulement pour REUNION
    public Participant participants; // séparés par virgules (pour REUNION uniquement)

    public Reunion(Type type, Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeEvenement dureeMinutes,
                   LieuEvenement lieu, Participant participants) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.lieu = lieu;
        this.participants = participants;
    }

    public String description() {
        return "Réunion : " + title.getTitle() + " à " + lieu.getLieu() + " avec " + participants.getName();
    }
}
