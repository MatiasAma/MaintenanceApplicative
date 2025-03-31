import java.util.List;
import java.util.Scanner;

public class VoirEvenement implements MethodeMain{

    public VoirEvenement() {}

    @Override
    public void executer() {
       EtatConnecte.utilisateur.getCm().afficherEvenements();
    }
}
