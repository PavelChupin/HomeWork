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
    public void startMailServer(){
        //Запуск почтового сервера
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        //Новый пароль пользователя
        String newPassword = "password";
        //Получим из базы список пользователей используем JDBC, Hibernate почемуто не пожет установить коннект
        List<User> users = app.db("JDBC").usersJDBC();

        System.out.println(users);
        //Найдем пользователя у которого будем изменять пароль
        User replaseUser = users.iterator().next();

        //System.out.println(users);
        app.replasePassword().start(app.getProperty("web.adminLogin"),app.getProperty("web.adminPassword"));
        app.replasePassword().goToManageUsersPage();
        app.replasePassword().selectUser(replaseUser.getId());
        app.replasePassword().clickButtonResetPassword();

        //При смене пароля письмо приходит только одно
        List<MailMessage> mailMessages = app.mail().waitForMail(1,10000);

        //String confirmationLink = findConfirmationLink(mailMessages, replaseUser.getEmail());
        //System.out.println(confirmationLink);
        //Проходим по присланной на почту ссылке
        app.replasePassword().finishReplasePassword(findConfirmationLink(mailMessages, replaseUser.getEmail()),newPassword);
        assertTrue(app.newSession().login(replaseUser.getUsername(),newPassword));
    }


    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        //Остановка почтового сервера
        app.mail().stop();
    }
}
