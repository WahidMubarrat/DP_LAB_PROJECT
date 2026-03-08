package racing.race;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import racing.car.Car;
import racing.decorator.CarDecorator;
import racing.decorator.ResonacNOS;
import racing.decorator.SemaNOS;
import racing.track.Track;

/**
 * Template Method Pattern - Race.
 */
public abstract class Race {

    private static final int SEMA_NOS = 2;

    protected final int nosChoice;

    protected Race(int nosChoice) {
        this.nosChoice = nosChoice;
    }

    // ── Template Method (final  -  cannot be overridden) ───────────────────────
    public final void race(Car car, Track track) {
        printSectionHeader("RACE START");

        // Step a)  -  car info
        car.carInfo();

        // Step b)  -  track info
        track.trackInfo();

        // Step c)  -  start car
        startCar(car);

        // Step d)  -  cross the start line
        startLine(track);

        // Step e)  -  floor it
        accelerateCar(car);

        // Step f)  -  pit stop: wrap car in NOS decorator
        CarDecorator nos = pitStop(car);

        // Step g)  -  fire the NOS
        applyNos(nos);

        // Step h)  -  cross the finish line
        finishLine(track);

        // Step i)  -  stop the car (now the NOS-decorated version)
        stopCar(nos);

        // Step j)  -  show lap time
        lapTime();

        printSectionHeader("RACE COMPLETE");
    }

    // ── Concrete hook implementations (shared by all races) ──────────────────
    protected void startCar(Car car) {
        car.start();
    }

    private void startLine(Track track) {
        System.out.println("\n  [Race] -------- START LINE --------");
        track.startLine();
    }

    private void accelerateCar(Car car) {
        System.out.println("\n  [Race] -------- FULL THROTTLE --------");
        car.accelerate();
    }

    private void applyNos(CarDecorator nos) {
        System.out.println("\n  [Race] -------- PIT STOP / NOS --------");
        nos.applyNOS();
    }

    private void stopCar(Car car) {
        System.out.println("\n  [Race] -------- COOL DOWN --------");
        car.stop();
    }

    private void lapTime() {
        int totalSeconds = 60 + new Random().nextInt(540);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String time = sdf.format(new Date((long) totalSeconds * 1000L));
        System.out.println("\n  [Race] *** LAP TIME : " + time + " ***");
    }

    protected final CarDecorator createNOS(Car car) {
        if (nosChoice == SEMA_NOS) {
            return new SemaNOS(car);
        }
        return new ResonacNOS(car);
    }

    // ── Abstract hooks - subclasses must implement ────────────────────────
   
    protected abstract CarDecorator pitStop(Car car);

    /**
     * Sprint  : finish at the far end of the track.
     * Circuit : finish back at the start (full lap completed).
     */
    protected abstract void finishLine(Track track);

    // ── UI utility ────────────────────────────────────────────────────────
    private void printSectionHeader(String title) {
        System.out.println("\n  +==========================================+");
        System.out.printf ("  |  %-41s|%n", title);
        System.out.println("  +==========================================+");
    }
}
