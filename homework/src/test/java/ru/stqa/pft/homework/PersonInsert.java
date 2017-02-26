package ru.stqa.pft.homework;

import org.testng.annotations.Test;

public class PersonInsert extends TestBase {

    @Test
    public void insertPerson() {
        //wd.findElement(By.id("nav")).click();
        gotoAddNewPage();
        fillPersonForm(new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", ""));
        savePersonData();
    }

}
