package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.User;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Summoner on 03.05.2017.
 */
public class RegistrationHelper extends HelperBase {
    //private final ApplicationManager app;
    //private WebDriver wd;

    public RegistrationHelper(ApplicationManager app) {
        super(app);
        //this.app = app;
        //wd = app.getDriver();
    }

    public void startRegistration(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        //Вводим логин и пароль
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.cssSelector("input[value='Signup']"));

    }

    public void startPage(String usename, String password) {
        //Переходим на стартовую страницу
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        //Вводим логин и пароль
        type(By.name("username"), usename);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));

    }
    public void finish(String confirmationLink, String password) {
        //Переходм по ссылке полученной в письме
        wd.get(confirmationLink);
        //Вводим логин и пароль
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }

    public void registrationUser(User user) throws IOException, MessagingException {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php"); //Переход на страницу регистрации
        startRegistration(user.getUsername(), user.getEmail());
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        //String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
        finish(findConfirmationLink(mailMessages, user.getEmail()), user.getPassword());

    }



    public void replasePassword(User user, String password) throws MessagingException, IOException {
        startPage(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        goToManageUsersPage();
        selectUser(user.getId());
        clickButtonResetPassword();

        //При смене пароля письмо приходит только одно
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);

        //Проходим по присланной на почту ссылке
        finish(findConfirmationLink(mailMessages, user.getEmail()), password);

    }

    public void goToManageUsersPage() {
        wd.findElement(By.cssSelector("a[href='/mantisbt-1.2.19/manage_user_page.php']")).click();
    }

    public void selectUser(int id) {
        wd.findElement(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + id + "']")).click();
    }

    public void clickButtonResetPassword() {
        click(By.cssSelector("input[value='Reset Password']"));
    }
}
