import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Player playerX,playerO;
    private Results gameResults;
    Game(Results results,Player playerX,Player playerO){
        this.playerX=playerX;
        this.playerO=playerO;
        gameResults=results;
    }

    private String[] gameField =
            {"1","2","3",
             "4","5","6",
             "7","8","9"};

    private String turn;

    private ConsoleInformer consoleInformer =new ConsoleInformer();

    public  void NewGame(Scanner in){
        turn="O";
        consoleInformer.gameField(gameField);
        while (checkWinner() == null) {
            int numInput;
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    consoleInformer.invalidInputSlot();
                    continue;
                }
            } catch (InputMismatchException e) {
                consoleInformer.invalidInputSlot();
                continue;
            }
            turnToNextPlayer(numInput);
        }
        if (checkWinner().equals("draw")) {
            gameResults.setDraws();
            consoleInformer.draw();
        } else {
            if(checkWinner()==playerX.getName())
               gameResults.setWinsX();
            else gameResults.setWinsO();
            consoleInformer.win(checkWinner());
        }
    }

    void turnToNextPlayer(int numInput){
        if (gameField[numInput - 1].equals(String.valueOf(numInput))) {
            gameField[numInput - 1] = turn;
            if (turn.equals("X")) {
                turn = "O";
            } else {
                turn = "X";
            }
            consoleInformer.gameField(gameField);

        } else {
            consoleInformer.error();
        }

    }

    String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = getLine(a);
            if (line.equals("XXX")) {
                return playerX.getName();
            } else if (line.equals("OOO")) {
                return playerO.getName();
            }
        }
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(gameField).contains(String.valueOf(a+1))) {
                break;
            }
            else if(a==8)
                return "draw";
        }
        consoleInformer.turn(turn);
        return null;
    }

    String getLine(int a) {
        switch (a) {
            case 0:
                return gameField[0] + gameField[1] + gameField[2];
            case 1:
                return gameField[3] + gameField[4] + gameField[5];
            case 2:
                return gameField[6] + gameField[7] + gameField[8];
            case 3:
                return gameField[0] + gameField[3] + gameField[6];
            case 4:
                return gameField[1] + gameField[4] + gameField[7];
            case 5:
                return gameField[2] + gameField[5] + gameField[8];
            case 6:
                return gameField[0] + gameField[4] + gameField[8];
            case 7:
                return gameField[2] + gameField[4] + gameField[6];
        }
        return null;
    }
}