package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.util.List;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Summoner on 03.05.2017.
 */
public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void startMailServer(){
        //Запуск почтового сервера
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        //Вместо %s будет подставлено время из значения пременной now
        String email = String.format("user%s@localhost.localdomain", now);
        String user = String.format("user%s",now);
        String password = "password";
        app.registration().start(user, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2,10000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
        assertTrue(app.newSession().login(user,password));
    }


    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        //Остановка почтового сервера
        app.mail().stop();
    }
}
