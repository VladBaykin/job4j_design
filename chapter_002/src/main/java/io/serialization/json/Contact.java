package io.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import com.sun.xml.txw2.annotation.XmlElement;


@XmlElement(value = "contact")
public class Contact {

    @XmlAttribute
    private String phone;

    public Contact() {
    }

    public Contact(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone
                + '\'' + '}';
    }
}
