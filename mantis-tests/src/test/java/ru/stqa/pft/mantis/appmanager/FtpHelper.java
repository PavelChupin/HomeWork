package ru.stqa.pft.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Summoner on 04.05.2017.
 */
public class FtpHelper {
    private final ApplicationManager app;
    private FTPClient ftp;

    public FtpHelper(ApplicationManager app){
        this.app = app;
        ftp = new FTPClient();
    }

    public void upload(File file, String target, String backup) throws IOException {
        //Устанавливаем коннект до сервера
        ftp.connect(app.getProperty("ftp.host"));
        //Ввести логин и пароль
        ftp.login(app.getProperty("ftp.login"),app.getProperty("ftp.password"));
        //Удаляем копию
        ftp.deleteFile(backup);
        //Переименовываем файл
        ftp.rename(target,backup);
        //Тех. метод
        ftp.enterLocalPassiveMode();
        //Читаем из локального файла и передаем на удаленный сервер
        ftp.storeFile(target, new FileInputStream(file));
        //Разрыв соединения
        ftp.disconnect();
    }

    public void restore(String backup, String target) throws IOException {
        //Устанавливаем коннект до сервера
        ftp.connect(app.getProperty("ftp.host"));
        //Ввести логин и пароль
        ftp.login(app.getProperty("ftp.login"),app.getProperty("ftp.password"));

        ftp.deleteFile(target);
        ftp.rename(backup,target);
        ftp.disconnect();
    }
}
