import Data.Invoker;
import Data.Receiver;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

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
                    "Данные в файле не соответствуют данным коллекции, либо коллекция содержи два " +
                    "элемента с одинаковыми ключами.\n\n" +
                    "Запуск программы без данных из файла.\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Коллекци не была загружена.\n" +
                    "Отсутствуют аргументы командной строки.\n" +
                    "Запуск программы без данных из файла");
        }

        while (true){
            invoker.input();
        }

    }
}
