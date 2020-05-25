package Commands;

import Data.Invoker;

public abstract class Command {
    /** абстрактный класс команды
     * определяет общее поведение всех команд
     * @param Invoker
     */
    private Invoker invoker;

    public abstract void execute();

    abstract void setInvoker(Invoker invoker);

    /**
     * Метод, который показывает, нужны ли команде аргументы
     * (хз зачем, придумаю позже)
     * @return
     */
    public abstract boolean needArguments();

    /**
     * Описание действия команды
     * Нужен для команды help
     * @return
     */
    public abstract String manual();




}
