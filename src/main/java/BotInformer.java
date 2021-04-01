public class BotInformer  {
        public Results gameResults;

        BotInformer(){
        }
        BotInformer(Results results){
            gameResults=results;
        }

        public void gameField(String[] gameField,long id) {

            new telegram_bot().messaging(""+
                    "\n/---|---|---\\"+
                    "\n| "
                    + gameField[0]  + " | "
                    + gameField[1]  + " | "
                    + gameField[2]  + " |"+
                    "\n|-----------|"+
                    "\n| "
                    + gameField[3]  + " | "
                    + gameField[4]  + " | "
                    + gameField[5]  + " |"+
                    "\n|-----------|"+
                    "\n| "
                    + gameField[6]  + " | "
                    + gameField[7]  + " | "
                    + gameField[8]  + " |"+
                    "\n\\---|---|---/",id);
        }

        public void error(long id) {
            new telegram_bot().messaging("Slot already taken; re-enter slot number:",id);
        }

        public void turn(String turn,long id) { new telegram_bot().messaging(turn + "'s turn; enter a slot number to place " + turn + " in:",id); }

        public void win(String winner,long id) { new telegram_bot().messaging("Congratulations! " + winner + "'s have won! Thanks for playing.",id); }

        public void draw(long id) {
            new telegram_bot().messaging("It's a draw! Thanks for playing.",id);
        }

        public void yourChoice(long id){
            new telegram_bot().messaging("Enter your choice",id);
        }

        public void invalidInputSlot(long id){
            new telegram_bot().messaging("Invalid input; re-enter slot number:",id);
        }

        public void invalidInputInMenu(long id){
            new telegram_bot().messaging("Invalid input; enter your choice:",id);
        }

        public  void printResults(long id){ new telegram_bot().messaging("X's wins: " + gameResults.getWinsX()+ "\nO's wins: " + gameResults.getWinsO() + "\nDraws:" + gameResults.getDraws()+"\n",id); }

        public void printMenu(long id) { new telegram_bot().messaging("0) New Game\n" + "1) Results\n" + "2) Exit\n",id); }

        public void enterName(String symbol,long id){ new telegram_bot().messaging("You will play by "+symbol+". Enter your name please.",id);}

}
