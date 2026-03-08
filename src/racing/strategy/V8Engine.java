package racing.strategy;

/** Strategy Pattern - V8 Engine implementation */
public class V8Engine implements EngineBehavior {
    @Override
    public void performEngine() {
        System.out.println("  [Engine] V8 Engine thunders with raw, aggressive power!");
    }
}
