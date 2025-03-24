package ValueObjects;

import java.time.LocalDateTime;

public final class DateDebut {
    LocalDateTime dd;

    public DateDebut(LocalDateTime dd) {
        this.dd = dd;
    }

    public boolean isBefore(LocalDateTime d) {
        return dd.isBefore(d);
    }

    public boolean isAfter(LocalDateTime d) {
        return dd.isAfter(d);
    }

    public LocalDateTime getDd() {
        return dd;
    }
}
