package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.File;

public class CIBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String incomingMessage = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (incomingMessage.startsWith("[Hey boy]")) {
                String messageText = update.getMessage().getText();
                SendMessage message = new SendMessage().setChatId(chat_id).setText(messageText);
                sendTextMessage(message);
            }
            if (incomingMessage.equals("hello there")) {
                File photoFile = new File("../resources/greevos.jpg");
                SendPhoto photo = new SendPhoto().setChatId(chat_id).setPhoto(photoFile);
                System.out.println("Absolute file path: " + photoFile.getAbsolutePath());
                System.out.println("Pathname stringL:" +  photoFile.getPath());
                System.out.println("URI:" +  photoFile.toURI());
                sendPhoto(photo);
            }
        }
    }

    private void sendTextMessage(final SendMessage message){
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendPhoto(final SendPhoto photo) {
        try {
            execute(photo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return "Helper";
    }

    @Override
    public String getBotToken() {
        return "123654789:ASD_QWERYTMZXCASG";
    }
}
