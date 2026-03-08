package racing.factory;

import racing.car.Car;
import racing.car.Ferrari812;
import racing.car.PorscheBoxster;

/* Abstract Factory Pattern - Roadster Factory.
 Produces Porsche Boxster and Ferrari 812.
 */
public class RoadsterFactory implements CarFactory {

    @Override
    public Car createCar(int choice) {
        switch (choice) {
            case 1: return new PorscheBoxster();
            case 2: return new Ferrari812();
            default:
                System.out.println("  Invalid choice. Defaulting to Porsche Boxster.");
                return new PorscheBoxster();
        }
    }

    @Override
    public void printCarMenu() {
        System.out.println("  ─── Roadster Cars ────────────────────");
        System.out.println("  1. Porsche Boxster");
        System.out.println("  2. Ferrari 812");
        System.out.println("  ──────────────────────────────────────");
    }
}
