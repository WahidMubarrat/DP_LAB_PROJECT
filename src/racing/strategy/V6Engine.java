package racing.strategy;

/** Strategy Pattern - V6 Engine implementation */
public class V6Engine implements EngineBehavior {
    @Override
    public void performEngine() {
        System.out.println("  [Engine] V6 Engine fires up with a smooth, balanced roar!");
    }
}
