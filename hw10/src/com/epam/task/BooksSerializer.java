package com.epam.task;

import java.io.*;

public class BooksSerializer {
    public void serializeBooks(Books books, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(books);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public Books deserializeBooks(String filename) throws FileNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)) ) {
            return (Books)ois.readObject();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
