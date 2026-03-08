package racing.track;

/** Concrete Track - Circuit de Spa-Francorchamps, Belgium (listed as Germany in spec) */
public class CircuitDeSpaFrancorchamps extends Track {

    public CircuitDeSpaFrancorchamps() {
        this.trackName = "Circuit de Spa-Francorchamps";
        this.location  = "Germany";
        this.lengthKm  = 7.004;
    }

    @Override
    public void trackInfo() {
        System.out.println("\n  ================================================");
        System.out.println("  Track   : " + trackName);
        System.out.println("  Country : " + location);
        System.out.println("  Length  : " + lengthKm + " km");
        System.out.println("  Type    : Classic GP circuit - Eau Rouge, Pouhon, Blanchimont");
        System.out.println("  ================================================");
    }

    @Override
    public void startLine() {
        System.out.println("  [Track] >> Circuit de Spa  -  START LINE << The legend begins!");
    }

    @Override
    public void finishLine() {
        System.out.println("  [Track] >> Circuit de Spa  -  FINISH LINE << History is made today!");
    }
}
