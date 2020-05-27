import Data.Dragon;
import Data.Person;
import Data.Receiver;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        Receiver receiver = new Receiver();

        Hashtable<Long, Dragon> col = new Hashtable<Long, Dragon>();


        receiver.setCollection(col);
        receiver.setInitializationDate();

        receiver.insert((long)1);
        receiver.insert((long)5);
        receiver.insert((long)2);
        receiver.insert((long)4);

        System.out.println(receiver.getCollection());
        receiver.show();
        receiver.getFile();
        System.out.println(receiver.getCollection());
        receiver.show();
    }
}
