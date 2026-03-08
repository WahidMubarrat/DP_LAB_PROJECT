package racing.strategy;

/** Strategy Pattern - Alpine Turbocharger implementation */
public class AlpineTurbocharger implements TurbochargerBehavior {
    @Override
    public void performTurbo() {
        System.out.println("  [Turbo] Alpine Turbocharger spools up  -  precision airflow boost engaged!");
    }
}
