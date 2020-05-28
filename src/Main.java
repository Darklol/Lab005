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

        Hashtable<Long, Dragon> col = new Hashtable<Long, Dragon>();


        receiver.setCollection(col);
        receiver.setInitializationDate();

        Invoker invoker = new Invoker(receiver);
        invoker.input();
        receiver.show();
//        try {
//            receiver.getFile("111testgson.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            receiver.save();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
