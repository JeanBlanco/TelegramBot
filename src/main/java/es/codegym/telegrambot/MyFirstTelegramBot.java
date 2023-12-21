package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "ProgramerJean_bot";
    public static final String TOKEN = "6920316024:AAHif9NAl0nsd9wAevpO-_aMq9PL7Hzypnc";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if(getMessageText().equals("/start")){
          setUserGlory(0);
          sendPhotoMessageAsync("step_1_pic");
          sendTextMessageAsync(STEP_1_TEXT,
                  Map.of("!Hakear la nevera", "STEP_1_bn"));
        }
        if(getCallbackQueryButtonKey().equals("STEP_1_bn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("!Tomar una salchicha¡ +20 de fama", "STEP_2_bn",
                            "!Tomar un pescado¡ +20 de fama", "STEP_2_bn",
                            "!Tirar una lata de pepinillos¡ +20 de fama", "STEP_2_bn"));
        }
        if(getCallbackQueryButtonKey().equals("STEP_2_bn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("!Hakear vel robot aspirador¡ ", "STEP_3_bn"));
        }
        if(getCallbackQueryButtonKey().equals("STEP_3_bn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("!Enviar al  robot aspiorador a por comida¡ +30 de fama", "STEP_4_bn",
                            "!Dar un paseo en el robot aspirador¡ +30 de fama", "STEP_4_bn",
                            "!Huir del robot aspirador¡ +30 de fama", "STEP_4_bn"));
        }
        if(getCallbackQueryButtonKey().equals("STEP_4_bn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("!Ponte el Gopro y enciendela  +40 de fama", "STEP_5_bn"));

        }
        if(getCallbackQueryButtonKey().equals("STEP_5_bn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("!Correr por el tejado, grabar con el Gopro¡ +40 de fama", "STEP_6_bn",
                            "!Atacar a otros gatos desde tu escondiste con el Gopro¡  +40 de fama", "STEP_6_bn",
                            "!Atacar  a otros perros con la Gopro¡ +40 de fama","STEP_6_bn"));
        }
        if(getCallbackQueryButtonKey().equals("STEP_6_bn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("!Romper la contarseña! +40 de fama","STEP_7_bn"));
        }
        if(getCallbackQueryButtonKey().equals("STEP_7_bn")) {
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("!Salir al patio¡", "STEP_8_bn"));
        }
        if(getCallbackQueryButtonKey().equals("STEP_8_bn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}