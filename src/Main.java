import Commands.InsertCommand;
import Data.Dragon;
import Data.Invoker;
import Data.Person;
import Data.Receiver;

import java.io.IOException;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        Receiver receiver = new Receiver();

        Invoker invoker = new Invoker(receiver);

        while (true){
            invoker.input();
        }
    }
}
