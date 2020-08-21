package bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;
import java.net.URL;

public class CIBot extends TelegramLongPollingBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(CIBot.class);


    @Override
    public void onUpdateReceived(Update update) {
        LOGGER.info("Update is comming '{}'",update);
        if (update.hasMessage() && update.getMessage().hasText()) {
            String incomingMessage = update.getMessage().getText();
            LOGGER.info("[Incoming message] '{}'",incomingMessage);
            long chat_id = update.getMessage().getChatId();
            if (incomingMessage.startsWith("[Hey boy]")) {
                String messageText = update.getMessage().getText();
                SendMessage message = new SendMessage().setChatId(chat_id).setText(messageText);
                sendTextMessage(message);
            }
            if (incomingMessage.equals("Hello there")) {
                URL url = getClass().getClassLoader().getResource("greevos.jpg");
                assert url != null;
                File photoFile = new File(url.getPath());
                SendPhoto photo = new SendPhoto().setChatId(chat_id).setPhoto(photoFile);
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
