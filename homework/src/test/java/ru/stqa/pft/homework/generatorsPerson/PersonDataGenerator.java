package ru.stqa.pft.homework.generatorsPerson;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.homework.model.PersonData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Summoner on 26.03.2017.
 */
public class PersonDataGenerator {

    //Аннотация библиотеки jcommander
    @Parameter(names = "-c", description = "Person count")
    public int count;
    //Аннотация библиотеки jcommander
    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        PersonDataGenerator generator = new PersonDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }

        generator.run();

        //Сохраним входные параметры количество контактов и путь к файлу
        //int count = Integer.parseInt(args[0]);
        //File file = new File(args[1]);


    }

    private void run() throws IOException {
        //Метод генерации тестовых данных контакта
        List<PersonData> persons = generatePerson(count);
        //Метод сохранения сформированных данных в файл
        save(persons, new File(file));
    }

    private List<PersonData> generatePerson(int count) {
        List<PersonData> persons = new ArrayList<PersonData>();
        File photo = new File("src/test/resources/stru.png");
        for (int i = 0; i < count; i++) {
            /*
            new PersonData()
                .withFirstname("Pavel1").withLastname("Chupin1").withNickname("PavelChupin1")
                .withAddress("630089, Novosibirsk, B.Bogatkova 185").withMobilephone("+79137382899")
                .withEmail("pavel.chupin@gmail.com").withGroup("test").withPhote(photo)
            */
            persons.add(new PersonData().withFirstname(String.format("Pavel %s", i)).withLastname(String.format("Chupin %s", i)).withNickname(String.format("PavelChupin %s", i))
                    .withAddress(String.format("630089, Novosibirsk, B.Bogatkova 185 %s", i)).withMobilephone(String.format("+79137382899 %s", i))
                    .withEmail(String.format("pavel.chupin@gmail.com %s", i)).withGroup(String.format("test %s", i)).withPhoto(photo));
        }
        return persons;

    }

    private void save(List<PersonData> persons, File file) throws IOException {
        //System.out.println(new File(".").getAbsolutePath());
        //Откроем файл для возможности записи. Передадим путь к файлу конструктуру.
        //Может возникать исключение. Мы его ен перехватываем а перебрасываем на верхний уровень
        Writer writer = new FileWriter(file);

        //Запишим построчно сгенеренные данные из коллекции построчно
        for (PersonData person : persons) {
            //запись по формату и в конце строки перевод строки
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s\n", person.getFirstname(), person.getLastname(), person.getNickname(), person.getAddress(), person.getMobilephone()
                    , person.getEmail(), person.getGroup(), person.getPhoto().getAbsolutePath()));
        }
        //После записи закрыть файл. Так как явная запись в файл производиться в момент закрытия, а до этого все сохраняется в кеше.
        //Если этого не сделать запись в фаил не произайдет
        writer.close();
    }
}
