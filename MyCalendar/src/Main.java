import java.util.*;

public class Main {
    private static Etat etat;
    public static final Map<MenuChoix, MethodeMain> methodesNonConnecte = new HashMap<>();
    public static final Map<MenuChoix, MethodeMain> methodesConnecte = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Utilisateur> utilisateurs = new ArrayList<>();

    public static void main(String[] args) {
        initialiserMethodeNonConnecte();
        initialiserMethodeConnecte();
        etat = new EtatNonConnecte(methodesNonConnecte);

        while (true) {
            etat.afficherMenu();
            String choix = scanner.nextLine();
            etat.executerChoix(choix);
        }
    }

    private static void initialiserMethodeNonConnecte() {
        methodesNonConnecte.put(MenuChoix.CONNEXION, new Connection(scanner, utilisateurs));
        methodesNonConnecte.put(MenuChoix.CREER_COMPTE, new CreerCompte(scanner, utilisateurs));
    }

    private static void initialiserMethodeConnecte() {
        methodesConnecte.put(MenuChoix.VOIR_EVENEMENTS, new VoirEvenement());
        methodesConnecte.put(MenuChoix.AJOUTER_RDV, new AjouterRDV(scanner));
        methodesConnecte.put(MenuChoix.AJOUTER_REUNION, new AjouterReunion(scanner));
        methodesConnecte.put(MenuChoix.AJOUTER_PERIODIQUE, new AjouterPeriodique(scanner));
        methodesConnecte.put(MenuChoix.AJOUTER_ANNUELLE, new AjouterAnnuelle(scanner));
        methodesConnecte.put(MenuChoix.DECONNECTER, new Deconnection(scanner));
    }

    public static void changerEtat(Etat nouvelEtat) {
        etat = nouvelEtat;
    }
}
