package Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле может быть null
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле может быть null


    public Person(){};
    public Person(String string) {
        boolean wrongInput = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя человека:");
        while (wrongInput) {
            this.name = (sc.nextLine());
            if (!name.equals("")) {
                wrongInput = false;
            } else {
                System.out.println("Поле не может быть пустым. Попробуйте ещё раз.");
            }
        }
        System.out.println();
        System.out.println("Введите день рождения человека (в формате dd-mm-yyyy): ");
        wrongInput = true;
        while (wrongInput) {
            String temp = sc.nextLine();
            if (temp.equals("")){
                wrongInput = false;
                break;
            }
//            String[] tempArray = temp.split("-");
            try {
//                if (tempArray.length == 3) {
//                    if (Integer.parseInt(tempArray[0]) < 31 && Integer.parseInt(tempArray[1]) < 13) {
                        birthday = new SimpleDateFormat("dd-MM-yyyy").parse(temp);
                        wrongInput = false;
//                    } else System.out.println("Неверный формат даты! Попробуйте ввести ещё раз. Формат даты: dd-mm-yyyy");
//                } else System.out.println("Неверный формат даты! Попробуйте ввести ещё раз. Формат даты: dd-mm-yyyy");
            } catch (ParseException | NumberFormatException e) {
                System.out.println("Неверный формат даты! Попробуйте ввести ещё раз. Формат даты: dd-mm-yyyy");
            }

        }
        System.out.println();
        System.out.println("Введите цвет глаз человека:");
        System.out.println("Доступные значения: BLACK, BLUE, YELLOW, ORANGE, BROWN, NULL");
        wrongInput = true;
        while (wrongInput) {
            String temp = sc.nextLine();
            if (!temp.equals("NULL")) {
                try {
                    eyeColor = Enum.valueOf(Color.class, temp);
                    wrongInput = false;
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка ввода! Попробуйте ввести ещё раз.");
                }
            } else {
                eyeColor = null;
                wrongInput = false;
            }
        }
        System.out.println();
        System.out.println("Введите цвет волос человека:");
        System.out.println("Доступные значения: BLACK, BLUE, YELLOW, ORANGE, BROWN, NULL");
        wrongInput = true;
        while (wrongInput) {
            String temp = sc.nextLine();
            if (!temp.equals("NULL")) {
                try {
                    hairColor = Enum.valueOf(Color.class, temp);
                    wrongInput = false;
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка ввода! Попробуйте ввести ещё раз.");
                }
            } else {
                hairColor = null;
                wrongInput = false;
            }
        }
        System.out.println("Данные о человеке введены.");
        System.out.println();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                Objects.equals(birthday, person.birthday) &&
                eyeColor == person.eyeColor &&
                hairColor == person.hairColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, eyeColor, hairColor);
    }

    public Date getBirthday() {
        System.out.println(birthday);
        return birthday;
    }
}