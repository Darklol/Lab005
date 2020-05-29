package Data;

/**
 * Type Coordinates Class
 */
public class Coordinates {
    private long x;
    private Long y; //Значение поля должно быть больше -324, Поле не может быть null

    @Override
    public String toString() {
        return "Координаты " +
                "x = " + x +
                ", y = " + y;
    }


    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }
}