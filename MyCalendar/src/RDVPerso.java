import ValueObjects.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String description() {
        return "RDV : " + title.getTitle() + " à " + dateDebut.getDd().toString();
    }
}
