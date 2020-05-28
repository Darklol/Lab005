package Commands;

import Data.Receiver;

import java.util.Scanner;

public abstract class Command{
    /** абстрактный класс команды
     * определяет общее поведение всех команд
     *
     */
    protected Receiver receiver;
    protected Scanner scanner;

    public abstract void execute(String[] arguments);

    public Command(Receiver receiver){
        this.receiver = receiver;
    }

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
