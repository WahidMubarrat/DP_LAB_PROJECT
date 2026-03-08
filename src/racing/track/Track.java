package racing.track;

/**
 * Track - Abstract class.
 */
public abstract class Track {

    protected String trackName;
    protected String location;
    protected double lengthKm;

    public abstract void trackInfo();

    public abstract void startLine();

    public abstract void finishLine();

    public String getTrackName() {
        return trackName;
    }
}
