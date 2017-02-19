package ua.nure.havrysh.cifer;

public interface Cipher {
    String encrypt(String msg);

    String decrypt(String msg);
}
