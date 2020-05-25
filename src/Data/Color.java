package Data;

public enum Color {
    BLACK ("Чёрный"),
    BLUE ("Синий"),
    YELLOW ("Жёлтый"),
    ORANGE ("Оранжевый"),
    BROWN ("Коричневый");

    private String title;

    Color(String title){
        this.title = title;
    }
}