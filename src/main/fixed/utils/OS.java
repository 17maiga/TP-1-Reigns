package main.fixed.utils;

public class OS {
    public static String getConfigFolder() {
        return System.getProperty("user.home") + "/.reigns/";
    }
}
