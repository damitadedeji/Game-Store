public class Game {
    //enums
    enum Format {DISC, KEY};
    enum Platform {PS4, PS5, PC, XBOXONE, XBOXSERIESX};

    // attributes
    String title;
    int yearOfRelease;
    Format format;
    Platform platform;
    boolean onLoan;

    // constructor
    public Game(String title, int yearOfRelease, Format format, Platform platform) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.format = format;
        this.platform = platform;
        this.onLoan = false;
    }

    /* get methods, probably not necessary if the attributes are public
    public String getTitle() { return title;}
    public int getYearOfRelease() {return yearOfRelease; }
    public Format getFormat() {return format;}
    public Platform getPlatform() {return platform;}
    public boolean isOnLoan() {return onLoan;}  */

}
