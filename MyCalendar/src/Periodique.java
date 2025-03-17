import ValueObjects.*;

import java.time.LocalDateTime;

public final class Periodique implements Evenement {
    public Type type; // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"
    public Title title;
    public Proprietaire proprietaire;
    public DateDebut dateDebut;
    public DureeEvenement dureeMinutes;
    public Frequence frequenceJours; // uniquement pour PERIODIQUE

    public Periodique(Type type, Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeEvenement dureeMinutes, Frequence frequenceJours) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.frequenceJours = frequenceJours;
    }

    @Override
    public String description() {
        return "Événement périodique : " + title.getTitle() + " tous les " + frequenceJours.getFrequency() + " jours";
    }
}
