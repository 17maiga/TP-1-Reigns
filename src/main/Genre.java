package main;

/**
 * Représente les différents genres possibles.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public enum Genre {
    /**
     * Genre masculin
     */

    ROI,
    /**
     * Genre féminin
     */
    REINE;

    /**
     * Retourne une chaîne de caractères indiquant "Long règne au roi" ou "Long règne à la reine"
     *
     * @return une chaîne de caractères indiquant "Long règne au roi" ou "Long règne à la reine"
     */
    public String getMessageRegne() {
        return this == ROI ? "Long règne au roi" : "Long règne à la reine";
    }
}