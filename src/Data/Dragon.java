package Data;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Dragon {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле может быть null
    private String description; //Поле не может быть null
    private Integer wingspan; //Значение поля должно быть больше 0, Поле может быть null
    private Color color; //Поле не может быть null
    private Person killer; //Поле может быть null

    @Override
    public String toString(){
        return "Дракон \n" +
                "id: " + id +"\n" +
                "Имя: " + name +"\n" +
                "Координаты:" + coordinates +"\n" +
                "Дата создания:" + creationDate +"\n" +
                "Возраст:" + age +"\n" +
                "Описание:" + description +"\n" +
                "Размах крыльев:" + wingspan +"\n" +
                "Цвет:" + color +"\n" +
                "Убийца:" + killer +"\n";
    }


    public Dragon(long id){
        this.id = id;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя дракона:");
        this.name = (sc.nextLine());
        System.out.println("Введите координаты дракона:");
        setCoordinates(Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
        System.out.println("Введите возраст дракона:");
        this.age = (Integer.parseInt(sc.nextLine()));
        System.out.println("Введите описание дракона: ");
        this.description = sc.nextLine();
    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCoordinates(long x, Long y) {
        coordinates = new Coordinates(x, y);
    }
}