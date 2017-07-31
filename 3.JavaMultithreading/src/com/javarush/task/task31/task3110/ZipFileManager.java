package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Anton on 26.07.2017.
 */
public class ZipFileManager {
    private final Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    //Archiver (2)
    public void createZip(Path source) throws Exception{
        try(ZipOutputStream zipOutputStream=new ZipOutputStream(Files.newOutputStream(zipFile));){
            ZipEntry zipEntry=new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry);
            try(InputStream inputStream=Files.newInputStream(source)){
                byte[] buffer=new byte[1024];
                while (inputStream.available()>0){
                    inputStream.read(buffer);
                    zipOutputStream.write(buffer);
                    zipOutputStream.flush();
                }
            }
            zipOutputStream.closeEntry();
        }
    }
}
