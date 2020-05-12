package Commands;

public abstract class Command {
    /** абстрактный класс команды
     * зачем? почему интерфейс? TBD
     */

    public abstract void execute();

    public abstract boolean needArguments();

    public abstract String manual();




}
