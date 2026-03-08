package racing.factory;

import racing.race.CircuitRace;
import racing.race.Race;
import racing.race.SprintRace;

/*
 * Factory Pattern - RaceFactory.
 */
public class RaceFactory {

    private RaceFactory() {  }

    public static void printRaceMenu() {
        System.out.println("  --- Available Race Types -------------------------");
        System.out.println("  1. Sprint  - start to end of track (one-way)");
        System.out.println("  2. Circuit - circular, finish line = start line");
        System.out.println("  --------------------------------------------------");
    }

   
    public static Race createRace(int raceType, int nosChoice) {
        if (raceType == 2) {
            return new CircuitRace(nosChoice);
        }
        return new SprintRace(nosChoice);
    }
}
