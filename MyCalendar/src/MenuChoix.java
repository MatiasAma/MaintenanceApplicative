public enum MenuChoix {
    CONNEXION("1"),
    CREER_COMPTE("2"),
    VOIR_EVENEMENTS("10"),
    AJOUTER_RDV("20"),
    AJOUTER_REUNION("30"),
    AJOUTER_PERIODIQUE("40"),
    AJOUTER_ANNUELLE("50"),
    DECONNECTER("60");

    private String code;

    MenuChoix(String code) {
        this.code = code;
    }

    public static MenuChoix fromCode(String code) {
        for (MenuChoix choix : MenuChoix.values()) {
            if (choix.code.equals(code)) {
                return choix;
            }
        }
        throw new IllegalArgumentException("Choix invalide: " + code);
    }
}
