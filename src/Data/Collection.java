package Data;

import java.time.ZonedDateTime;
import java.util.Hashtable;

public class Collection {

    private Hashtable<Dragon, Long> collection;
    private ZonedDateTime initializationDate;

    public void setCollection(Hashtable<Dragon, Long> collection) {
        this.collection = collection;
    }

    public void setInitializationDate(ZonedDateTime initializationDate) {
        this.initializationDate = initializationDate;
    }

    public Hashtable<Dragon, Long> getCollection() {
        return collection;
    }

    public ZonedDateTime getInitializationDate() {
        return initializationDate;
    }


}
