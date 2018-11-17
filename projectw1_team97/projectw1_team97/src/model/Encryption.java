package model;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
    private String key;

    public Encryption(String key) {
        this.key = key;
    }

    //Modifies: this
    //Effects: Takes a string and returns a string that represents the string encrypted by the cipher
    public String encrypt(String str) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(this.key);
        return encryptor.encrypt(str);
    }

    public String decrypt(String str) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(this.key);
        return encryptor.decrypt(str);

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
