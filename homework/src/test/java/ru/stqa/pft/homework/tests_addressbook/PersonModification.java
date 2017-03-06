package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

/**
 * Created by Summoner on 27.02.2017.
 */
public class PersonModification extends TestBase {

    public PersonModification(){
        super(BrowserType.CHROME);
    }

    @Test
    public void modificationPerson(){
        if (! app.getPersonHelper().isTherePersone()){
            app.getPersonHelper().insertPerson(new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "", "test"),true);
        }
        app.getNavigationHelper().gotoHomePage();
        app.getPersonHelper().selectPerson(0);
        app.getPersonHelper().initPersonModification();
        
        app.getPersonHelper().fillPersonForm(new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "", null),false);
        app.getPersonHelper().submitPersonModification();
        app.getNavigationHelper().gotoHomePage();
    }
}
