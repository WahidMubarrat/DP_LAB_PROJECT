package racing.decorator;

import racing.car.Car;

/**
 * Decorator Pattern - Sema NOS.
 * Adds Sema Nitrous Oxide System to any Car at pit-stop.
 */
public class SemaNOS extends CarDecorator {

    public SemaNOS(Car car) {
        super(car);
        System.out.println("  [Pit Stop] Sema NOS mounted on " + car.getName() + "!");
    }

    @Override
    public void applyNOS() {
        System.out.println("  *** SEMA NOS ACTIVATED ***");
        System.out.println("  [NOS] Sema N2O canister pressurizing at 950 psi...");
        System.out.println("  [NOS] Direct-port injection  -  instantaneous torque explosion!");
        System.out.println("  [NOS] " + getName() + " launches with the Sema afterburn!");
    }
}
