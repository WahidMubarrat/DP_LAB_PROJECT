package racing.car;

import racing.strategy.AlpineTurbocharger;
import racing.strategy.V12Engine;

/** Concrete Roadster - Ferrari 812 */
public class Ferrari812 extends Roadster {

    public Ferrari812() {
        this.name = "Ferrari 812";
        this.engineBehavior        = new V12Engine();
        this.turbochargerBehavior  = new AlpineTurbocharger();
    }

    @Override
    protected void displayDetails() {
        System.out.println("  [812]   Naturally-aspirated 6.5L V12 | 789 hp | RWD");
        System.out.println("  [812]   The most powerful naturally-aspirated Ferrari ever built.");
    }
}
