package ua.nure.havrysh.cifer;

import java.security.SecureRandom;
import java.util.Random;

public class RandomKeyGenerator {
    public static String generate(int length, String alphabet) {
        Random random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = alphabet.charAt(random.nextInt(alphabet.length()));
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
