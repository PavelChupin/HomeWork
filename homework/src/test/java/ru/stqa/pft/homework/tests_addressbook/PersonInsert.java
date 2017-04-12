package ru.stqa.pft.homework.tests_addressbook;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.Groups;
import ru.stqa.pft.homework.model.PersonData;
import ru.stqa.pft.homework.model.Persons;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonInsert extends TestBase {
    /*
        public PersonInsert(){
            super(BrowserType.FIREFOX);
        }
    */
    //Создадим метод провайдер тестовых данных через Xml
    @DataProvider
    public Iterator<Object[]> validPersonsFromXml() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();

        /*
        List<Object[]> list = new ArrayList<Object[]>();
        //Простой метод генерации данных
        File photo = new File("src/test/resources/stru.png");
        list.add(new Object[]{new PersonData()
                .withFirstname("Pavel1").withLastname("Chupin1").withNickname("PavelChupin1")
                .withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899")
                .withEmail("pavel.chupin@gmail.com").withGroup("test").withPhoto(photo)});
        list.add(new Object[]{new PersonData()
                .withFirstname("Pavel2").withLastname("Chupin2").withNickname("PavelChupin2")
                .withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899")
                .withEmail("pavel.chupin@gmail.com").withGroup("test").withPhoto(photo)});
        list.add(new Object[]{new PersonData()
                .withFirstname("Pavel3").withLastname("Chupin3").withNickname("PavelChupin3")
                .withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899")
                .withEmail("pavel.chupin@gmail.com").withGroup("test").withPhoto(photo)});
        return list.iterator();
        */
/*
        //Прочитаем тестовые данные из файла CSV
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/persons.csv")));
        String line = reader.readLine();
        while (line != null) {
            //Методом split дробим строку по регулярному выражению
            String[] split = line.split(";");
            list.add(new Object[]{new PersonData().withFirstname(split[0]).withLastname(split[1]).withNickname(split[2]).withAddress(split[3])
                    .withMobilephone(split[4]).withEmail(split[5]).withGroup(split[6]).withPhoto(new File(split[7]))});
            line = reader.readLine();
        }
        return list.iterator();
*/
        //Получение тестовых данных из файла XML используем библиотеку com.thoughtworks.xstream:xstream:1.4.9
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/persons.xml")))){
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xStream = new XStream();
            xStream.processAnnotations(PersonData.class);
            List<PersonData> persons = (List<PersonData>) xStream.fromXML(xml);
            return persons.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
            //-----Конец начитки через xml
        }

    }

    //Создадим метод провайдер тестовых данных  Json
    @DataProvider
    public Iterator<Object[]> validPersonsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/persons.json")))){
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<PersonData> persons = gson.fromJson(json, new TypeToken<List<PersonData>>(){}.getType());
            return persons.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
            //-----Конец начитки через Json
        }

    }

    @Test(dataProvider = "validPersonsFromXml")
    public void insertPerson(PersonData personData) {
        Groups groups = app.db().groups();
        personData.inGroup(groups.iterator().next());
        /*if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData()
                    .withName("HomeGroup2").withFooter("HomeGroup2").withHeader("HomeGroup2"));
        }*/
        /*
        //Установим браузер в котором запускать тест
        app.setBrowser(BrowserType.FIREFOX);
        */
        app.goTo().homePage();
        //Меняем получение списка груп с начитки с интерфейса на начитку из базы
        //Persons beforePersonData = app.persone().all();
        Persons beforePersonData = app.db().persons();
        //-----------------------------------------
        //File currentDir = new File("."); //Точка текущая директория
        //currentDir.getAbsolutePath(); //Получить путь дирректории
        /*
        File photo = new File("src/test/resources/stru.png");
        PersonData personData = new PersonData()
                .withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin")
                .withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899")
                .withEmail("pavel.chupin@gmail.com").withGroup("test").withPhoto(photo);
         */
        /*
        PersonData personData = new PersonData()
                .withFirstname("Pavel").withLastname("Chupin").withNickname("PavelChupin")
                .withAddress("630089, Novosibirsk, B.Bogatkova 185").withHomephone("987564").withMobilephone("+79137382899")
                .withWorkphone("98756").withEmail("pavel.chupin@gmail.com").withEmail2("pavel.chupin@gmail.com").withEmail3("pavel.chupin@gmail.com")
                .withPhone2("66575").withGroup("test").withPhoto(new File("src/test/resources/stru.png"));
*/
        app.persone().create(personData, true);
        assertThat(app.persone().count(), equalTo(beforePersonData.size() + 1));

        //Меняем получение списка груп с начитки с интерфейса на начитку из базы
        //Persons afterPersonData = app.persone().all();
        Persons afterPersonData = app.db().persons();
        //--------------------------------------------
        //Проверка совпадения длин списков
        //assertEquals(afterPersonDataList.size(), beforePersonData.size() + 1);
        //assertThat(afterPersonData.size(), equalTo(beforePersonData.size() + 1));
        //Найдем и установим новый индекс для нового элемента
       /* int max = 0;
        for (PersonData p : afterPersonDataList){
            if(p.getId() > max){
                max = p.getId();
            }
        }*/
        //Добавим хзначение максимального индекса в новый контакт
        // Comparator<? super PersonData> byId = (Comparator<PersonData>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
        // int max1 = afterPersonDataList.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
        //personData.setId(afterPersonDataList.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());

        //Присвоим вновь созданной группе новый идентификатор. Найдем максимальный идентификатор
        //personData.withId(afterPersonData.stream().mapToInt((p) -> p.getId()).max().getAsInt());

        //Добавим в первоночальный список нвый добавленный контакт
        //beforePersonData.add(personData);

        //Упорядочим списки
        //Comparator<? super PersonData> byId = (p1, p2) -> Integer.compare(p1.getId(), p2.getId());
        //beforePersonData.sort(byId);
        //afterPersonDataList.sort(byId);

        //Сравнение списков делаем не по упорядоченному списку, для этого преобразуем упорядочный список в множество
        //Assert.assertEquals(new HashSet<Object>(afterPersonDataList), new HashSet<Object>(beforePersonData));

        //Сравним упорядочные списки
        //assertEquals(beforePersonData, afterPersonDataList);
        assertThat(afterPersonData, equalTo(
                beforePersonData.withAdded(personData.withId(afterPersonData.stream().mapToInt((p) -> p.getId()).max().getAsInt()))));

        verifyPersonListInUI();
    }

    @Test(enabled = false)
    public void insertBadPerson() {
        /*
        //Установим браузер в котором запускать тест
        app.setBrowser(BrowserType.FIREFOX);
        */
        app.goTo().homePage();
        Persons beforePersonData = app.persone().all();
        PersonData personData = new PersonData()
                .withFirstname("Pavel'").withLastname("Chupin'").withNickname("PavelChupin'").withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899").withEmail("pavel.chupin@gmail.com")/*.withGroup("test")*/;
        app.persone().create(personData, true);
        assertThat(app.persone().count(), equalTo(beforePersonData.size()));
        Persons afterPersonData = app.persone().all();
        assertThat(afterPersonData, equalTo(beforePersonData));
    }

    @Test(enabled = false)
    public void testCurrentDir() {
        File currentDir = new File("."); //Точка текущая директория
        //currentDir.getAbsolutePath(); //Получить путь дирректории
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/stru.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists()); //Метод проверки наличия файла по пути к нему
    }

}
