package racing.factory;

import racing.track.BBRaceway;
import racing.track.BlueMoonBaySpeedway;
import racing.track.CircuitDeSpaFrancorchamps;
import racing.track.Track;

/*Factory Pattern - TrackFactory.
 */
public class TrackFactory {

    private TrackFactory() {  }

    /*Prints the menu of available tracks. */
    public static void printTrackMenu() {
        System.out.println("  ─── Available Tracks ─────────────────────────");
        System.out.println("  1. Blue Moon Bay Speedway  (USA)");
        System.out.println("  2. BB Raceway              (Japan)");
        System.out.println("  3. Circuit de Spa-Francorchamps  (Germany)");
        System.out.println("  ──────────────────────────────────────────────");
    }

    /* Returns a Track based on the player's numeric choice.
     */
    public static Track createTrack(int choice) {
        switch (choice) {
            case 1: return new BlueMoonBaySpeedway();
            case 2: return new BBRaceway();
            case 3: return new CircuitDeSpaFrancorchamps();
            default:
                System.out.println("  Invalid choice. Defaulting to Blue Moon Bay Speedway.");
                return new BlueMoonBaySpeedway();
        }
    }
}
