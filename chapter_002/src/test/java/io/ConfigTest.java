package io;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertEquals("Petr Arsentev", config.value("name"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertEquals("org.hibernate.dialect.PostgreSQLDialect", config.value("hibernate.dialect"));
        assertEquals("jdbc:postgresql://127.0.0.1:5432/trackstudio", config.value("hibernate.connection.url"));
        assertEquals("org.postgresql.Driver", config.value("hibernate.connection.driver_class"));
        assertEquals("postgres", config.value("hibernate.connection.username"));
        assertEquals("password", config.value("hibernate.connection.password"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairNotValid() {
        String path = "./data/pair_not_valid.properties";
        Config config = new Config(path);
        config.load();
    }
}