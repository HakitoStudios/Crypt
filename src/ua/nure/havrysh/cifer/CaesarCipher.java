package ua.nure.havrysh.cifer;

public class CaesarCipher extends BaseCharShiftCifer {
    private final int key;

    public CaesarCipher(String alphabet, int key) {
        super(alphabet);
        this.key = key % alphabet.length();
    }

    @Override
    public String encrypt(String msg) {
        return shift(msg, key);
    }

    @Override
    public String decrypt(String msg) {
        return shift(msg, -key);
    }

    private String shift(String msg, int shiftAmount) {
        char[] chars = msg.toCharArray();
        for (int i = 0; i < msg.length(); i++) {
            shift(chars, i, shiftAmount);
        }
        return String.valueOf(chars);
    }
}
