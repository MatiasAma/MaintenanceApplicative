import ValueObjects.*;

import java.time.LocalDateTime;

public class EventFactory {
    static Periodique createPeriodique (String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, int frequenceJours) {
        return new Periodique(Type.PERIODIQUE,new Title(title),new Proprietaire(proprietaire),new DateDebut(dateDebut),new DureeEvenement(dureeMinutes),new Frequence(frequenceJours));
    }

    static RDVPerso createRDVPerso (String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        return new RDVPerso(Type.RDV_PERSONNEL,new Title(title),new Proprietaire(proprietaire),new DateDebut(dateDebut),new DureeEvenement(dureeMinutes));
    }

    static Reunion createReunion (String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                                        String lieu, String participants) {
        return new Reunion(Type.REUNION,new Title(title),new Proprietaire(proprietaire),new DateDebut(dateDebut),new DureeEvenement(dureeMinutes),new LieuEvenement(lieu), new  Participant(participants));
    }

    static Annuelle createAnnuelle (String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        return new Annuelle(Type.ANNUELLE,new Title(title),new Proprietaire(proprietaire),new DateDebut(dateDebut),new DureeEvenement(dureeMinutes));
    }

}
