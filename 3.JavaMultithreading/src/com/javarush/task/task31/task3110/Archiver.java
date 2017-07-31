package com.javarush.task.task31.task3110;





import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by Anton on 26.07.2017.
 */
public class Archiver {
    public static void main(String[] args) throws IOException {

        ConsoleHelper.writeMessage("Please enter full path to archiver: ");
        try {
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(ConsoleHelper.readString()));
            System.out.println("Please enter full path to file will compressed: ");
            zipFileManager.createZip(Paths.get(ConsoleHelper.readString()));
        } catch (Exception e) {
        }
    }
}
