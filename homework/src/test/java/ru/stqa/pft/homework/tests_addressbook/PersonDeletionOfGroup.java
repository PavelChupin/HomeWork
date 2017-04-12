package ru.stqa.pft.homework.tests_addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.PersonData;
import ru.stqa.pft.homework.model.Persons;

import java.io.File;

/**
 * Created by Summoner on 11.04.2017.
 */
public class PersonDeletionOfGroup extends TestBase {
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

        //Сохраним удаляемый из группы контакт контакт
        PersonData person = app.db().persons().iterator().next();
        //Проверим включен ли контакт в какую нибуть группу
        if (person.getGroups().size() != 0) {
            //Проверим включен ли данный контакт в  группу из которой будем удалять. Если не включен добавим его в эту группы.
            if (person.getGroups().iterator().next().getId() != app.db().groups().iterator().next().getId()) {
                app.persone().insertPersonToGroup(person,app.db().groups().iterator().next());
            }
        }else
            //Если контакт не ключен в какую нибуть группу его необходимо включить в группу из которой будем удалять.
            {
                app.persone().insertPersonToGroup(person,app.db().groups().iterator().next());
        }
    }

    @Test
    public void testPersonDeletionOfGroup() {
        Persons beforePersonData = app.db().persons();
        //Удаление контакта в группу
        app.goTo().homePage();
        //Выбор контакта удаляемого из группы
        PersonData insertPersonGroup = beforePersonData.iterator().next();
        //Выбрать в лукапе групп, группу из которой нужно удалить контакт
        app.persone().deletePersonOfGroup(insertPersonGroup.getGroups().iterator().next().getId());
        //Выбрать контакт
        app.persone().selectPersonById(insertPersonGroup.getId());
        //Нажмем кнопку удалить
        app.persone().removeOfGroup();
        app.goTo().homePage();

    }
}
