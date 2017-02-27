package ru.stqa.pft.homework.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

/**
 * Created by Summoner on 27.02.2017.
 */
public class PersonModification extends TestBase {
    @Test
    public void modificationPerson(){
        app.getNavigationHelper().gotoHomePage();
        app.getPersonHelper().selectPerson();
        app.getPersonHelper().initPersonModification();
        app.getPersonHelper().fillPersonForm(new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", ""));
        app.getPersonHelper().submitPersonModification();
        //app.getPersonHelper().alertWindowOk();
        app.getNavigationHelper().gotoHomePage();
    }
}
