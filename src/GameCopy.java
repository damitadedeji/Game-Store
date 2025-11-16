public class GameCopy extends Game{
    // attribute
    private int ID; // i need a way to implement this

    public GameCopy(String title, int yearOfRelease, Format format, Platform platform) {
        super(title, yearOfRelease, format, platform);
        // add id somehow
    }
    
    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}

}
