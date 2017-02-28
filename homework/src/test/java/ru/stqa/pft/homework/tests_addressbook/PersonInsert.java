package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

public class PersonInsert extends TestBase {

    public PersonInsert(){
        super(BrowserType.FIREFOX);
    }

    @Test
    public void insertPerson() {
        //wd.findElement(By.id("nav")).click();
        app.getNavigationHelper().gotoAddNewPage();
        app.getPersonHelper().fillPersonForm(new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "","test1"),true);
        app.getPersonHelper().savePersonData();
    }

}