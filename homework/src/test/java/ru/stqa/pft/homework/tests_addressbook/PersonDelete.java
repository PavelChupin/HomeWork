package ru.stqa.pft.homework.tests_addressbook;

import org.testng.annotations.Test;

public class PersonDelete extends TestBase {

    
    @Test
    public void deletePerson() {
        app.getNavigationHelper().gotoHomePage();
        app.getPersonHelper().selectPerson();
        app.getPersonHelper().deleteSelectedPerson();
        app.getPersonHelper().alertWindowOk();
    }

}
