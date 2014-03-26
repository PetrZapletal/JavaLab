package Pyramid.utils;

public class Util {

    public final static String NEW_LINE = System.getProperty("line.separator");

    public static String repeatChar(char c, int n) {

        final StringBuilder builder = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}
