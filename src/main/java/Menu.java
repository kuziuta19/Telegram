import java.util.Scanner;

public class Menu {


    private Scanner in;

    private Results results=new Results();
    private ConsoleInformer consoleInformer =new ConsoleInformer(results);
    private int choiceInput() {
        consoleInformer.yourChoice();
        int yourChoice = in.nextInt();
        while (!(yourChoice >= 0 && yourChoice <= 2)) {
            consoleInformer.invalidInputInMenu();
            yourChoice = in.nextInt();
        }
        return yourChoice;
    }

    public void startProgram(){
        int yourChoice;
        in = new Scanner(System.in);
        do {
            consoleInformer.printMenu();
            yourChoice = choiceInput();
            switch (yourChoice) {
                case 0: {
                    newGame();
                    break;
                }
                case 1:{
                    consoleInformer.printResults();
                    break;}
                case 2:{
                    System.exit(0);
                }
            }
        }
        while (yourChoice != 2) ;
    }
    public void newGame(){
        in = new Scanner(System.in);
        consoleInformer.enterName("X");
        String nameX = in.nextLine();

        consoleInformer.enterName("O");
        String nameO = in.nextLine();
        Player playerX = new Player(nameX);
        Player playerO = new Player(nameO);
        Game game=new Game(results,playerX,playerO);
        game.NewGame(in);
    }
}
