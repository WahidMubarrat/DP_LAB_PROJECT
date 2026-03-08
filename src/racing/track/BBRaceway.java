package racing.track;

/** Concrete Track - BB Raceway, Japan */
public class BBRaceway extends Track {

    public BBRaceway() {
        this.trackName = "BB Raceway";
        this.location  = "Japan";
        this.lengthKm  = 2.8;
    }

    @Override
    public void trackInfo() {
        System.out.println("\n  ================================================");
        System.out.println("  Track   : " + trackName);
        System.out.println("  Country : " + location);
        System.out.println("  Length  : " + lengthKm + " km");
        System.out.println("  Type    : Technical circuit with tight chicanes");
        System.out.println("  ================================================");
    }

    @Override
    public void startLine() {
        System.out.println("  [Track] >> BB Raceway  -  START LINE << Engine screams, tyres grip!");
    }

    @Override
    public void finishLine() {
        System.out.println("  [Track] >> BB Raceway  -  FINISH LINE << The crowd erupts!");
    }
}
