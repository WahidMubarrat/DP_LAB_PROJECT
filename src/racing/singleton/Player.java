package racing.singleton;

/**
 * Singleton Pattern - Player.

 */
public class Player {

    private static volatile Player instance = null;

    private final String playerName;
    private int totalRaces;

    // ── Private constructor prevents external instantiation ──────────────────
    private Player(String playerName) {
        this.playerName = playerName;
        this.totalRaces = 0;
        System.out.println("  [Player] New Player created: " + playerName);
    }


    public static Player getInstance(String playerName) {
        if (instance == null) {
            synchronized (Player.class) {
                if (instance == null) {
                    instance = new Player(playerName);
                }
            }
        } else {
            System.out.println("  [Player] Player already exists: " + instance.playerName
                    + " (ignoring name \"" + playerName + "\")");
        }
        return instance;
    }

    // ── Accessors ────────────────────────────────────────────────────────────
    public String getPlayerName() {
        return playerName;
    }

    /** Increments the race counter for this player. */
    public void recordRace() {
        totalRaces++;
    }

    public void showStats() {
        System.out.println("\n  +==============================+");
        System.out.println("  |       PLAYER  STATS          |");
        System.out.println("  +==============================+");
        System.out.printf ("  |  Name       : %-15s|%n", playerName);
        System.out.printf ("  |  Races run  : %-15d|%n", totalRaces);
        System.out.println("  +==============================+");
    }

}
