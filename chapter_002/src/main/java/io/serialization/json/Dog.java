package io.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

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
        final Dog dog = new Dog(true, 2, new Contact("+7983"), "sit", "vote");
        JAXBContext context = JAXBContext.newInstance(Dog.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(dog, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Dog result = (Dog) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
