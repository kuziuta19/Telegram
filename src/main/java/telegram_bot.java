import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



public class telegram_bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
           new Treatmenter().treatment(update.getMessage().getText(),update.getMessage().getChatId());
    }
    }
    public void messaging(String message,long id)
    {
            SendMessage mess=new SendMessage().setChatId(id).setText(message);
            try{
                execute(mess);
            }catch (TelegramApiException e){
                e.printStackTrace();
            }
    }

    @Override
    public String getBotUsername() {
        return "Tick_tock_Kuziuta_bot";
    }

    @Override
    public String getBotToken() {
        return "840164257:AAGHY-MzyI89LUHw1TmwlMsDXWGyy0Sbmzg";
    }
    public static void registration(){
        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new telegram_bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
