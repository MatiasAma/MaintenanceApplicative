import ValueObjects.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Annuelle implements Evenement {
    public Type type; // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"
    public Title title;
    public Proprietaire proprietaire;
    public DateDebut dateDebut;
    public DureeEvenement dureeMinutes;

    public Annuelle(Type type, Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeEvenement dureeMinutes) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public List<Evenement> isInPeriode(LocalDateTime debut, LocalDateTime fin, List<Evenement> listEvent) {
        LocalDateTime temp = this.dateDebut.getDd();
        while (temp.isBefore(fin)) {
            if (!temp.isBefore(debut)) {
                listEvent.add(this);
                break;
            }
            temp = temp.plusYears(1);
        }
        return listEvent;
    }

    public boolean conflit(Evenement e2) {
        List<Evenement> listConflit = new ArrayList<>();
        LocalDateTime fin = this.dateDebut.getDd().plusMinutes(dureeMinutes.getDuree());
        listConflit = e2.isInPeriode(this.dateDebut.getDd(), fin, listConflit);
        return !listConflit.isEmpty();
    }

    @Override
    public String description() {
        return "Événement annuelle : " + title.getTitle() + " " + dateDebut.getDd().getDayOfMonth() + "/" + dateDebut.getDd().getMonth();
    }
}
