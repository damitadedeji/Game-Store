public class Game {
    //enums
    enum Format {DISC, KEY};
    enum Platform {PS4, PS5, PC, XBOXONE, XBOXSERIESX};

    // attributes
    private String title;
    private int yearOfRelease;
    private Format format;
    private Platform platform;
    private boolean loanStatus;

    // constructor
    public Game(String title, int yearOfRelease, Format format, Platform platform) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.format = format;
        this.platform = platform;
        this.loanStatus = false;
    }

    // getters
    public String getTitle() { return title;}
    public int getYearOfRelease() {return yearOfRelease; }
    public Format getFormat() {return format;}
    public Platform getPlatform() {return platform;}
    public boolean getLoanStatus() {return loanStatus;} 

    // setters
    public void setLoanStatus(boolean b) {
        loanStatus = b;
    }
}
