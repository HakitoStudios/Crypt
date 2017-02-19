package ua.nure.havrysh;

public class MyXOR {
    public static boolean xor(boolean a, boolean b) {
        return (a && !b) || (!a && b);
    }
}
