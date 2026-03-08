package racing.strategy;

/** Strategy Pattern - V12 Engine implementation */
public class V12Engine implements EngineBehavior {
    @Override
    public void performEngine() {
        System.out.println("  [Engine] V12 Engine screams with otherworldly, spine-tingling fury!");
    }
}
