import java.util.ArrayList;

public class Store {
    // attributes
    String name;
    ArrayList<GameCopy> collection;

    // constructor
    public Store(String name) {
        this.name = name;
        collection = new ArrayList<>();
    }

    // methods
    public boolean inCollection(GameCopy game) {
        return collection.contains(game);
    }
    public void addGame(GameCopy game) {
        collection.add(game);
        game.setID(collection.indexOf(game));
    }

    public void removeGame(String title) {
        // removes ALL copies of game with matching title

        boolean removed = collection.removeIf(game -> (game.getTitle().equals(title)));

        if (removed) System.out.println("All copies of " + title + " have been successfully removed.");
        else System.out.println("This game title is not in " + name + " collection.");
    }

    public void loanGame(String title) {
        for (GameCopy game : collection) {
            String t = game.getTitle();
            if (t.equals(title)) {
                if (!game.getLoanStatus()) {
                    game.setLoanStatus(true);
                    System.out.println("You have successfully borrowed " + t + " (Copy ID: " + t + ").");
                    return;
                }
                else {
                    System.out.println("This copy of " + t + " (Item ID: " + game.getID() + ") is currently on loan.");
                    return;
                }
            }
        }

        System.out.println("This game title is not in this collection.");
    }

    public void printCollection() {
        System.out.println("********************\nAvailable game copies at " + name + ":\n");
        for (GameCopy game : collection) {
            if (!game.getLoanStatus()) System.out.println(game.getTitle().toUpperCase() + ": Release " + game.getYearOfRelease() + ", for platform " + game.getPlatform() + ", " + game.getFormat() + " format");
        }
        System.out.println("********************");
    }

    public void returnGame(int ID) {
        GameCopy game = collection.get(ID);
        if (game.getLoanStatus()) {
            game.setLoanStatus(false);
            System.out.println("You have successfully returned " + game.getTitle() + " (Item ID: " + ID + ").");
            return;
        }
        System.out.println("This game was not loaned.");
    }

}
