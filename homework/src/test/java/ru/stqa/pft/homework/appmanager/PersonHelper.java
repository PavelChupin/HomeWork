package ru.stqa.pft.homework.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.PersonData;
import ru.stqa.pft.homework.model.Persons;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void savePersonData() {
        //wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        click(By.xpath("//div[@id='content']/form/input[21]"));
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
        type(By.name("mobile"), personData.getMobilephone());
        /*
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(personData.getMobilephone());
        */
        type(By.name("email"), personData.getEmail());
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
            //if (personData.getGroup() != null) {
            //    List<WebElement> options = findElement(By.name("new_group")).findElements(By.xpath(".//option[normalize-space(.) = " + Quotes.escape(personData.getGroup()) + "]"));
            //    if (options.size() == 0) { /*Если группа с заданным именем не найдена, то добавим в группу по умолчанию*/
            //        personData.setGroup("[none]");
            //groupHelper.create(new GroupData(personData.getGroup(),personData.getGroup(),personData.getGroup()));
            //    }
            new Select(findElement(By.name("new_group"))).selectByVisibleText(personData.getGroup());
            //}
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

        //type(By.name("address2"), personData.getAddress2());
        /*
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).sendKeys(personData.getAddress2());
        */
        //type(By.name("phone2"), personData.getPhone2());
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

    public void create(PersonData personData, boolean b) {
        navigationHelper.gotoAddNewPage();
        if (personData.getGroup() != null) { /*если передается наименование группы то проверим ее на существования*/
            List<WebElement> options = findElement(By.name("new_group")).findElements(By.xpath(".//option[normalize-space(.) = " + Quotes.escape(personData.getGroup()) + "]"));
            if (options.size() == 0) { /*Если группа с заданным именем не найдена, то добавим такую группу*/
                //groupHelper.create(new GroupData(personData.getGroup(), personData.getGroup(), personData.getGroup()));
                groupHelper.create(new GroupData().withName(personData.getGroup()).withHeader(personData.getGroup()).withFooter(personData.getGroup()));
                navigationHelper.gotoAddNewPage();
            }
        }
        fillPersonForm(personData, b);
        savePersonData();
        navigationHelper.homePage();
    }

    public void modify(PersonData person) {
        //Выбрать кнкретную запись
        selectPersonById(person.getId());
        //Так как кнопок редактирования тоже несколько, то нужно нажать правильную
        initPersonModificationById(person.getId());
        fillPersonForm(person, false);
        submitPersonModification();
        navigationHelper.homePage();
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
    public Persons all() {
        Persons personDataList = new Persons();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> elementList = element.findElements(By.tagName("td"));
            String firstName = elementList.get(2).getText();
            String lastName = elementList.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //PersonData personData = new PersonData(id, firstName, null, lastName, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
            personDataList.add(new PersonData().withId(id).withFirstname(firstName).withLastname(lastName));
        }
        return personDataList;
    }


    public void delete(PersonData person) {
        selectPersonById(person.getId());
        deleteSelectedPerson();
        alertWindowOk();
        navigationHelper.homePage();
    }

    public void selectPersonById(int id) {
        //wd.findElement(By.name("selected[]")).click();
        //click(By.name("selected[]"));
        //wd.findElements(By.name("selected[]")).get(index).click();
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
}
