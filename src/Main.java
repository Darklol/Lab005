import Data.Invoker;
import Data.Receiver;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println(args[0]);

        Receiver receiver = new Receiver();

        Invoker invoker = new Invoker(receiver);

        try {
            receiver.getFile(args[0]);
        } catch (IOException  e) {
            System.out.println("Коллекция не была загружена.\n" +
                    "Возможные причины: файл по данному пути не найден, нет прав на чтение из директории. \n\n" +
                    "Запуск программы без данных из файла.");
        } catch (JsonSyntaxException e) {
            System.out.println("Коллекция не была загружена.\nОшибка чтения синтаксиса Json.\n" +
                    "Данные в файле не соответствуют данным коллекции.\n\n" +
                    "Запуск программы без данных из файла.\n");
        }

        while (true){
            invoker.input();
        }

    }
}
