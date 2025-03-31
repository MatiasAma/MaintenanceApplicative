final public class Utilisateur {
    boolean connecte;
    String login;
    String password;
    CalendarManager cm;

    public Utilisateur() {
        connecte = false;
    }

    public Utilisateur(String login, String password, CalendarManager cm) {
        this.connecte = true;
        this.login = login;
        this.password = password;
        this.cm = cm;
    }

    public boolean isConnecte() {
        return connecte;
    }

    public CalendarManager getCm() {
        return cm;
    }
}
