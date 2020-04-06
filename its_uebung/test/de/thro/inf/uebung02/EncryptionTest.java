package de.thro.inf.uebung02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionTest {
    static Encryption encryption = null;

    @BeforeAll
    static void SetUp() {
        encryption = new Encryption();
    }

    @AfterAll
    static void TearDown() {
        encryption = null;
    }

    @Test
    void readFromFile() {
        assertDoesNotThrow(()->encryption.readFromFile("test/de/thro/inf/uebung02/secret_file.txt"));

        assertEquals("Hello this is a secret!" , new String(encryption.getData()));
    }

    @Test
    void generateKey() {
        assertDoesNotThrow(()->encryption.generateKey());
    }

    @Test
    void encryptFileExists() {
        assertDoesNotThrow(()->encryption.readFromFile("test/de/thro/inf/uebung02/secret_file.txt"));
        assertDoesNotThrow(()->encryption.generateKey());
        assertDoesNotThrow(()->encryption.encrypt());
    }

    @Test
    void encryptFileNotExists() {
        assertThrows(NoSuchFileException.class,()->encryption.encrypt());
    }

    @Test
    void writeToFile() {
        assertDoesNotThrow(()->encryption.readFromFile("test/de/thro/inf/uebung02/secret_file.txt"));
        assertDoesNotThrow(()->encryption.generateKey());
        assertDoesNotThrow(()->encryption.encrypt());
        assertDoesNotThrow(()->encryption.writeToFile("test/de/thro/inf/uebung02/encrypted_file.txt"));

        assertDoesNotThrow(()->encryption.readFromFile("test/de/thro/inf/uebung02/encrypted_file.txt"));
        assertEquals(new String(Base64.getEncoder().encode(encryption.getEncryptedData())), new String(encryption.getData()));
    }

    @Test
    void saveKey() {
        assertDoesNotThrow(()->encryption.generateKey());
        assertDoesNotThrow(()->encryption.saveKey("test/de/thro/inf/uebung02/secret_key.txt"));
    }
}