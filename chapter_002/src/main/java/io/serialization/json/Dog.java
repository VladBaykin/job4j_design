package io.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Dog {
    private final boolean sex;
    private final int age;
    private final Contact contactOwn;
    private final String[] commands;

    public Dog(boolean sex, int age, Contact contactOwn, String... commands) {
        this.sex = sex;
        this.age = age;
        this.contactOwn = contactOwn;
        this.commands = commands;
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

    public static void main(String[] args) {
        final Dog dog = new Dog(true, 2, new Contact("+7983"), "sit", "vote");
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(dog));
        final String gsonDog =
                "{"
                        + "\"sex\":true,"
                        + "\"age\":2,"
                        + "\"contactOwn\":"
                            + "{"
                                + "\"phone\":\"+7(924)111-111-11-11\""
                            + "},"
                        + "\"commands\":"
                        + "[\"sit\",\"vote\"]"
                        + "}";
        final Dog dogMod = gson.fromJson(gsonDog, Dog.class);
        System.out.println(dogMod);
    }
}
