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
        PersonData personData = new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "","1234");
        app.getPersonHelper().insertPerson(personData,true);
    }

}
