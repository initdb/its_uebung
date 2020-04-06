package de.thro.inf.uebung02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DecryptionTest {

    static Encryption encryption = null;
    static Decryption decryption = null;

    @BeforeAll
    static void SetUp() {
        encryption = new Encryption();
        decryption = new Decryption();

        assertDoesNotThrow(()->encryption.readFromFile("test/de/thro/inf/uebung02/secret_file.txt"));
        assertDoesNotThrow(()->encryption.generateKey());
        assertDoesNotThrow(()->encryption.encrypt());
        assertDoesNotThrow(()->encryption.writeToFile("test/de/thro/inf/uebung02/encrypted_file.txt"));
        assertDoesNotThrow(()->encryption.saveKey("test/de/thro/inf/uebung02/secret_key.txt"));
    }

    @AfterAll
    static void TearDown() {
        encryption = null;
        decryption = null;
    }

    @Test
    void readFromFileBase64() {
        assertDoesNotThrow(()->decryption.readFromFileBase64("test/de/thro/inf/uebung02/encrypted_file.txt"));
    }

    @Test
    void readKey() {
        assertDoesNotThrow(()->decryption.readKey("test/de/thro/inf/uebung02/secret_key.txt"));
    }

    @Test
    void decrypt() {
        assertDoesNotThrow(()->decryption.readFromFileBase64("test/de/thro/inf/uebung02/encrypted_file.txt"));
        assertDoesNotThrow(()->decryption.readKey("test/de/thro/inf/uebung02/secret_key.txt"));
        String result = null;
        try {
            result = decryption.decrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(new String(encryption.getData()), result);
    }
}