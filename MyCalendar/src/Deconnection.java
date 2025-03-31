import java.util.Scanner;

public class Deconnection implements MethodeMain {

    public Deconnection(Scanner sc) {}

    @Override
    public void executer() {
        EtatConnecte.utilisateur = null;
        Main.changerEtat(new EtatNonConnecte(Main.methodesNonConnecte));
    }
}
