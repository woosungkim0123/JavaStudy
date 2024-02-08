package flyweight.common;

public class Memory {
    public static long size = 0;

    public static void print() {
        System.out.println("Total Memory used: " + size + " MB");
    }

    public static void reset() {
        size = 0;
    }
}
