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

//    @Override
//    public String toString(){
//        return "Дракон \n" +
//                "id: " + id +"\n" +
//                "Имя: " + name +"\n" +
//                "Координаты:" + coordinates +"\n" +
//                "Дата создания:" + creationDate +"\n" +
//                "Возраст:" + age +"\n" +
//                "Описание:" + description +"\n" +
//                "Размах крыльев:" + wingspan +"\n" +
//                "Цвет:" + color +"\n" +
//                "Убийца:" + killer +"\n";
//    }


    @Override
    public String toString() {
        return "Dragon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", wingspan=" + wingspan +
                ", color=" + color +
                ", killer=" + killer +
                '}';
    }

    public Dragon(long id){
        this.id = id;
        Scanner sc = new Scanner(System.in);
        /*System.out.println("Введите имя дракона:");
        this.name = (sc.nextLine());
        System.out.println("Введите координаты дракона:");
        setCoordinates(Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
        System.out.println("Введите возраст дракона:");
        this.age = (Integer.parseInt(sc.nextLine()));*/
        System.out.println("Введите описание дракона: ");
        this.description = sc.nextLine();
        this.killer = new Person();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person getKiller() {
        return killer;
    }

    public String getDescription() {
        return description;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWingspan() {
        return wingspan;
    }

    public Color getColor() {
        return color;
    }

    public int makeValue(){
        return age+wingspan+42;
    }

    public void setCoordinates(long x, Long y) {
        coordinates = new Coordinates(x, y);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate() {
        this.creationDate = LocalDate.now();
    }

    public void setCreationDate(LocalDate date) {
        this.creationDate = date;
    }

    public LocalDate getCreationDate(){
        return creationDate;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWingspan(Integer wingspan) {
        this.wingspan = wingspan;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setKiller(Person killer) {
        this.killer = killer;
    }
}