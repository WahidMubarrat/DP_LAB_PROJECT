package racing.strategy;

/** Strategy Pattern - Cummins Turbocharger implementation */
public class CumminsTurbocharger implements TurbochargerBehavior {
    @Override
    public void performTurbo() {
        System.out.println("  [Turbo] Cummins Turbocharger charges hard  -  heavy-duty boost unleashed!");
    }
}
