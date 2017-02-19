package ua.nure.havrysh;

import ua.nure.havrysh.cifer.CipherManager;
import ua.nure.havrysh.cifer.RandomKeyGenerator;

import static ua.nure.havrysh.TextStatistics.Order;
import static ua.nure.havrysh.cifer.CipherManager.LATIN_ALPHABET;

public class Main {

    public static void main(String[] args) {
        new TextStatistics().analyzeLettersFrequency("Some test text", true, Order.FREQUENCY);

        System.out.println(MyXOR.xor(true, false));

        //Caesar cipher
        CipherManager caesar = new CipherManager(LATIN_ALPHABET, 5);
        System.out.println(caesar.decrypt(caesar.encrypt("abcdz")));

        //Vigenere cipher
        CipherManager vigenere = new CipherManager(LATIN_ALPHABET, "qaz");
        System.out.println(vigenere.decrypt(vigenere.encrypt("abcdz")));

        //Vernam cipher
        String msg = "simple message";
        String key = RandomKeyGenerator.generate(msg.length(), LATIN_ALPHABET);
        CipherManager vernam = new CipherManager(LATIN_ALPHABET, key);
        System.out.println(vernam.decrypt(vernam.encrypt(msg)));
    }
}
