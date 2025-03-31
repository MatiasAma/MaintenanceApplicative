import java.time.LocalDateTime;
import java.util.Scanner;

public class AjouterReunion implements MethodeMain {
    Scanner scanner;

    public AjouterReunion(Scanner sc) {
        this.scanner = sc;
    }

    @Override
    public void executer() {
        System.out.print("titre: ");
        String titre = scanner.nextLine();
        System.out.print("Date de début (j/m/aaaa) :\n");
        System.out.print("Jour (j) : ");
        int jour = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (m) : ");
        int mois = Integer.parseInt(scanner.nextLine());
        System.out.print("Année (aaaa) : ");
        int annee = Integer.parseInt(scanner.nextLine());

        System.out.print("Heure de début (h) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute de début (m) : ");
        int minute = Integer.parseInt(scanner.nextLine());

        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        System.out.print("lieu : ");
        String lieu = scanner.nextLine();
        System.out.print("participant : ");
        String participant = scanner.nextLine();

        LocalDateTime dateDebut = LocalDateTime.of(annee, mois, jour, heure, minute);

        EtatConnecte.utilisateur.getCm().ajouterReunion(titre, EtatConnecte.utilisateur.login, dateDebut, duree, lieu, participant);

        System.out.println("Rendez-vous periodique ajouté avec succès.");
    }
}
