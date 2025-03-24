import ValueObjects.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<Evenement> isInPeriode (LocalDateTime debut, LocalDateTime fin, List<Evenement> listEvent){
        if (!this.dateDebut.isBefore(debut) && this.dateDebut.isAfter(fin)){
            listEvent.add(this);
        }
        return listEvent;
    }

    public boolean conflit(Evenement e2){
        List<Evenement> listConflit = new ArrayList<>();
        LocalDateTime fin = this.dateDebut.getDd().plusMinutes(dureeMinutes.getDuree());
        listConflit = e2.isInPeriode(this.dateDebut.getDd(),fin,listConflit);
        return listConflit.isEmpty();
    }

    public String description() {
        return "Réunion : " + title.getTitle() + " à " + lieu.getLieu() + " avec " + participants.getName();
    }
}
