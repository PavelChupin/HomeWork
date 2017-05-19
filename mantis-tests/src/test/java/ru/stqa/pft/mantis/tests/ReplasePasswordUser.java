package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.User;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Summoner on 18.05.2017.
 */
public class ReplasePasswordUser extends TestBase {
    @BeforeMethod
    public void startMailServer() throws IOException, MessagingException {
        //Запуск почтового сервера
        app.mail().start();
        //Добавим пользователя если в базе нет ни одного
        if (app.db("JDBC").usersJDBC().size() == 0) {
            User user = new User().withUsername("user").withEmail("user@localhost.localdomain").withPassword("passworduser");
            app.registration().registrationUser(user);
        }

        //Очистим почту, чтобы ждать только одно письмо с подтверждением изменения пароля
        app.mail().deletionMessagesToMail();

    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        //Новый пароль пользователя
        String newPassword = "password";
        //Получим из базы список пользователей используем JDBC, Hibernate почемуто не пожет установить коннект
        List<User> users = app.db("JDBC").usersJDBC();
        //System.out.println(users);
        //Найдем пользователя у которого будем изменять пароль
        User replaseUser = users.iterator().next();
        //System.out.println(users);
        app.registration().replasePassword(replaseUser, newPassword);
        assertTrue(app.newSession().login(replaseUser.getUsername(), newPassword));
    }




    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        //Остановка почтового сервера
        app.mail().stop();
    }
}
