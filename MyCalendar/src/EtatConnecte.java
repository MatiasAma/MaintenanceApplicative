import java.util.Map;
import java.util.Scanner;

public class EtatConnecte implements Etat {
    Map<MenuChoix, MethodeMain> methode;
    static Utilisateur utilisateur;

    public EtatConnecte(Scanner sc, Utilisateur utilisateur, Map<MenuChoix, MethodeMain> methode) {
        this.methode = methode;
        EtatConnecte.utilisateur = utilisateur;
    }

    @Override
    public void afficherMenu() {
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        System.out.println("1 - Voir les événements");
        System.out.println("2 - Ajouter un rendez-vous perso");
        System.out.println("3 - Ajouter une réunion");
        System.out.println("4 - Ajouter un évènement périodique");
        System.out.println("5 - Ajouter un évènement annuelle");
        System.out.println("6 - Se déconnecter");
        System.out.print("Votre choix : ");
    }

    @Override
    public void executerChoix(String choix) {
        //On concatene un 0 pour prendre les évenement de 10 a 50
        MenuChoix mn = MenuChoix.fromCode(choix + "0");
        methode.get(mn).executer();
        System.out.println('\n');
    }
}
