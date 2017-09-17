package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.User;

import javax.mail.MessagingException;
import java.awt.*;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Summoner on 03.05.2017.
 */
public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void startMailServer() {
        //Запуск почтового сервера
        app.mail().start();

    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        //Вместо %s будет подставлено время из значения пременной now
        String email = String.format("user%s@localhost.localdomain", now);
        String username = String.format("user%s", now);
        String password = "password";
        User user = new User().withUsername(username).withEmail(email).withPassword(password);
        app.registration().registrationUser(user);
        assertTrue(app.newSession().login(user.getUsername(), user.getPassword()));
    }



    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {

        //Остановка почтового сервера
        app.mail().stop();

    }
}
