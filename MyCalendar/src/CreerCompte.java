import java.util.List;
import java.util.Scanner;

public class CreerCompte implements MethodeMain{
    Scanner scanner;
    List<Utilisateur> utilisateurs;

    public CreerCompte(Scanner sc, List<Utilisateur> utilisateurs) {
        this.scanner = sc;
        this.utilisateurs = utilisateurs;
    }

    @Override
    public void executer() {
        System.out.print("Nom d'utilisateur: ");
        String nomUtilisateur = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        Utilisateur u = new Utilisateur(nomUtilisateur,motDePasse,new CalendarManager());
        utilisateurs.addLast(u);
        Main.changerEtat(new EtatConnecte(scanner,u,Main.methodesConnecte));
    }
}
