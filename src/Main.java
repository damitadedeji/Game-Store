void main () {

    Store myStore = new Store("Dami's Store");
    for (int i = 0; i < 5; i++)
    {
        GameCopy g = new GameCopy("The Simz " + (i + 1), 2000 + (1 + i * 3), Game.Format.DISC, Game.Platform.PS4);
        myStore.addGame(g);
    }

    myStore.printCollection();
    myStore.loanGame("The Simz 2");
    myStore.removeGame("The Simz 3");
    myStore.printCollection(); // sims 2 and 3 should be gone
    myStore.loanGame("The Simz 2"); // should get error handling message
    myStore.returnGame(1);
    myStore.returnGame(0);
    myStore.printCollection(); // sims 2 should be back and error handling message for sims 1
}