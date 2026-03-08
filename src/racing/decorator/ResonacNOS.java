package racing.decorator;

import racing.car.Car;

/**
 * Decorator Pattern - Resonac NOS.
 * Adds Resonac Nitrous Oxide System to any Car at pit-stop.
 */
public class ResonacNOS extends CarDecorator {

    public ResonacNOS(Car car) {
        super(car);
        System.out.println("  [Pit Stop] Resonac NOS mounted on " + car.getName() + "!");
    }

    @Override
    public void applyNOS() {
        System.out.println("  *** RESONAC NOS ACTIVATED ***");
        System.out.println("  [NOS] Resonac N2O flooding the intake manifold...");
        System.out.println("  [NOS] Combustion pressure surges  -  MASSIVE power spike!");
        System.out.println("  [NOS] " + getName() + " rockets forward with Resonac boost!");
    }
}
