package racing.track;

/** Concrete Track - Blue Moon Bay Speedway, USA */
public class BlueMoonBaySpeedway extends Track {

    public BlueMoonBaySpeedway() {
        this.trackName = "Blue Moon Bay Speedway";
        this.location  = "USA";
        this.lengthKm  = 4.1;
    }

    @Override
    public void trackInfo() {
        System.out.println("\n  ================================================");
        System.out.println("  Track   : " + trackName);
        System.out.println("  Country : " + location);
        System.out.println("  Length  : " + lengthKm + " km");
        System.out.println("  Type    : High-speed oval with long straights");
        System.out.println("  ================================================");
    }

    @Override
    public void startLine() {
        System.out.println("  [Track] >> Blue Moon Bay Speedway  -  START LINE << Lights out!");
    }

    @Override
    public void finishLine() {
        System.out.println("  [Track] >> Blue Moon Bay Speedway  -  FINISH LINE << Checkered flag waves!");
    }
}
