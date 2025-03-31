import java.util.List;
import java.util.Scanner;

public class Connection implements MethodeMain{
    Scanner scanner;
    List<Utilisateur> utilisateurs;

    public Connection(Scanner sc, List<Utilisateur> utilisateurs) {
        this.scanner = sc;
        this.utilisateurs = utilisateurs;
    }

    @Override
    public void executer() {
        System.out.print("Nom d'utilisateur: ");
        String nomUtilisateur = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        // Vérifier les informations d'identification
        for (Utilisateur user : utilisateurs) {
            if (user.login.equals(nomUtilisateur) && user.password.equals(motDePasse)) {
                System.out.println("Connexion réussie !");
                // Changer l'état à connecté
                Main.changerEtat(new EtatConnecte(scanner, user ,Main.methodesConnecte));
                return;
            }
        }
        System.out.println("Échec de la connexion. Nom d'utilisateur ou mot de passe incorrect.");
    }
}
