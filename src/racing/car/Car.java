package racing.car;

import racing.strategy.EngineBehavior;
import racing.strategy.TurbochargerBehavior;

/**
 * Car - Abstract base class.
 */
public abstract class Car {

    protected String name;
    protected EngineBehavior engineBehavior;
    protected TurbochargerBehavior turbochargerBehavior;

   
    public void setEngineBehavior(EngineBehavior engineBehavior) {
        this.engineBehavior = engineBehavior;
        System.out.println("  [Tune] Engine updated to: "
                + engineBehavior.getClass().getSimpleName());
    }

    public void setTurbochargerBehavior(TurbochargerBehavior turbochargerBehavior) {
        this.turbochargerBehavior = turbochargerBehavior;
        System.out.println("  [Tune] Turbocharger updated to: "
                + turbochargerBehavior.getClass().getSimpleName());
    }

    // ── Common car methods ────────
    public void start() {
        System.out.println("\n  [Car] " + name + " is starting...");
        engineBehavior.performEngine();
    }

    public void stop() {
        System.out.println("  [Car] " + name + " comes to a halt. Engine off.");
    }

    public void accelerate() {
        System.out.println("  [Car] " + name + " is accelerating hard!");
        turbochargerBehavior.performTurbo();
    }

    public String getName()                               { return name; }
    public EngineBehavior getEngineBehavior()             { return engineBehavior; }
    public TurbochargerBehavior getTurbochargerBehavior() { return turbochargerBehavior; }

    // ── Abstract hooks ──────
    public abstract String getCategory();

  
    protected abstract void displayDetails();

   
    public void carInfo() {
        System.out.println("  +------------------------------------------+");
        System.out.println("  |  Category : " + String.format("%-29s", getCategory()) + "|");
        System.out.println("  |  Car      : " + String.format("%-29s", name) + "|");
        System.out.println("  |  Engine   : " + String.format("%-29s", engineBehavior.getClass().getSimpleName()) + "|");
        System.out.println("  |  Turbo    : " + String.format("%-29s", turbochargerBehavior.getClass().getSimpleName()) + "|");
        System.out.println("  +------------------------------------------+");
        displayDetails();
    }
}
