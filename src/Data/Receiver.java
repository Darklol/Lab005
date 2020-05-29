package Data;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Класс, который знает как исполнить каждую команду
 */
public class Receiver {

    private Hashtable<Long, Dragon> collection;
    private ZonedDateTime initializationDate;

    public Receiver() {
        setInitializationDate();
        collection = new Hashtable<Long, Dragon>();
    }

    /**
     * Метод для реализации команды Help
     */
    public void help() {
        Invoker invoker = new Invoker();
        Iterator<String> nameIterator = invoker.getCommandsName().keySet().iterator();
        Iterator<String> manualIterator = invoker.getCommandsName().keySet().iterator();
        System.out.println("Описание всех доступных команд:");
        while (nameIterator.hasNext()) {
            String name = invoker.getCommandsName().get(nameIterator.next()).commandName();
            String manual = invoker.getCommandsName().get(manualIterator.next()).manual();
            System.out.println(name + ": " + manual);
        }

    }

    /**
     * Метод для реализации команды info
     */
    public void info() {
        System.out.println("Информация о коллекции:");
        System.out.println("Коллекция типа: Hashtable");
        System.out.println("Дата инициализации: " + getInitializationDate());
        System.out.println("Количество элементов: " + collection.size() + "\n");
        System.out.println();
        // TBD
    }

    /**
     * Метод для реализации команды show
     */
    public void show() {
        if (!collection.isEmpty()) {
            System.out.println("Элементы коллекции: ");
            Iterator<Dragon> iterator = collection.values().iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        } else {
            System.out.println("Коллекция пуста!");
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
        if (!set.contains(key) && (key > 0)) {
            Dragon dragon = new Dragon(key);
            collection.put(key, dragon);
            System.out.println("Дракон успешно добавлен!");
        } else {
            if (key <= 0) {
                System.out.println("ID не может быть меньше 1");
            } else {
                if (collection.isEmpty()) {
                    System.out.println("Коллекция пуста! Добавьте этементы в коллекцию, чтобы продолжить.");
                } else {
                    System.out.println("Такого дракона в коллекции нет, попробуйте ввести другой ID");
                }
            }
        }
        System.out.println();
    }

    /**
     * Метод для реализации команды update
     *
     * @param id
     */
    public void update(Long id) {
        if (collection.containsKey(id) && !collection.isEmpty() && (id > 0)) {
            System.out.println("Обновление данных о драконе с ID: " + id + ".");
            LocalDate temp = collection.get(id).getCreationDate();
            collection.replace(id, new Dragon(id));
            collection.get(id).setCreationDate(temp);
        } else {
            if (collection.isEmpty()) {
                System.out.println("Коллекция пуста! Добавьте этементы в коллекцию, чтобы продолжить.");
            } else {
                if (id <= 0) {
                    System.out.println("ID не может быть меньше 1!");

                } else {
                    if (!collection.containsKey(id)) {
                        System.out.println("Дракон с таким ID уже существует в коллекции, попробуйте ввести другой ID" +
                                " или используйте команду update.");
                    } else {
                        System.out.println("Коллекция пуста! Добавьте элементы чтобы продолжить.");
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     * Метод для реализации команды remove
     *
     * @param id
     */
    public void remove(Long id) {
        if (collection.containsKey(id) && !collection.isEmpty() && (id > 0)) {
            collection.remove(id);
            System.out.println("Дракон с ID: " + id + " успешно удалён из коллекции.");
        } else {
            if (collection.isEmpty()) {
                System.out.println("Коллекция пуста! Добавьте этементы в коллекцию, чтобы продолжить.");
            } else {
                if (id <= 0) {
                    System.out.println("ID не может быть меньше 1");
                } else {
                    if (collection.isEmpty()) {
                        System.out.println("Коллекция пуста! Добавьте этементы в коллекцию, чтобы продолжить.");
                    } else {
                        System.out.println("Такого дракона в коллекции нет, попробуйте ввести другой ID");
                    }
                }

            }
        }
        System.out.println();
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
        System.out.println();
    }

    /**
     * Метод для реализации команды save
     */
    public void save() throws IOException {
        if (!collection.isEmpty()){
        Gson gson = new Gson();
        List<String> list = new ArrayList<>();
        Set<Long> set = collection.keySet();
        Iterator<Long> iterator = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            String temp = gson.toJson(collection.get(iterator.next()));
            temp = temp.replaceAll("\\{", "$0\n\t\t");
            list.add(temp);
        }
        Iterator<Long> newIterator = set.iterator();
        Iterator<String> listIterator = list.iterator();
        File file = new File("output.json");
        System.out.println("Сохранение коллекции в файл " + file.getAbsolutePath());
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.write("{\n");
        while (listIterator.hasNext()) {
            printWriter.write("\t\"" + newIterator.next() + "\":");
            printWriter.write(listIterator.next());
            if (listIterator.hasNext()) {
                printWriter.write(",\n");
            } else {
                printWriter.write("\n}");
            }
        }
        printWriter.flush();
        printWriter.close();}
        else { System.out.println("Запись пустой коллекции в файл невозможна");}
    }

    public void getFile(String path) throws IOException, JsonSyntaxException {
        StringBuilder string = new StringBuilder();
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(new File(path)));
        byte[] contents = new byte[1024];
        int bytesRead = 0;
        String strFileContents = "";
        while ((bytesRead = stream.read(contents)) != -1) {
            strFileContents += new String(contents, 0, bytesRead);
        }
        if (!strFileContents.trim().equals("")){
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Hashtable<Long, Dragon>>() {
        }.getType();
        collection = gson.fromJson(strFileContents, collectionType);}
        else {
            System.out.println("файл пуст.");
        }
    }

    /**
     * Метод для реализации команды execute_script
     */
    public void executeScript(String path) throws IOException {
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(new File(path)));
        byte[] contents = new byte[1024];
        int bytesRead = 0;
        String strFileContents = "";
        while ((bytesRead = stream.read(contents)) != -1) {
            strFileContents += new String(contents, 0, bytesRead);
        }
        Scanner scanner = new Scanner(strFileContents);
        String line;
        Hashtable<Long, Dragon> tempCollection = this.collection;
        Receiver virtualReceiver = new Receiver();
        virtualReceiver.setCollection(tempCollection);
        Invoker virtualInvoker = new Invoker(virtualReceiver);
        System.out.println("Приступаю к выполнению скрипта " + path);
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            virtualInvoker.execute(line);
        }
        collection = tempCollection;
        System.out.println("Выполнение скрипта завершено.\n");
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
        if (collection.containsKey(id) && !collection.isEmpty() && (id > 0)) {
            List<Dragon> list = Collections.list(collection.elements());
            for (Dragon dragon : list) {
                if (dragon.makeValue() > collection.get(id).makeValue()) {
                    long idToRemove = dragon.getId();
                    remove(idToRemove);
                }
            }
        } else {
            if (id <= 0) {
                System.out.println("ID не может быть меньше 1!");
            } else {
                if (collection.isEmpty()) {
                    System.out.println("Коллекция пуста! Добавьте элементы в коллекцию, чтобы продолжить.");
                } else {
                    System.out.println("Такого дракона в коллекции нет, попробуйте ввести другой ID");
                }
            }
        }
        System.out.println();
    }

    /**
     * Метод для реализации команды remove_greater_key
     *
     * @param id
     */
    public void removeGreaterKey(Long id) {
        if (!collection.isEmpty() && (id > 0)) {
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
            if (id <= 0) {
                System.out.println("ID не может быть меньше 1");
            } else {
                System.out.println("Коллекция пуста! Добавьте этементы в коллекцию, чтобы продолжить.");

            }
        }
        System.out.println();
    }

    /**
     * Метод для реализации команды replace_if_greater
     *
     * @param id
     */
    public void replaceGreater(Long id) {
        if (collection.containsKey(id) && !collection.isEmpty() && (id > 0)) {
            Dragon dragon = new Dragon(id);
            if (dragon.makeValue() > collection.get(id).makeValue()) {
                System.out.println("Введённое значение больше имеющегося");
                LocalDate temp = collection.get(id).getCreationDate();
                collection.replace(id, dragon);
                dragon.setCreationDate(temp);
                System.out.println("Дракон успешно заменён");
            } else {
                System.out.println("Введённое значение не больше имеющегося, замены не произошло");
            }
        } else {
            if (id <= 0) {
                System.out.println("ID не может быть меньше 1");
            } else {
                if (collection.isEmpty()) {
                    System.out.println("Коллекция пуста! Добавьте этементы в коллекцию, чтобы продолжить.");
                } else {
                    System.out.println("Такого дракона в коллекции нет, попробуйте ввести другой ID");
                }
            }
        }
        System.out.println();
    }

    /**
     * Метод для реализации команды min_by_name
     */
    public void minByName() {
        if (!collection.isEmpty()) {
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
            System.out.println(minDragon.toString());
        } else {
            System.out.println("Коллекция пуста! Добавьте элементы в коллекцию, чтобы продолжить.");
        }
        System.out.println();
    }

    /**
     * Метод для реализации команды print_unique_killer
     */
    public void printUniqueKiller() {
        if (!collection.isEmpty()) {
            List<Dragon> list = Collections.list(collection.elements());
            Set<Person> set = new HashSet<Person>();
            for (Dragon dragon : list) {
                if (dragon.getKiller() != null) {
                    set.add(dragon.getKiller());
                }
            }
            Iterator<Person> iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        } else {
            System.out.println("Коллекция пуста! Добавьте элементы в коллекцию чтобы продолжить.");
        }
        System.out.println();

    }

    /**
     * Метод для реализации команды print_field_ascending_description
     */
    public void printFieldAscendDesc() {
        if (!collection.isEmpty()) {
            SortedSet<Long> sortedSet = new TreeSet<>(collection.keySet());
            for (Long key : sortedSet) {
                System.out.println("Вывод полей description всех драконов в коллекции в порядке возрастания:");
                System.out.print("Поле description дракона с ID: " + key + ": " + collection.get(key).getDescription());
            }
        } else {
            System.out.println("Коллекция пуста! Добавьте элементы в коллекцию чтобы продолжить.");
        }
        System.out.println();

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
