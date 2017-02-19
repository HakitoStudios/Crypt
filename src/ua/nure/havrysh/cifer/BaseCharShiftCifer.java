package ua.nure.havrysh.cifer;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseCharShiftCifer implements Cipher {
    protected final String alphabet;

    private final Map<Character, Integer> alphabetMap;

    public BaseCharShiftCifer(String alphabet) {
        this.alphabet = alphabet;

        alphabetMap = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            alphabetMap.put(alphabet.charAt(i), i);
        }
    }

    protected void shift(char[] chars, int index, int shiftAmount) {
        int code = indexOf(chars[index]);
        code += shiftAmount;
        char newChar = alphabet.charAt((code + alphabet.length()) % alphabet.length());
        chars[index] = newChar;
    }

    protected int indexOf(char c) {
        return alphabetMap.get(c);
    }
}
