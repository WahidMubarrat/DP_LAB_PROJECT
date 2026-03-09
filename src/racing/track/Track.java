package racing.track;

/**
 * Track - Abstract class.
 */
public abstract class Track {

    protected String trackName;
    protected String location;
    protected double lengthKm;

    public abstract String getTrackType();

    public void trackInfo() {
        System.out.println("\n  ================================================");
        System.out.println("  Track   : " + trackName);
        System.out.println("  Country : " + location);
        System.out.println("  Length  : " + lengthKm + " km");
        System.out.println("  Type    : " + getTrackType());
        System.out.println("  ================================================");
    }

    public abstract void startLine();

    public abstract void finishLine();

    public String getTrackName() {
        return trackName;
    }
}
