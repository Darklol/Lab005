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
    public String toString() {
        return "Дракон \n" +
                "id: " + id + "\n" +
                "Имя: " + name + "\n" +
                "Координаты:" + coordinates + "\n" +
                "Дата создания:" + creationDate + "\n" +
                "Возраст:" + age + "\n" +
                "Описание:" + description + "\n" +
                "Размах крыльев:" + wingspan + "\n" +
                "Цвет:" + color + "\n" +
                "Убийца:" + killer + "\n";
    }


//    @Override
//    public String toString() {
//        return "Dragon{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", coordinates=" + coordinates +
//                ", creationDate=" + creationDate +
//                ", age=" + age +
//                ", description='" + description + '\'' +
//                ", wingspan=" + wingspan +
//                ", color=" + color +
//                ", killer=" + killer +
//                '}';
//    }

    public Dragon(long id) {
        boolean wrongInput = true;
        this.id = id;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя дракона:");
        while (wrongInput) {
            this.name = (sc.nextLine());
            if (!name.equals("")) {
                wrongInput = false;
            } else {
                System.out.println("Поле не может быть пустым. Попробуйте ещё раз.");
            }
        }
        System.out.println();
        wrongInput = true;
        System.out.println("Введите координаты дракона:");
        setCoordinates();
        System.out.println("Введите координату x");
        while (wrongInput) {
            try {
                coordinates.setX(Long.parseLong(sc.nextLine()));
                wrongInput = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Попробуйте ввести ещё раз.");
            }
        }
        System.out.println("Введите координату y");
        wrongInput = true;
        while (wrongInput) {
            try {
                coordinates.setY(Long.parseLong(sc.nextLine()));
                if (coordinates.getY() > -324) {
                    wrongInput = false;
                } else {
                    System.out.println("Значение поля должно быть больше -324! Попробуйте ввести ещё раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Попробуйте ввести ещё раз.");
            }
        }
        System.out.println("Введите возраст дракона:");
        wrongInput = true;
        while (wrongInput) {
            try {
                String temp = sc.nextLine();
                if (!temp.equals("")) {
                    this.age = Integer.parseInt(temp);
                    if (age > 0) {
                        wrongInput = false;
                    } else {
                        System.out.println("Значение поля должно быть больше 0 либо null! Попробуйте ввести ещё раз.");
                    }
                } else {
                    age = null;
                    wrongInput = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода! Попробуйте ввести ещё раз.");
            }
        }
        System.out.println();
        this.setCreationDate();
        System.out.println("Введите описание дракона: ");
        wrongInput = true;
        while (wrongInput) {
            description = sc.nextLine();
            if (!description.equals("")) {
                wrongInput = false;
            } else {
                System.out.println("Поле не может быть пустым! Попробуйте ещё раз.");
            }
        }
        System.out.println();
        System.out.println("Введите размах крыльев дракона:");
        wrongInput = true;
        while (wrongInput) {
            try {
                String temp = sc.nextLine();
                if (!temp.equals("")) {
                    this.wingspan = Integer.parseInt(temp);
                    if (wingspan > 0) {
                        wrongInput = false;
                    } else {
                        System.out.println("Значение поля должно быть больше 0 либо null! Попробуйте ввести ещё раз.");
                    }
                } else {
                    wingspan = null;
                    wrongInput = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода! Попробуйте ввести ещё раз.");
            }
        }
        System.out.println();
        System.out.println("Введите цвет дракона:");
        System.out.println("Доступные значения: BLACK, BLUE, YELLOW, ORANGE, BROWN");
        wrongInput = true;
        while (wrongInput) {
            String temp = sc.nextLine();
            try {
                color = Enum.valueOf(Color.class, temp);
                wrongInput = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода! Попробуйте ввести ещё раз.");
            }
        }
        System.out.println();
        System.out.println("Дракон побеждён?\n(Введите yes или no");
        wrongInput = true;
        while (wrongInput) {
            String temp = sc.nextLine();
            if (temp.trim().equals("yes")) {
                wrongInput = false;
                System.out.println("Введите данные убийцы дракона");
                killer = new Person();
            } else {
                if (temp.trim().equals("no")) {
                    wrongInput = false;
                } else {
                    System.out.println("Ошибка ввода! Пожалуйста, введите yes или no");
                }
            }
        }
        System.out.println("Данные о драконе введены.");
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

    public long makeValue() {
        return (id + 42) / id;
    }

    public void setCoordinates() {
        coordinates = new Coordinates();
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

    public LocalDate getCreationDate() {
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