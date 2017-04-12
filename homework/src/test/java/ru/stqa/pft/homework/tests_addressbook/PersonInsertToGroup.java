package ru.stqa.pft.homework.tests_addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.PersonData;
import ru.stqa.pft.homework.model.Persons;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Summoner on 10.04.2017.
 */
public class PersonInsertToGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        //Предусловие наличие контакта в базе
        if (app.db().persons().size() == 0) {
            app.goTo().homePage();
            app.persone().create(new PersonData()
                    /*.withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com").withGroup("test"), true);*/
                    .withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin")
                    .withAddress("630089, Novosibirsk, B.Bogatkova 185").withHomephone("987564").withMobilephone("+79137382899")
                    .withWorkphone("98756").withEmail("pavel.chupin@gmail.com").withEmail2("pavel.chupin@gmail.com").withEmail3("pavel.chupin@gmail.com")
                    .withPhone2("66575")/*.withGroup("test")*/.withPhoto(new File("src/test/resources/stru.png")), true);
        }

        //Предусловия наличия групп в базе
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData()
                    .withName("HomeGroup2").withFooter("HomeGroup2").withHeader("HomeGroup2"));
        }

        //Сохраним добавляемый в группу контакт
        PersonData person = app.db().persons().iterator().next();
        //Проверим не включен ли контак в какую нибуть группу
        if (person.getGroups().size() != 0){
            //Проверим не включен ли данный контакт в добавляемую группу. Если включен удалим его из группы.
            if (person.getGroups().iterator().next().getId() == app.db().groups().iterator().next().getId()) {
                app.persone().deletionPersonOfGroup(person);
            }
        }
    }

    @Test
    public void testPersonInsertToGroup() {
        //Получим список контактов из базы
        Persons beforePersonData = app.db().persons();
        //Выбор контакта который будем включать в группу
        PersonData insertPersonToGroup = beforePersonData.iterator().next();
        //Выбрать группу в которую добавляем контакт
        GroupData group = app.db().groups().iterator().next();
        //Добавляем контакт в группу
        app.persone().insertPersonToGroup(insertPersonToGroup, group);

        Persons afterPersonData = app.db().persons();

        assertThat(app.persone().count(),equalTo(beforePersonData.size()));

        //Пробежать по первоначальному списку и добавить измененному контакту группу
        assertThat(afterPersonData, equalTo(beforePersonData));

        //
        //assertThat(afterPersonData, equalTo(beforePersonData.without(insertPersonGroup).withAdded(afterPersonData.iterator().next())));
    }

}
