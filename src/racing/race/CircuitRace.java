package racing.race;

import racing.car.Car;
import racing.decorator.CarDecorator;
import racing.track.Track;

/**
 * Template Method Pattern - Circuit Race.
 * The track is circular - the finish line IS the start line (full lap).
 */
public class CircuitRace extends Race {

    public CircuitRace(int nosChoice) {
        super(nosChoice);
    }

    @Override
    protected CarDecorator pitStop(Car car) {
        System.out.println("\n  [Circuit] PIT STOP - entering the pit box...");
        return createNOS(car);   
    }

    @Override
    protected void finishLine(Track track) {
        System.out.println("\n  [Circuit] -------- FINISH LINE --------");
        System.out.println("  [Circuit] Circuit race - finishing line is back at the START of the track!");
        track.finishLine();
        System.out.println("  [Circuit] Full lap completed - the circuit is closed!");
    }
}
