package ValueObjects;

import java.time.LocalDateTime;

public final class DateDebut {
    LocalDateTime dd;

    public DateDebut(LocalDateTime dd) {
        this.dd = dd;
    }

    public LocalDateTime getDd() {
        return dd;
    }
}
