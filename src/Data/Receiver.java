package Data;

import java.time.ZonedDateTime;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Класс, который знает как исполнить каждую команду
 */
public class Receiver {

    private Hashtable<Long, Dragon> collection;
    private ZonedDateTime initializationDate;


    /**
     * Метод реализующий команду Help TBD
     */
    public void help(){
        //TBD
    }

    /**
     * Метод реализующий команду info
     */
    public void info(){
        System.out.println("Информация о коллекции:");
        System.out.println("Коллекция типа: Hashtable");
        System.out.println("Дата инициализации: " + getInitializationDate());
        System.out.println("Количество элементов: " + collection.size() + "\n");
        // TBD
    }

    public void show(){
        System.out.println("Элементы коллекции:");
        Iterator<Dragon> iterator = collection.values().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println();
    }

    public void insert(Long key){
        Set<Long> set = collection.keySet();
        for(long i = 1; i<Long.MAX_VALUE; i++){
            if(!set.contains(key)){
                Dragon dragon = new Dragon(key);
                collection.put(key, dragon);
                break;
            }
            else { break; }
        }
    };

    /**
     * Getters and setters
     */
    public ZonedDateTime getInitializationDate() {
        return initializationDate;
    }

    public void setInitializationDate() {
        this.initializationDate = ZonedDateTime.now();
    }

    public Hashtable<Long, Dragon> getCollection() {
        return collection;
    }

    public void setCollection(Hashtable<Long, Dragon> collection) {
        this.collection = collection;
    }
}
