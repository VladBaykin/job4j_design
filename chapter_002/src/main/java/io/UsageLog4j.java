package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte a = 1;
        short b = 2;
        int c = 3;
        long d = 4;
        float e = 5;
        double f = 6;
        char g = '7';
        boolean h = true;
        LOG.debug("primitives:\n"
                + "byte a = {}\n"
                + "short b = {}\n"
                + "int c = {}\n"
                + "long d = {}\n"
                + "float e = {}\n"
                + "double f = {}\n"
                + "char g = {}\n"
                + "boolean h = {}\n", a, b, c, d, e, f, g, h);

    }
}
