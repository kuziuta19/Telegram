import java.util.Scanner;

public class BotMenu {
    private volatile String state;
    public  String getState(){
        return state;
    }

    private BotGame game;
    public BotGame getGame(){
        return game;
    }
    private volatile String yourChoice="";
    private long id;
    public long getId(){
        return id;
    }
    public BotMenu(long id){
        this.id=id;
        startProgram();
        this.state="Menu";
    }
    public void setYourChoice(String yourChoice) {
        this.yourChoice = yourChoice;
    }

    private Results results=new Results();

    private void choiceInput(long id) {

        while (true) {
            new BotInformer().yourChoice(id);
            state="Menu";
            while (yourChoice=="") {
            }
            if(new Scanner(yourChoice).nextInt()>=0&&new Scanner(yourChoice).nextInt()<=2)
                break;

            new BotInformer().invalidInputInMenu(id);
            yourChoice="";
        }


    }

    public void startProgram(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    new  BotInformer().printMenu(id);
                    choiceInput(id);
                    while (yourChoice=="") {
                    }
                    switch (new Scanner(yourChoice).nextInt()) {
                        case 0: {
                            newGame();
                            break;
                        }
                        case 1:{
                            new BotInformer(results).printResults(id);
                            yourChoice="";
                            break;}
                        case 2:{
                            System.exit(0);
                        }
                    }
                }
                while (true);
            }
        }).start();

    }
    public void newGame(){
        yourChoice="";

       new  BotInformer().enterName("X",id);
        while (yourChoice=="") {
        }
        String nameX = yourChoice;

        new BotInformer().enterName("O",id);
        yourChoice="";
        while (yourChoice=="") {
        }
        String nameO = yourChoice;

        yourChoice="";
        Player playerX = new Player(nameX);
        Player playerO = new Player(nameO);
        state="Game";
        game=new BotGame(results,playerX,playerO,id);
        game.NewGame();
    }
}
