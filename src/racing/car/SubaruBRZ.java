package racing.car;

import racing.strategy.CumminsTurbocharger;
import racing.strategy.V6Engine;

/** Concrete Coupe - Subaru BRZ */
public class SubaruBRZ extends Coupe {

    public SubaruBRZ() {
        this.name = "Subaru BRZ";
        this.engineBehavior        = new V6Engine();
        this.turbochargerBehavior  = new CumminsTurbocharger();
    }

    @Override
    protected void displayDetails() {
        System.out.println("  [BRZ]   Co-developed 2.4L Boxer | 228 hp | RWD");
        System.out.println("  [BRZ]   Low center of gravity for razor-sharp handling.");
    }
}
