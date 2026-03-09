package racing.decorator;

import racing.car.Car;
import racing.strategy.EngineBehavior;
import racing.strategy.TurbochargerBehavior;

/**
 * Decorator Pattern - Abstract Car Decorator.
 * Wraps a Car and extends it with additional pit-stop functionality (NOS).
 * Delegates all base Car methods to the wrapped instance.
 */
public abstract class CarDecorator extends Car {

    protected final Car decoratedCar;

    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }

    // ── Delegate all base behaviour to the wrapped car ───────────────────────
    @Override
    public void carInfo() {
        decoratedCar.carInfo();
    }

    @Override
    public void start() {
        decoratedCar.start();
    }

    @Override
    public void stop() {
        decoratedCar.stop();
    }

    @Override
    public void accelerate() {
        decoratedCar.accelerate();
    }

    @Override
    public void setEngineBehavior(EngineBehavior eb) {
        decoratedCar.setEngineBehavior(eb);
    }

    @Override
    public void setTurbochargerBehavior(TurbochargerBehavior tb) {
        decoratedCar.setTurbochargerBehavior(tb);
    }

    // ── Delegate all accessors ────────────────────────────────────────────
    @Override public String getName()                               { return decoratedCar.getName(); }
    @Override public EngineBehavior getEngineBehavior()             { return decoratedCar.getEngineBehavior(); }
    @Override public TurbochargerBehavior getTurbochargerBehavior() { return decoratedCar.getTurbochargerBehavior(); }
    @Override public String getCategory()                           { return decoratedCar.getCategory(); }



    // ── NOS extension point ───────────────────────────────────────────────
    /** Activates the NOS system - implemented by concrete decorators. */
    public abstract void applyNOS();
}
