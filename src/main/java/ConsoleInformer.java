public class ConsoleInformer  {
    public Results gameResults;

    ConsoleInformer(){
    }
    ConsoleInformer(Results results){
        gameResults=results;
    }

    public void gameField(String[] gameField) {
        System.out.println("/---|---|---\\");
        System.out.println("| "
                + gameField[0]  + " | "
                + gameField[1]  + " | "
                + gameField[2]  + " |");
        System.out.println("|-----------|");
        System.out.println("| "
                + gameField[3]  + " | "
                + gameField[4]  + " | "
                + gameField[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| "
                + gameField[6]  + " | "
                + gameField[7]  + " | "
                + gameField[8]  + " |");
        System.out.println("\\---|---|---/");
    }

    public void error() {
        System.out.println("Slot already taken; re-enter slot number:");
    }

    public void turn(String turn) { System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:"); }

    public void win(String winner) { System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing."); }

    public void draw() {
        System.out.println("It's a draw! Thanks for playing.");
    }

    public void yourChoice(){
        System.out.println("Enter your choice");
    }

    public void invalidInputSlot(){
        System.out.println("Invalid input; re-enter slot number:");
    }

    public void invalidInputInMenu(){
        System.out.println("Invalid input; enter your choice:");
    }

    public  void printResults(){
        if (gameResults.getWinsX() ==0 && gameResults.getWinsO()==0 && gameResults.getDraws()==0)
            System.out.println("Start New game please \n to see your results");
        else
        System.out.println("X's wins: "
            + gameResults.getWinsX()+ "\nO's wins: "
            + gameResults.getWinsO() + "\nDraws:"
            + gameResults.getDraws()+"\n"); }

    public void printMenu() { System.out.println("0) New Game\n" + "1) Results\n" + "2) Exit\n"); }

    public void enterName(String symbol){ System.out.println("You will play by "+symbol+". Enter your name please.");}
}
