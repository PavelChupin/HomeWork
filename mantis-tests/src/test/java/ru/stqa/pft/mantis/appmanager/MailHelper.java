package ru.stqa.pft.mantis.appmanager;



import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;
import ru.stqa.pft.mantis.model.MailMessage;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Summoner on 18.05.2017.
 */
public class MailHelper {
    private ApplicationManager app;
    private final Wiser wiser;

    public MailHelper (ApplicationManager app){
        this.app = app;
        wiser = new Wiser();
    }

    public List<MailMessage> waitForMail(int count, long timeout) throws MessagingException, IOException{
        //Запоминаем текущее время
        long start = System.currentTimeMillis();
        //Проверяем что текущее время не привышает время старта + таймаут
        while (System.currentTimeMillis() < start + timeout){
            if (wiser.getMessages().size() >= count){
                return wiser.getMessages().stream().map((m) -> toModelMail(m)).collect(Collectors.toList());
            }
            try{
                //Период ожидания в цикле для каждого шага цикла
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //Ошибка если время ожидание истекло
        throw new Error("No mail :(");
    }

    public static MailMessage toModelMail(WiserMessage m){
        try{
            MimeMessage mm = m.getMimeMessage();
            return new MailMessage(mm.getAllRecipients()[0].toString(),(String) mm.getContent());
        }catch (MessagingException e){
            e.printStackTrace();
            return null;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public void start(){wiser.start();}

    public void stop(){wiser.stop();}
}
