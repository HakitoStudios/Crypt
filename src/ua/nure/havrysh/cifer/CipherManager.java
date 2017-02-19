package ua.nure.havrysh.cifer;

public class CipherManager {
    public static final String LATIN_ALPHABET = "abcdefghijklmnopqrstuvwxyz ";

    private final Cipher cipher;

    public CipherManager(String alphabet, int key) {
        cipher = new CaesarCipher(alphabet, key);
    }

    public CipherManager(String alphabet, String key) {
        cipher = new VigenereCipher(alphabet, key);
    }

    public String encrypt(String msg) {
        return cipher.encrypt(msg);
    }

    public String decrypt(String msg) {
        return cipher.decrypt(msg);
    }
}
