package ru.stqa.pft.homework.tests_addressbook;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.PersonData;

import javax.swing.border.MatteBorder;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Summoner on 17.03.2017.
 */
public class PersonAddress extends TestBase{
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
    public void addressPerson(){
        app.goTo().homePage();
        PersonData person = app.persone().all().iterator().next();
        PersonData personInfoFromEditForm = app.persone().infoFromEditForm(person);
        //assertThat(person.getAddress(), equalTo(personInfoFromEditForm.getAddress()));
        //assertThat(person.getEmail(), equalTo(personInfoFromEditForm.getEmail()));


        assertThat(mergeAddress(person), equalTo(mergeAddress(personInfoFromEditForm)));
    }

    private String mergeAddress(PersonData person) {
            return Arrays.asList(person.getAddress(),person.getEmail())
                    .stream().filter((s) -> ! s.equals(""))/*.map(PersonPhone::cleaned)*/.collect(Collectors.joining("\n"));

    }
}
