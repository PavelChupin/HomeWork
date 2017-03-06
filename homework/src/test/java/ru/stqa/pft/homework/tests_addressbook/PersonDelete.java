package ru.stqa.pft.homework.tests_addressbook;

import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;


import java.util.List;

public class PersonDelete extends TestBase {

    public PersonDelete(){
        super(BrowserType.IE);
    }

    @Test
    public void deletePerson() {
        if (! app.getPersonHelper().isTherePersone()){
            app.getPersonHelper().insertPerson(new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "","test1"),true);
        }
        app.getNavigationHelper().gotoHomePage();

        List<PersonData> beforePersonDataList = app.getPersonHelper().getPersoneDataList();
        app.getPersonHelper().selectPerson(beforePersonDataList.size() - 1);
        app.getPersonHelper().deleteSelectedPerson();
        app.getPersonHelper().alertWindowOk();
        app.getNavigationHelper().gotoHomePage();
        List<PersonData> afterPersonDataList = app.getPersonHelper().getPersoneDataList();

        Assert.assertEquals(afterPersonDataList.size(), beforePersonDataList.size() - 1);

        beforePersonDataList.remove(beforePersonDataList.size() - 1);

        Assert.assertEquals(afterPersonDataList, beforePersonDataList);
    }

}
