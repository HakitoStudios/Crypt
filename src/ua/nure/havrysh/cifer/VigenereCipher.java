package ua.nure.havrysh.cifer;

public class VigenereCipher extends BaseCharShiftCifer {
    private final String key;

    public VigenereCipher(String alphabet, String key) {
        super(alphabet);
        this.key = key;
    }

    @Override
    public String encrypt(String msg) {
        return shift(msg, key, false);
    }

    @Override
    public String decrypt(String msg) {
        return shift(msg, key, true);
    }

    private String shift(String msg, String shiftKey, boolean inverse) {
        char[] chars = msg.toCharArray();
        for (int i = 0; i < msg.length(); i++) {
            int shiftAmount = indexOf(shiftKey.charAt(i % shiftKey.length())) * (inverse ? -1 : 1);
            shift(chars, i, shiftAmount);
        }
        return String.valueOf(chars);
    }
}
