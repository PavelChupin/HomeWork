package ru.stqa.pft.mantis.appmanager;


import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Summoner on 03.05.2017.
 */
public class HttpSession {
    private CloseableHttpClient httpClient;
    private ApplicationManager app;

    public HttpSession(ApplicationManager app) {
        this.app = app;
        //Создание новой сессии для работы по протоколу HTTP
        httpClient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    }

    //Метод для выполнения логина
    public boolean login(String username, String password) throws IOException {
        //Адрес по которуму нужно отправить запрос для ввода логина
        //Формируем будущий запрос для отправки на сервер
        HttpPost post = new HttpPost(app.getProperty("web.baseUrl") + "/login.php");
        //Подготовка параметров запроса
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("secure_session", "on"));
        params.add(new BasicNameValuePair("return", "index.php"));
        //Заполняем подготовленные данные в сформированный ранее запрос
        post.setEntity(new UrlEncodedFormEntity(params));
        //Отправка запроса на сервер
        CloseableHttpResponse response = httpClient.execute(post);

        //Текст ответа от сервера
        String body = getTextForm(response);
        //Проверяем что в тексте страници содержиться нужный фрагмент
        return body.contains(String.format("<span class=\"italic\">%s</span>", username));

    }

    private String getTextForm(CloseableHttpResponse response) throws IOException {
        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }

    //Метод определяет какой пользователь залогинин и вошел в систему
    public boolean isLoggedInAs(String username) throws IOException{
        //Подготовили запрос на сервер
        HttpGet get = new HttpGet(app.getProperty("web.baseUrl") + "/index.php");
        //Выполняем запрос на сервер
        CloseableHttpResponse response = httpClient.execute(get);
        //Текст ответа от сервера
        String body = getTextForm(response);
        //Проверяем что в тексте страници содержиться нужный фрагмент
        return body.contains(String.format("<span class=\"italic\">%s</span>", username));
    }
}
