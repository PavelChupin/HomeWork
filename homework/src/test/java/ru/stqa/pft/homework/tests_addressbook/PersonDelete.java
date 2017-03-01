package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

public class PersonDelete extends TestBase {

    public PersonDelete(){
        super(BrowserType.IE);
    }

    @Test
    public void deletePerson() {
        //app.getNavigationHelper().gotoHomePage();
        if (! app.getPersonHelper().isTherePersone()){
            app.getNavigationHelper().gotoAddNewPage();
            app.getPersonHelper().insertPerson(new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "","test1"),true);
        }
        app.getNavigationHelper().gotoHomePage();
        app.getPersonHelper().selectPerson();
        app.getPersonHelper().deleteSelectedPerson();
        app.getPersonHelper().alertWindowOk();
    }

}
