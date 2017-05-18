package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Summoner on 18.05.2017.
 */
public class ReplasePasswordHelper extends HelperBase {

    public ReplasePasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String usename, String password) {
        //Переходим на стартовую страницу
        //wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        //Вводим логин и пароль
        type(By.name("username"),usename);
        type(By.name("password"),password);
        click(By.cssSelector("input[value='Login']"));

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

    public void finishReplasePassword(String confirmationLink, String password) {
        //Переходм по ссылке полученной в письме
        wd.get(confirmationLink);
        //Вводим логин и пароль
        type(By.name("password"),password);
        type(By.name("password_confirm"),password);

        //Нажмем кнопку изменения пароля
        click(By.cssSelector("input[value='Update User']"));
    }
}
