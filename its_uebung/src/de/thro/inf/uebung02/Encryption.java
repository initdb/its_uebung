package de.thro.inf.uebung02;

import javax.crypto.*;

import java.nio.file.NoSuchFileException;
import java.security.*;
import java.io.*;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * User: Hue
 * Date: 07.02.2012
 * Time: 11:27:17
 * To change this template use File | Settings | File Templates.
 */
public class Encryption {
    private static final int ENCRYPT_MODE = 3;
    private byte[] data;

    private byte[] encryptedData;

    private Key key;
    private Cipher cipher;
    private static final String cipherAlgorithm = "AES/ECB/PKCS5Padding";
    private static final String algorithm = "AES";

    /**
     * Liest Daten aus einer Datei und speichert sie in einem internen Array
     *
     * @param srcFile  Dateiname
     * @throws Exception
     */
    public void readFromFile(String srcFile) throws Exception
    {
        FileInputStream inStream = null;
        inStream = new FileInputStream(srcFile);
        data = new byte[inStream.available()];
        inStream.read(data);  //Öfnen und Auslesen der Datei
        inStream.close();
    }
    /**
     *  Generiert einen symmetrischen Schlüssel abhängig von Klassenvariable algorithm
     *  @pre algorithm ist mit Verschlüsselungsverfahren initialisiert
     */
    public void generateKey() throws Exception
    {
        KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
        keyGen.init(256);

        key = keyGen.generateKey();
    }

    /**
     *  Verschlüsselt die Daten
     *  @pre Daten sind aus Datei eingelesen, Schlüssel generiert
     *  @post Das Ergebnis landet im privaten Vektor encryptedData
     */
    public void encrypt() throws Exception
    {
        if(data != null && key != null) {
            cipher = Cipher.getInstance(cipherAlgorithm);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encryptedData = cipher.doFinal(data);
        } else { // Spielerei kann auch weggelassen werden!
            throw new NoSuchFileException("could not find file or directory.");
        }
    }

    /**
     * Speichert verschlüsselte Daten Base64-Kodiert in einer Datei
     * @param destFile Dateiname
     */
    public void writeToFile(String destFile) throws Exception
    {
        FileOutputStream fos = new FileOutputStream(destFile);
        fos.write(Base64.getEncoder().encode(encryptedData));
        fos.close();
    }

    /**
     * Speichert Schlüssel Base64-Kodiert in einer Datei
     *
     * @param destFile Dateiname
     */
    public void saveKey(String destFile) throws Exception
    {
        FileOutputStream fos = new FileOutputStream(destFile);
        fos.write(Base64.getEncoder().encode(key.getEncoded()));
        fos.close();
    }

    public byte[] getData() {
        return data;
    }

    public byte[] getEncryptedData() {
        return encryptedData;
    }
}