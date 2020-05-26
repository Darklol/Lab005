package Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Класс, который знает как исполнить каждую команду
 */
public class Receiver {

    private Hashtable<Long, Dragon> collection;
    private ZonedDateTime initializationDate;
    private Set<String> commandSet;

    public Receiver(){
        setInitializationDate();
    }
    /**
     * Метод для реализации команды Help TBD
     */
    public void help(){
        //TBD
    }

    /**
     * Метод для реализации команды info
     */
    public void info(){
        System.out.println("Информация о коллекции:");
        System.out.println("Коллекция типа: Hashtable");
        System.out.println("Дата инициализации: " + getInitializationDate());
        System.out.println("Количество элементов: " + collection.size() + "\n");
        // TBD
    }

    /**
     * Метод для реализации команды show
     */
    public void show(){
        System.out.println("Элементы коллекции:");
        Iterator<Dragon> iterator = collection.values().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println();
    }

    /**
     * Метод для реализации команды insert
     * @param key
     */
    public void insert(Long key){
        Set<Long> set = collection.keySet();{
            if(!set.contains(key)){
                Dragon dragon = new Dragon(key);
                collection.put(key, dragon);
                System.out.println("Дракон добавлен");
            }
            else {System.out.println("Дракон не добавлен");}
        }
    }

    /**
     * Метод для реализации команды update
     * @param id
     */
    public void update(Long id){
        System.out.println("Обновление данных о драконе с ID: "+ id + ".");
        LocalDate temp = collection.get(id).getCreationDate();
        collection.remove(id);
        insert(id);
        collection.get(id).setCreationDate(temp);
    }

    /**
     * Метод для реализации команды remove
     * @param id
     */
    public void remove(Long id){
        if (collection.containsKey(id)){
        collection.remove(id);
        System.out.println("Дракон с ID: "+ id + " успешно удалён из коллекции.");}
        else {System.out.println("Такого дракона в коллекции нет");}
    }

    /**
     * Метод для реализации команды clear
     */
    public void clear(){
        if (!collection.isEmpty()){
        collection.clear();
        System.out.println("Коллекция успешно очищена.");}
        else {System.out.println("Коллекция уже пуста!");}
    }

    /**
     * Метод для реализации команды save
     */
    public void save(){
        //TBD
    }

    /**
     * Метод для реализации команды execute_script
     */
    public void executeScript(){
        //TBD
    }

    /**
     * Метод для реализации команды exit
     */
    public void exit(){
        System.out.println("Выходи из приложения.");
        System.exit(0);
    }

    /**
     * Метод для реализации команды remove_if_greater
     */
    public void removeGreater(Long id){
        List<Dragon> list = Collections.list(collection.elements());
        for (Dragon dragon : list){
            if (dragon.getValue() > collection.get(id).getValue()){
                long idToRemove = dragon.getId();
                remove(idToRemove);
            }
        }
    }

    /**
     * Метод для реализации команды remove_greater_key
     * @param id
     */
    public void removeGreaterKey(Long id){
        Set<Long> set = collection.keySet();
        List<Long> list = new ArrayList<Long>();
        for(Long key : set){
            if (key > id){
                list.add(key);
            }
        }
        for (Long key : list){
            remove(key);
        }
    }

    /**
     * Метод для реализации команды replace_if_greater
     * @param id
     */
    public void replaceGreater(Long id){
        Dragon dragon = new Dragon(id);
        if (dragon.getValue()>collection.get(id).getValue()){
            System.out.println("Введённое значение больше имеющегося");
            collection.remove(id);
            collection.put(id,dragon);
            System.out.println("Дракон успешно заменён");
        }
        else {
            System.out.println("Введённое значение меньше имеющегося, замены не произошло");
        }
    }

    /**
     * Метод для реализации команды min_by_name
     */
    public void minByName(){
        List<Dragon> list = Collections.list(collection.elements());
        Dragon minDragon = null;
        SortedSet<String> set = new TreeSet<String>();
        for (Dragon dragon : list){
            set.add(dragon.getName());
        }
        for (Dragon dragon : list){
            if (dragon.getName().equals(set.first())){
                minDragon = dragon;
            }
        }
        System.out.println(minDragon.toString());
    }

    /**
     * Метод для реализации команды print_unique_killer
     */
    public void printUniqueKiller(){
        List<Dragon> list = Collections.list(collection.elements());
        Set<Person> set = new HashSet<Person>();
        for (Dragon dragon : list){
            set.add(dragon.getKiller());
        }
        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    /**
     * Метод для реализации команды print_field_ascending_description
     */
    public void printFieldAscendDesc(){
        SortedSet<Long> sortedSet = new TreeSet<>(collection.keySet());
        for (Long key : sortedSet){
            System.out.println(collection.get(key).getDescription());
        }

    }

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
