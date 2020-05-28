import Data.Dragon;
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

//        receiver.insert((long)666);
//        receiver.insert((long)777);
//        receiver.insert((long)222);
//        receiver.insert((long)444);
////


//        receiver.show();
//        receiver.update((long)6);
//        receiver.show();
        try {
            receiver.getFile("testgson.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            receiver.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
        receiver.show();
    }
}
