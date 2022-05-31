package utils;

import java.util.regex.*;

import consolejv.*;

public class Utils {
    public static void TODO(String string) {
        ConsoleJV.printlnc(String.format("TODO: %s", string), ConsoleJV.red, true);
        System.exit(1);
    }
    public static boolean isMatchRegex(String string, String pattern) {
        try {
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(string);
            return matcher.matches();
        } catch (RuntimeException e) {
            return false;
        }
    }
}