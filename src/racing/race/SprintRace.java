package racing.race;

import racing.car.Car;
import racing.decorator.CarDecorator;
import racing.track.Track;

/**
 * Template Method Pattern - Sprint Race.
 * Finish line is at the FAR END of the track (point-to-point).
 */
public class SprintRace extends Race {

    public SprintRace(int nosChoice) {
        super(nosChoice);
    }

    @Override
    protected CarDecorator pitStop(Car car) {
        System.out.println("\n  [Sprint] PIT STOP - pulling into the pit lane...");
        return createNOS(car);   
    }

    @Override
    protected void finishLine(Track track) {
        System.out.println("\n  [Sprint] -------- FINISH LINE --------");
        System.out.println("  [Sprint] Sprint race - finish line is at the FAR END of the track!");
        track.finishLine();
    }
}
