import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface Evenement {
    String description();
    public List<Evenement> isInPeriode (LocalDateTime debut, LocalDateTime fin, List<Evenement> listEvent);
    public boolean conflit(Evenement e2);
}
