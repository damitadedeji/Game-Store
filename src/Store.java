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
        game.ID = collection.indexOf(game);
    }

    public void removeGame(String title) {
        // removes ALL copies of game with matching title

        boolean removed = collection.removeIf(game -> (game.title.equals(title)));

        if (removed) System.out.println("All copies of " + title + " have been successfully removed.");
        else System.out.println("This game title is not in " + name + " collection.");
    }

    public void loanGame(String title) {
        for (GameCopy game : collection) {
            if (game.title.equals(title)) {
                if (!game.onLoan) {
                    game.onLoan = true;
                    System.out.println("You have successfully borrowed " + game.title + " (Copy ID: " + game.ID + ").");
                    return;
                }
                else {
                    System.out.println("This copy of " + title + " (Item ID: " + game.ID + ") is currently on loan.");
                    return;
                }
            }
        }

        System.out.println("This game title is not in this collection.");
    }

    public void printCollection() {
        System.out.println("********************\nAvailable game copies at " + name + ":\n");
        for (GameCopy game : collection) {
            if (!game.onLoan) System.out.println(game.title.toUpperCase() + ": Release " + game.yearOfRelease + ", for platform " + game.platform + ", " + game.format + " format");
        }
        System.out.println("********************");
    }

    public void returnGame(int ID) {
        GameCopy game = collection.get(ID);
        if (game.onLoan) {
            game.onLoan = false;
            System.out.println("You have successfully returned " + game.title + " (Item ID: " + ID + ").");
            return;
        }
        System.out.println("This game was not loaned.");
    }

}
