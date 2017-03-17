package ru.stqa.pft.homework.tests_addressbook;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

/**
 * Created by Summoner on 17.03.2017.
 */
public class PersonAllData extends TestBase{

    @BeforeMethod  //Отрабатывает перед выполнением теста
    public void ensurePreconditions() {
        /*
        //Установим браузер в котором запускать тест
        app.setBrowser(BrowserType.CHROME);
        */
        app.goTo().homePage();
        if (app.persone().all().size() == 0) {
            app.persone().create(new PersonData()
                    .withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test"), true);
        }
    }

    @Test
    public void dataPersonAll(){
        app.goTo().homePage();
        PersonData person = app.persone().all().iterator().next();
        //PersonData personInfoFromEditForm = app.persone().infoFromDetailForm(person);
/*
        MatcherAssert.assertThat(person.getFirstname(), CoreMatchers.equalTo(personInfoFromEditForm.getFirstname()));
        MatcherAssert.assertThat(person.getLastname(), CoreMatchers.equalTo(personInfoFromEditForm.getLastname()));
        MatcherAssert.assertThat(person.getAllPhones(), CoreMatchers.equalTo(personInfoFromEditForm.getAllPhones()));
        MatcherAssert.assertThat(person.getAddress(), CoreMatchers.equalTo(personInfoFromEditForm.getAddress()));
        MatcherAssert.assertThat(person.getAllEmail(), CoreMatchers.equalTo(personInfoFromEditForm.getAllEmail()));
    */
    }

    public static String cleaned(String allPersonData){
        return allPersonData.replaceAll("\\s","");
    }
}
