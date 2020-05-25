import Data.Dragon;
import Data.Receiver;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {

        Receiver receiver = new Receiver();

        Hashtable<Long, Dragon> col = new Hashtable<Long, Dragon>();


        receiver.setCollection(col);
        receiver.setInitializationDate();

        receiver.insert((long)1);
        receiver.insert((long)2);
        receiver.show();

    }
}
