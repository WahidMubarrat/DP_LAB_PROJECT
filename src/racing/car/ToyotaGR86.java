package racing.car;

import racing.strategy.AlpineTurbocharger;
import racing.strategy.V6Engine;

/** Concrete Coupe - Toyota GR86 */
public class ToyotaGR86 extends Coupe {

    public ToyotaGR86() {
        this.name = "Toyota GR86";
        this.engineBehavior        = new V6Engine();
        this.turbochargerBehavior  = new AlpineTurbocharger();
    }

    @Override
    protected void displayDetails() {
        System.out.println("  [GR86]  Naturally-aspirated 2.4L Boxer | 228 hp | RWD");
        System.out.println("  [GR86]  Designed for grip and driver engagement on every corner.");
    }
}
