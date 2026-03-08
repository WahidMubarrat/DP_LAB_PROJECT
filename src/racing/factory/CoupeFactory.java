package racing.factory;

import racing.car.Car;
import racing.car.SubaruBRZ;
import racing.car.ToyotaGR86;

/**
 * Abstract Factory Pattern - Coupe Factory.
 * Produces Toyota GR86 and Subaru BRZ.
 */
public class CoupeFactory implements CarFactory {

    @Override
    public Car createCar(int choice) {
        switch (choice) {
            case 1: return new ToyotaGR86();
            case 2: return new SubaruBRZ();
            default:
                System.out.println("  Invalid choice. Defaulting to Toyota GR86.");
                return new ToyotaGR86();
        }
    }

    @Override
    public void printCarMenu() {
        System.out.println("  ─── Coupe Cars ───────────────────────");
        System.out.println("  1. Toyota GR86");
        System.out.println("  2. Subaru BRZ");
        System.out.println("  ──────────────────────────────────────");
    }
}
