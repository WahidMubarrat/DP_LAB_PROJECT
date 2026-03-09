package racing;

import java.util.Scanner;
import racing.car.Car;
import racing.factory.CarFactory;
import racing.factory.RaceFactory;
import racing.factory.TrackFactory;
import racing.race.Race;
import racing.singleton.Player;
import racing.strategy.AlpineTurbocharger;
import racing.strategy.CumminsTurbocharger;
import racing.strategy.EngineBehavior;
import racing.strategy.HoneywellTurbocharger;
import racing.strategy.TurbochargerBehavior;
import racing.strategy.V12Engine;
import racing.strategy.V6Engine;
import racing.strategy.V8Engine;
import racing.track.Track;

public class Rii {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printBanner();

        // 1. Player - Singleton
        System.out.print("\n  Enter your player name: ");
        Player player = Player.getInstance(sc.nextLine().trim());

        // 2. Choose car category - Abstract Factory
        printHeader("SELECT CAR CATEGORY");
        System.out.println("  1. Coupe    (Toyota GR86, Subaru BRZ)");
        System.out.println("  2. Roadster (Porsche Boxster, Ferrari 812)");
        System.out.print("  Your choice: ");
        CarFactory carFactory = (readInt(sc, 1, 2) == 1)
                ? CarFactory.getCoupeFactory()
                : CarFactory.getRoadsterFactory();

        // 3. Choose specific car
        printHeader("SELECT CAR");
        carFactory.printCarMenu();
        System.out.print("  Your choice: ");
        Car car = carFactory.createCar(readInt(sc, 1, 2));
        System.out.println("  [Game] You selected: " + car.getName());

        // 4. Tune the car - Strategy Pattern (runtime behavior swap)
        printHeader("TUNE YOUR CAR");
        System.out.println("  Choose Engine:  1. V6   2. V8   3. V12");
        System.out.print("  Your choice: ");
        car.setEngineBehavior(createEngine(readInt(sc, 1, 3)));

        System.out.println("  Choose Turbocharger:  1. Alpine   2. Cummins   3. Honeywell");
        System.out.print("  Your choice: ");
        car.setTurbochargerBehavior(createTurbo(readInt(sc, 1, 3)));

        // 5. Choose track - Factory Pattern
        printHeader("SELECT TRACK");
        TrackFactory.printTrackMenu();
        System.out.print("  Your choice: ");
        Track track = TrackFactory.createTrack(readInt(sc, 1, 3));
        System.out.println("  [Game] Track selected: " + track.getTrackName());

        // 6. Choose race type - Factory Pattern
        printHeader("SELECT RACE TYPE");
        RaceFactory.printRaceMenu();
        System.out.print("  Your choice: ");
        int raceType = readInt(sc, 1, 2);

        // 7. Choose NOS for the pit stop - Decorator Pattern
        printHeader("CHOOSE NOS FOR PIT STOP");
        System.out.println("  1. Resonac NOS");
        System.out.println("  2. Sema NOS");
        System.out.print("  Your choice: ");
        int nosChoice = readInt(sc, 1, 2);

        // 8. Run race - Template Method Pattern
        Race race = RaceFactory.createRace(raceType, nosChoice);
        System.out.println("\n  ========================================");
        System.out.println("  GET READY, " + player.getPlayerName().toUpperCase() + "!");
        System.out.println("  ========================================");
        race.race(car, track);

        player.recordRace();
        player.showStats();

        sc.close();
    }

    // ── Strategy helpers: create behaviors without 'new' in main ─────────────
    private static EngineBehavior createEngine(int choice) {
        switch (choice) {
            case 2:  return new V8Engine();
            case 3:  return new V12Engine();
            default: return new V6Engine();
        }
    }

    private static TurbochargerBehavior createTurbo(int choice) {
        switch (choice) {
            case 2:  return new CumminsTurbocharger();
            case 3:  return new HoneywellTurbocharger();
            default: return new AlpineTurbocharger();
        }
    }

    // ── Input helper ──────────────────────────────────────────────────────────
    private static int readInt(Scanner sc, int min, int max) {
        while (true) {
            try {
                int val = Integer.parseInt(sc.nextLine().trim());
                if (val >= min && val <= max) return val;
                System.out.printf("  Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.printf("  Invalid input. Enter a number between %d and %d: ", min, max);
            }
        }
    }

    // ── UI helpers ────────────────────────────────────────────────────────────
    private static void printHeader(String title) {
        System.out.println("\n  ========================================");
        System.out.println("  " + title);
        System.out.println("  ========================================");
    }

    private static void printBanner() {
        System.out.println();
        System.out.println("  ============================================================");
        System.out.println("  |                                                          |");
        System.out.println("  |        R A C I N G   I N   I U T                         |");
        System.out.println("  |        Single Player Racing Game                         |");
        System.out.println("  |                                                          |");
        System.out.println("  ============================================================");
        System.out.println();
        System.out.println("         Welcome to Racing In IUT  -  Single Player Mode");
        System.out.println();
    }
}
