package Data;

import java.util.Date;
import java.util.Objects;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле может быть null
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле может быть null

    public Person(){
        name = Double.toString(Math.random());
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
}