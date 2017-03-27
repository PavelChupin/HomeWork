package ru.stqa.pft.homework.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.homework.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Summoner on 25.03.2017.
 */
public class GroupDataGenerator {
    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    //Класс запускаемый поэтому делаем метод запуска
    public static void main(String[] args) throws IOException {

        GroupDataGenerator generator = new GroupDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
        //int count = Integer.parseInt(args[0]);
        //File file = new File(args[1]);


    }

    private void run() throws IOException {
        List<GroupData> groups = generateGroups(count);
        if (format.equals("csv")) {
            saveAsCsv(groups, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(groups, new File(file));
        } else {
            System.out.println("Unrecoqnized format " + format);
        }
    }

    //Метод для записи в файл в формате XML используем библиотеку com.thoughtworks.xstream:xstream:1.4.9
    private void saveAsXml(List<GroupData> groups, File file) throws IOException {
        XStream xStream = new XStream();
        //xStream.alias("group",GroupData.class);
        xStream.processAnnotations(GroupData.class);
        String xml = xStream.toXML(groups);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        //Закрыть файл
        writer.close();
    }

    private void saveAsCsv(List<GroupData> groups, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        //Запись данных в файл
        Writer writer = new FileWriter(file);
        for (GroupData group : groups) {
            //Запись производим по формату  %s;%s;%s
            writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        //Закрыть файл
        writer.close();
    }

    private List generateGroups(int count) {
        List<GroupData> groups = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            /*
            groups.add(new GroupData().withName(String.format("test %s", i)).withHeader(String.format("header %s", i))
                    .withFooter(String.format("footer %s", i)));
                    */
            groups.add(new GroupData().withName(String.format("test %s", i)).withHeader(String.format("header\n%s", i))
                    .withFooter(String.format("footer\n%s", i)));
        }
        return groups;
    }
}
