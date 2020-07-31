package bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class CIBotMain {
    public static void  main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botApi = new TelegramBotsApi();

        try {
            botApi.registerBot(new CIBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
