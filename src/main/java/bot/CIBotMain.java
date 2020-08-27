package bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.RestApi;

public class CIBotMain {
    private final RestApi restApi;

    public CIBotMain(RestApi restApi) {
        this.restApi = restApi;
    }

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
