package racing.track;

/** Concrete Track - BB Raceway, Japan */
public class BBRaceway extends Track {

    public BBRaceway() {
        this.trackName = "BB Raceway";
        this.location  = "Japan";
        this.lengthKm  = 2.8;
    }

    @Override
    public String getTrackType() {
        return "Technical circuit with tight chicanes";
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
