import java.util.ArrayList;


public class Treatmenter {
    private static ArrayList<BotMenu> listGames = new ArrayList<BotMenu>();

    private Boolean isRun(long id){
        if(listGames==null)
            return false;
        for(int i=0;i<listGames.size();i++){
            if(listGames.get(i).getId()==id)
                return true;
        }
        return false;
    }
    private BotMenu getActiveGame(long id){
        for(int i=0;i<listGames.size();i++){
            if(listGames.get(i).getId()==id)
                return listGames.get(i);
        }
        return null;
    }

    public void treatment(String messages, final long Id) {
        if(isRun(Id)){
                BotMenu active = getActiveGame(Id);
                if(active.getState()=="Menu")
                    active.setYourChoice(messages);
                else
                    active.getGame().setYourChoice(messages);
            }
        else {
            listGames.add(new BotMenu(Id));
        }
    }
}
