package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.Groups;
import ru.stqa.pft.homework.model.PersonData;
import ru.stqa.pft.homework.model.Persons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Summoner on 27.02.2017.
 */
public class PersonHelper extends HelperBase {
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    //private FirefoxDriver wd;

    public PersonHelper(WebDriver wd, GroupHelper groupHelper, NavigationHelper navigationHelper) {
        super(wd);
        this.groupHelper = groupHelper;
        this.navigationHelper = navigationHelper;
    }

    public void removeOfGroup() {
        click(By.name("remove"));
    }

    public void savePersonData() {
        //wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void addToGroupPersonData() {
        click(By.name("add"));
    }

    public void fillPersonForm(PersonData personData, boolean insert) {
        type(By.name("firstname"), personData.getFirstname());
        /*wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(personData.getFirstname());
        */
        //type(By.name("middlename"), personData.getMiddlename());
        /*
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(personData.getMiddlename());
        */
        type(By.name("lastname"), personData.getLastname());
        /*
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).sendKeys(personData.getLastname());
        */
        type(By.name("nickname"), personData.getNickname());

        //Вариант добавления фото мой
        type(By.name("photo"), personData.getPhoto().getAbsolutePath()); //Передаем обсолютный путь к файлу
        //Вариант добавления из Лекции
        //attach(By.name("photo"),personData.getPhoto());

        /*
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(personData.getNickname());
        */
        //type(By.name("title"), personData.getTitle());
        /*
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).sendKeys(personData.getTitle());
        */
        //type(By.name("company"), personData.getCompany());
        /*
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).sendKeys(personData.getCompany());
        */
        type(By.name("address"), personData.getAddress());
        /*
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(personData.getAddress());
        */
        //type(By.name("home"), personData.getHome());
        /*
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).sendKeys(personData.getHome());
        */
        type(By.name("home"), personData.getHomephone());
        type(By.name("mobile"), personData.getMobilephone());
        type(By.name("work"), personData.getWorkphone());
        /*
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(personData.getMobilephone());
        */
        type(By.name("email"), personData.getEmail());
        type(By.name("email2"), personData.getEmail2());
        type(By.name("email3"), personData.getEmail3());
        /*
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(personData.getEmail());
        */
        //type(By.name("email2"), personData.getEmail2());
        /*
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).sendKeys(personData.getEmail2());
        */
        //type(By.name("email3"), personData.getEmail3());
        /*
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).sendKeys(personData.getEmail3());
        */
        //type(By.name("homepage"), personData.getHomepage());
        /*
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).sendKeys(personData.getHomepage());
        */
        if (!findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
            findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
        }
        if (!findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
            findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).click();
        }
        if (!findElement(By.xpath("//div[@id='content']/form/select[1]//option[12]")).isSelected()) {
            findElement(By.xpath("//div[@id='content']/form/select[1]//option[12]")).click();
        }
        if (!findElement(By.xpath("//div[@id='content']/form/select[1]//option[12]")).isSelected()) {
            findElement(By.xpath("//div[@id='content']/form/select[1]//option[12]")).click();
        }
        if (!findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).isSelected()) {
            findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).click();
        }
        if (!findElement(By.xpath("//div[@id='content']/form/select[1]//option[13]")).isSelected()) {
            findElement(By.xpath("//div[@id='content']/form/select[1]//option[13]")).click();
        }
        findElement(By.name("byear")).click();
        if (!findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).click();
        }
        //type(By.name("byear"), personData.getByear());
        /*
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(personData.getByear());
        */
        if (!findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).isSelected()) {
            findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).click();
        }
        if (!findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).isSelected()) {
            findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).click();
        }
        //type(By.name("ayear"), personData.getAyear());
        /*
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).sendKeys(personData.getAyear());
        */
       /* if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).click();
        }*/
        if (insert) {
            if (personData.getGroups().size() > 0) {
                Assert.assertTrue(personData.getGroups().size() == 1);
                //if (personData.getGroup() != null) {
                //    List<WebElement> options = findElement(By.name("new_group")).findElements(By.xpath(".//option[normalize-space(.) = " + Quotes.escape(personData.getGroup()) + "]"));
                //    if (options.size() == 0) { /*Если группа с заданным именем не найдена, то добавим в группу по умолчанию*/
                //        personData.setGroup("[none]");
                //groupHelper.create(new GroupData(personData.getGroup(),personData.getGroup(),personData.getGroup()));
                //    }
                new Select(findElement(By.name("new_group"))).selectByVisibleText(String.valueOf(personData.getGroups().iterator().next().getName()));
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

        //type(By.name("address2"), personData.getAddress2());
        /*
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).sendKeys(personData.getAddress2());
        */
        //type(By.name("phone2"), personData.getPhone2());

        type(By.name("phone2"), personData.getPhone2());
        /*
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).sendKeys(personData.getPhone2());
        */

    }

    /*
        public void selectPerson(int index) {
            //wd.findElement(By.name("selected[]")).click();
            //click(By.name("selected[]"));
            wd.findElements(By.name("selected[]")).get(index).click();
        }
    */
    public void deleteSelectedPerson() {
        //wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectPersonById(int id) {
        //wd.findElement(By.name("selected[]")).click();
        //click(By.name("selected[]"));
        //wd.findElements(By.name("selected[]")).get(index).click();
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void alertWindowOk() {
        wd.switchTo().alert().accept();
    }

    /*
        public void initPersonModification(int index) {
            //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
            //wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).get(index).click();
            List<WebElement> elements = wd.findElements(By.name("entry"));
            String id = elements.get(index).findElement(By.tagName("input")).getAttribute("value");
            wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
            //wd.findElement(By.cssSelector("a[href='edit.php?id=80']")).click();
        }
    */
    public void submitPersonModification() {
        //click(By.xpath("//div[@id='content']/form[1]/input[22]"));
        //click(By.xpath("//div/div[4]/form[1]/input[22]"));
        click(By.name("update"));
    }

    public void initPersonModificationById(int id) {
        //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
        //wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).get(index).click();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        //String id = elements.get(index).findElement(By.tagName("input")).getAttribute("value");
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
        //wd.findElement(By.cssSelector("a[href='edit.php?id=80']")).click();
    }

    /*
        public void delete(int index) {
            selectPerson(index);
            deleteSelectedPerson();
            alertWindowOk();
            navigationHelper.homePage();
        }
    */
    public boolean isTherePersone() {
        return isElementPresent(By.name("selected[]"));
    }

    /*
        public List<PersonData> list() {
            List<PersonData> personDataList = new ArrayList<PersonData>();
            List<WebElement> elements = wd.findElements(By.name("entry"));
            for(WebElement element : elements){
                List<WebElement> elementList = element.findElements(By.tagName("td"));
                String firstName = elementList.get(2).getText();
                String lastName = elementList.get(1).getText();
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                //PersonData personData = new PersonData(id, firstName, null, lastName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                personDataList.add(new PersonData().withId(id).withFirstname(firstName).withLastname(lastName));
            }
            return personDataList;
        }
    */
    //Переменная для хранения кеш списка контактов
    private Persons personCache = null;

    public Persons all() {
        //Проверим переменную кеша на заполненость, если она заполнена, то вернем копию ссылки на список групп и выйдем из метода получения списка
        if (personCache != null) {
            return new Persons(personCache);
        }
        //Объявим список кеша
        personCache = new Persons();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> elementList = element.findElements(By.tagName("td"));
            String firstName = elementList.get(2).getText();
            String lastName = elementList.get(1).getText();
            String allPhones = elementList.get(5).getText();
            //Получим и разрежем строку телефонов
            //String[] phones = elementList.get(5).getText().split("\n");

            //Получим адресс
            String address = elementList.get(3).getText();
            //Получим почтовый адресс
            //String email = elementList.get(4).findElement(By.tagName("a")).getText();
            //Получим почтовый адресс полностью
            String emails = elementList.get(4).getText();

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //PersonData personData = new PersonData(id, firstName, null, lastName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
            //Добавим в кеш элемент списка контакта
           /* personCache.add(new PersonData()
                    .withId(id).withFirstname(firstName).withLastname(lastName).withHomephone(phones[0]).withMobilephone(phones[1])
                    .withWorkphone(phones[2]).withPhone2(phones[3]).withAddress(address).withEmail(email));*/
           /*String s;
           if (phones.length < 3){
               s = "";
           }else{
               s = phones[3];
           }
            personCache.add(new PersonData()
                    .withId(id).withFirstname(firstName).withLastname(lastName).withAllPhones(allPhones).withAddress(address).withAllEmail(emails).withPhone2(s));
                    */
            personCache.add(new PersonData()
                    .withId(id).withFirstname(firstName).withLastname(lastName).withAllPhones(allPhones).withAddress(address).withAllEmail(emails));
        }
        //Вернем ссылку на кеш списка контактов
        //return personDataList;
        return new Persons(personCache);
    }


    public void delete(PersonData person) {
        selectPersonById(person.getId());
        deleteSelectedPerson();
        alertWindowOk();
        //Так как состав контактов изменился, то кеш необходимо обнулить
        personCache = null;
        navigationHelper.homePage();
    }

    public void create(PersonData personData, boolean b) {
        navigationHelper.gotoAddNewPage();
        //if (personData.getGroup() != null) { /*если передается наименование группы то проверим ее на существования*/
        //    List<WebElement> options = findElement(By.name("new_group")).findElements(By.xpath(".//option[normalize-space(.) = " + Quotes.escape(personData.getGroup()) + "]"));
        //   if (options.size() == 0) { /*Если группа с заданным именем не найдена, то добавим такую группу*/
        //groupHelper.create(new GroupData(personData.getGroup(), personData.getGroup(), personData.getGroup()));
        //      groupHelper.create(new GroupData().withName(personData.getGroup()).withHeader(personData.getGroup()).withFooter(personData.getGroup()));
        //     navigationHelper.gotoAddNewPage();
        //}
        //}
        fillPersonForm(personData, b);
        savePersonData();
        //Так как состав контактов изменился, то кеш необходимо обнулить
        personCache = null;
        navigationHelper.homePage();
    }

    public void modify(PersonData person) {
        //Выбрать кнкретную запись
        selectPersonById(person.getId());
        //Так как кнопок редактирования тоже несколько, то нужно нажать правильную
        initPersonModificationById(person.getId());
        fillPersonForm(person, false);
        submitPersonModification();
        //Так как состав контактов изменился, то кеш необходимо обнулить
        personCache = null;
        navigationHelper.homePage();
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    //поиск значений на странице редактирования
    public PersonData infoFromEditForm(PersonData person) {
        //Перейдти на страницу редактирования контакта по идентификатору контакта
        initPersonModificationById(person.getId());
        //Начитываем параметры
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        //String nickName = wd.findElement(By.name("nickname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String homePhone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");
        //Возвращаемся на предыдущею страницу
        wd.navigate().back();
        //Возвращаем копию ссылки на объект с начитанными параметрами
        return new PersonData()
                .withId(person.getId()).withFirstname(firstName).withLastname(lastName).withMobilephone(mobilePhone)
                .withWorkphone(workPhone).withHomephone(homePhone).withPhone2(phone2).withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    //поиск значений на странице информации по контакту
    public PersonData infoFromDetailForm(PersonData person) {
        //Перейдти на страницу редактирования контакта по идентификатору контакта
        initPersonDetailById(person.getId());
        //Начитываем параметры
        String allPersonData = wd.findElement(By.id("content")).getText();
        //Возвращаемся на предыдущею страницу
        wd.navigate().back();
        //Возвращаем копию ссылки на объект с начитанными параметрами
        return new PersonData().withAllPersonData(allPersonData);
    }

    private void initPersonDetailById(int id) {
        List<WebElement> elements = wd.findElements(By.name("entry"));
        //String id = elements.get(index).findElement(By.tagName("input")).getAttribute("value");
        wd.findElement(By.cssSelector("a[href='view.php?id=" + id + "']")).click();

    }

    public void groupSelectedForInsertPerson(GroupData insertGroup) {
/*        WebElement element = wd.findElement(By.name("to_group"));
        List<WebElement> elements = element.findElements(By.tagName("option"));
        for (WebElement elem : elements){
            String el = elem.getAttribute("value");

            if (Integer.valueOf(el) == chooseGroup.getId()){
                click();
                return ;
            }
        }
        */
        click(By.xpath("//select[@name='to_group']//option[@value='" + insertGroup.getId() + "']"));
    }


    public void deletionPersonOfGroup(PersonData person) {
        navigationHelper.homePage();
        //Выбрать в лукапе групп группу из которой будем удалять контакт
        deletePersonOfGroup(person.getGroups().iterator().next().getId());
        //Выбрать контакт
        selectPersonById(person.getId());
        //Нажмем кнопку удалить
        removeOfGroup();
        navigationHelper.homePage();
    }

    public void deletePersonOfGroup(int id) {
            click(By.xpath("//select[@name='group']//option[@value='" + id + "']"));
        }

    public void chooseGroup() {
        click(By.xpath("//select[@name='group']//option[@value='" + "" + "']"));
    }

    public void insertPersonToGroup(PersonData insertPersonGroup, GroupData group) {
        //Добавление контакта в группу
        //Переход на главую страницу контактов
        navigationHelper.homePage();
        //Выбор в лукапе групп значение ALL
        chooseGroup();
        //Выбрать контакт
        selectPersonById(insertPersonGroup.getId());
        //Выбрать в лукапе группу в которую будем добавлять контакт
        groupSelectedForInsertPerson(group);
        //Нажать кнопку добавить
        addToGroupPersonData();
        navigationHelper.homePage();
    }
}
