package io.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "dog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dog {

    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;
    private Contact contactOwn;
    private String[] commands;

    public Dog() {
    }

    public Dog(boolean sex, int age, Contact contactOwn, String... commands) {
        this.sex = sex;
        this.age = age;
        this.contactOwn = contactOwn;
        this.commands = commands;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Contact getContactOwn() {
        return contactOwn;
    }

    public String[] getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return "Dog{"
                + "sex=" + sex
                + ", age=" + age
                + ", contactOwn=" + contactOwn
                + ", commands=" + Arrays.toString(commands)
                + '}';
    }

    public static void main(String[] args) throws Exception {

        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("give a paw");
        list.add("go");
        JSONArray jsonCommands = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Dog dog = new Dog(true, 2, new Contact("+7983"), "sit", "vote");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", dog.isSex());
        jsonObject.put("age", dog.getAge());
        jsonObject.put("contactOwn", jsonContact);
        jsonObject.put("commands", jsonCommands);

        /* Выведем результат в консоль */
        System.out.println(jsonObject);

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(dog));
    }
}
