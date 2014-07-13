package com.keepassdroid.tests.database;

import com.keepassdroid.database.PwDatabase;
import com.keepassdroid.database.exception.InvalidDBException;
import com.keepassdroid.database.load.Importer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DatabaseUtil {
    public static PwDatabase openDatabase(Importer importer, InputStream is, String password,
                                          String keyfile)
            throws IOException, InvalidDBException
    {
        FileInputStream keyfileStream = new FileInputStream("/sdcard/key");
        try {
            return importer.openDatabase(is, password, keyfileStream);
        } finally {
            try {
                keyfileStream.close();
            } catch (IOException ignore) {}
        }
    }
}
