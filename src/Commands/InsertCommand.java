package Commands;

import Data.Invoker;
import Data.Receiver;

import java.util.Arrays;
import java.util.Scanner;

public class InsertCommand extends Command {

    Scanner scanner = new Scanner(System.in);

    public InsertCommand(Receiver receiver){
        super(receiver);
    }

    @Override
    public void execute(String[] arguments) {
        for (int i = 0; i<arguments.length;i++){
        try {
            receiver.insert(Long.parseLong(arguments[i]));
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильный ввод аргумента!");
        }}
    }

    @Override
    public boolean needArguments() {
        return false;
    }

    @Override
    public String manual() {
        return null;
    }
}
