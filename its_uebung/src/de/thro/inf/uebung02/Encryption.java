package de.thro.inf.uebung02;

import javax.crypto.*;

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
        // TODO
    }

    /**
     *  Verschlüsselt die Daten
     *  @pre Daten sind aus Datei eingelesen, Schlüssel generiert
     *  @post Das Ergebnis landet im privaten Vektor encryptedData
     */
    public void encrypt() throws Exception
    {
        // TODO
    }

    /**
     * Speichert verschlüsselte Daten Base64-Kodiert in einer Datei
     * @param destFile Dateiname
     */
    public void writeToFile(String destFile) throws Exception
    {
        // TODO
    }

    /**
     * Speichert Schlüssel Base64-Kodiert in einer Datei
     *
     * @param destFile Dateiname
     */
    public void saveKey(String destFile) throws Exception
    {
        // TODO
    }
}