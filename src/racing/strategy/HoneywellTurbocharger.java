package racing.strategy;

/** Strategy Pattern - Honeywell Turbocharger implementation */
public class HoneywellTurbocharger implements TurbochargerBehavior {
    @Override
    public void performTurbo() {
        System.out.println("  [Turbo] Honeywell Turbocharger kicks in  -  aerospace-grade boost ignited!");
    }
}
