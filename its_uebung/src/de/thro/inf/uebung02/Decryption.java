package de.thro.inf.uebung02;

import java.io.FileInputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

/**
 * Created by
 * User: Hue
 * Date: 07.02.2012
 * Time: 11:27:17
 */
public class Decryption {
    private byte[] data;
    private byte[] encryptedData;
    private Key key;
    private Cipher cipher;

    private static final String cipherAlgorithm = "AES/ECB/PKCS5Padding";
    private static final String algorithm = "AES";

    /**
     * Liest Base64-Kodierte Datei zum Entschlüsseln ein
     * und dekodiert die Base64-Kodierung
     *
     * @param inputFile   Dateiname
     */
    public void readFromFileBase64(String inputFile)throws Exception
    {
        // TODO
    }

    /**
     * Liest symmetrischen Schlüssel aus Datei ein
     * und dekodiert die Base64-Kodierung
     *
     * @param inputFile  Dateiname
     */
    public void readKey(String inputFile) throws Exception
    {
        // TODO
    }

    /**
     *  Entschlüsselt die Daten
     *  @pre Daten sind aus Datei eingelesen, Schlüssel eingelesen
     *
     * @return  entschlüsselte Daten
     */
    public String decrypt()throws Exception
    {
        // TODO
        return null;
    }
}