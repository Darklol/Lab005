package Data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.xml.internal.ws.developer.SerializationFeature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.file.Paths;
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

    public Receiver() {
        setInitializationDate();
        collection = new Hashtable<Long, Dragon>();
    }

    /**
     * Метод для реализации команды Help TBD
     */
    public void help() {
        //TBD
    }

    /**
     * Метод для реализации команды info
     */
    public void info() {
        System.out.println("Информация о коллекции:");
        System.out.println("Коллекция типа: Hashtable");
        System.out.println("Дата инициализации: " + getInitializationDate());
        System.out.println("Количество элементов: " + collection.size() + "\n");
        // TBD
    }

    /**
     * Метод для реализации команды show
     */
    public void show() {
        System.out.println("Элементы коллекции:");
        Iterator<Dragon> iterator = collection.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println();
    }

    /**
     * Метод для реализации команды insert
     *
     * @param key
     */
    public void insert(Long key) {
        Set<Long> set = collection.keySet();
        {
            if (!set.contains(key)) {
                Dragon dragon = new Dragon(key);
                collection.put(key, dragon);
                System.out.println("Дракон добавлен");
            } else {
                System.out.println("Дракон не добавлен");
            }
        }
    }

    /**
     * Метод для реализации команды update
     *
     * @param id
     */
    public void update(Long id) {
        if (collection.containsKey(id)) {
            System.out.println("Обновление данных о драконе с ID: " + id + ".");
            LocalDate temp = collection.get(id).getCreationDate();
            collection.replace(id, new Dragon(id));
            collection.get(id).setCreationDate(temp);
        } else {
            System.out.println("Такого дракона в коллекции нет, попробуйте ввести другой ID");
        }
    }

    /**
     * Метод для реализации команды remove
     *
     * @param id
     */
    public void remove(Long id) {
        if (collection.containsKey(id)) {
            collection.remove(id);
            System.out.println("Дракон с ID: " + id + " успешно удалён из коллекции.");
        } else {
            System.out.println("Такого дракона в коллекции нет, попробуйте ввести другой ID");
        }
    }

    /**
     * Метод для реализации команды clear
     */
    public void clear() {
        if (!collection.isEmpty()) {
            collection.clear();
            System.out.println("Коллекция успешно очищена.");
        } else {
            System.out.println("Коллекция уже пуста!");
        }
    }

    /**
     * Метод для реализации команды save
     */
    public void save() throws IOException {
        Gson gson = new Gson();
        List<String> list = new ArrayList<>();
        Set<Long> set = collection.keySet();
        Iterator<Long> iterator = set.iterator();
        for(int i = 0; i < set.size(); i++){
            String temp = gson.toJson(collection.get(iterator.next()));
            temp = temp.replaceAll("\\{","$0\n\t\t");
            temp = temp.replaceAll(",","$0\n\t\t");
            list.add(temp);
        }
        Iterator<Long> newIterator = set.iterator();
        Iterator<String> listIterator = list.iterator();
        File file = new File("testgson.json");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("{\n");
        while (listIterator.hasNext()){
            fileWriter.write("\t\""+ newIterator.next()+"\":");
            fileWriter.write(listIterator.next());
            if (listIterator.hasNext()){
                fileWriter.write(",\n");
            }else {
                fileWriter.write("\n}");
            }
        }
        fileWriter.close();
    }
    /*public void save() throws IOException {
        Gson gson = new Gson();
        String string = gson.toJson(collection);
        File file = new File("gson.json");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(string);
        fileWriter.close();
    }
*/
    public void getFile(String path) throws IOException {
        StringBuilder string = new StringBuilder();
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(new File(path)));
        byte[] contents = new byte[1024];
        int bytesRead = 0;
        String strFileContents = "";
        while((bytesRead = stream.read(contents)) != -1) {
            strFileContents += new String(contents, 0, bytesRead);
        }
        System.out.println(strFileContents);
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Hashtable<Long, Dragon>>() {
        }.getType();
        collection = gson.fromJson(strFileContents, collectionType);
    }

    /**
     * Метод для реализации команды execute_script
     */
    public void executeScript() {
        //TBD
    }

    /**
     * Метод для реализации команды exit
     */
    public void exit() {
        System.out.println("Выход из приложения.");
        System.exit(0);
    }

    /**
     * Метод для реализации команды remove_if_greater
     */
    public void removeGreater(Long id) {
        if (collection.containsKey(id)) {
            List<Dragon> list = Collections.list(collection.elements());
            for (Dragon dragon : list) {
                if (dragon.makeValue() > collection.get(id).makeValue()) {
                    long idToRemove = dragon.getId();
                    remove(idToRemove);
                }
            }
        } else {
            System.out.println("Такого дракона в коллекции нет, попробуйте ввести другой ID");
        }
    }

    /**
     * Метод для реализации команды remove_greater_key
     *
     * @param id
     */
    public void removeGreaterKey(Long id) {
        if (collection.containsKey(id)) {
            Set<Long> set = collection.keySet();
            List<Long> list = new ArrayList<Long>();
            for (Long key : set) {
                if (key > id) {
                    list.add(key);
                }
            }
            for (Long key : list) {
                remove(key);
            }
        } else {
            System.out.println("Такого дракона в коллекции нет, попробуйте ввести другой ID");
        }
    }

    /**
     * Метод для реализации команды replace_if_greater
     *
     * @param id
     */
    public void replaceGreater(Long id) {
        if (collection.containsKey(id)) {
            Dragon dragon = new Dragon(id);
            if (dragon.makeValue() > collection.get(id).makeValue()) {
                System.out.println("Введённое значение больше имеющегося");
                LocalDate temp = collection.get(id).getCreationDate();
                collection.replace(id, dragon);
                dragon.setCreationDate(temp);
                System.out.println("Дракон успешно заменён");
            } else {
                System.out.println("Введённое значение меньше имеющегося, замены не произошло");
            }
        } else {
            System.out.println("Такого дракона в коллекции нет, попробуйте ввести другой ID");
        }
    }

    /**
     * Метод для реализации команды min_by_name
     */
    public void minByName() {
        if (!collection.isEmpty()){
        List<Dragon> list = Collections.list(collection.elements());
        Dragon minDragon = null;
        SortedSet<String> set = new TreeSet<String>();
        for (Dragon dragon : list) {
            set.add(dragon.getName());
        }
        for (Dragon dragon : list) {
            if (dragon.getName().equals(set.first())) {
                minDragon = dragon;
            }
        }
        System.out.println(minDragon.toString());} else {
            System.out.println("Коллекция пуста!");
        }
    }

    /**
     * Метод для реализации команды print_unique_killer
     */
    public void printUniqueKiller() {
        if (!collection.isEmpty()){
        List<Dragon> list = Collections.list(collection.elements());
        Set<Person> set = new HashSet<Person>();
        for (Dragon dragon : list) {
            set.add(dragon.getKiller());
        }
        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }} else {
            System.out.println("Коллекция пуста!");
        }


    }

    /**
     * Метод для реализации команды print_field_ascending_description
     */
    public void printFieldAscendDesc() {
        if (!collection.isEmpty()) {
            SortedSet<Long> sortedSet = new TreeSet<>(collection.keySet());
            for (Long key : sortedSet) {
                System.out.println(collection.get(key).getDescription());
            }
        } else {
            System.out.println("Коллекция пуста!");
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
