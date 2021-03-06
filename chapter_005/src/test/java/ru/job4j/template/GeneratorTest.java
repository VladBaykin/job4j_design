package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorTest {

    //@Test
    public void generateText() {
        Generator generator = new TextGenerator();
        Map<String, String> params = new HashMap<>();
        params.put("name", "Petr");
        params.put("subject", "you");
        String text = generator.produce("I am a ${name}, Who are ${subject}? ", params);
        assertEquals("I am a Petr, Who are you? ", text);
    }

    //@Test (expected = IllegalArgumentException.class)
    public void generateTextWithoutReqParameters() {
        Generator generator = new TextGenerator();
        Map<String, String> params = new HashMap<>();
        params.put("name", "Petr");
        String text = generator.produce("I am a ${name}, Who are ${subject}? ", params);
    }

    //@Test (expected = IllegalArgumentException.class)
    public void generateTextWithWrongParameters() {
        Generator generator = new TextGenerator();
        Map<String, String> params = new HashMap<>();
        params.put("name", "Petr");
        params.put("subject", "you");
        params.put("lastName", "Ivanov");
        String text = generator.produce("I am a ${name}, Who are ${subject}? ", params);
    }
}