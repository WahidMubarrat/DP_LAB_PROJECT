package racing.car;

import racing.strategy.HoneywellTurbocharger;
import racing.strategy.V8Engine;

/** Concrete Roadster - Porsche Boxster */
public class PorscheBoxster extends Roadster {

    public PorscheBoxster() {
        this.name = "Porsche Boxster";
        this.engineBehavior        = new V8Engine();
        this.turbochargerBehavior  = new HoneywellTurbocharger();
    }

    @Override
    protected void displayDetails() {
        System.out.println("  [Boxstr] Mid-engine 4.0L Flat-Six | 394 hp | RWD");
        System.out.println("  [Boxstr] Open-top Roadster  -  ultimate balance and agility.");
    }
}
