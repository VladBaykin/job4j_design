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
        LOG.debug("""
                primitives:\s
                byte a = {}
                short b = {}
                int c = {}
                long d = {}
                float e = {}
                double f = {}
                char g = {}
                boolean h = {}
                """, a, b, c, d, e, f, g, h);

    }
}
