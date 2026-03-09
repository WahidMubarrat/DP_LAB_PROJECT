package racing.track;

/** Concrete Track - Blue Moon Bay Speedway, USA */
public class BlueMoonBaySpeedway extends Track {

    public BlueMoonBaySpeedway() {
        this.trackName = "Blue Moon Bay Speedway";
        this.location  = "USA";
        this.lengthKm  = 4.1;
    }

    @Override
    public String getTrackType() {
        return "High-speed oval with long straights";
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
