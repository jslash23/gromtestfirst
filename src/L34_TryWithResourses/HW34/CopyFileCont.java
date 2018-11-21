package L34_TryWithResourses.HW34;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;

public class CopyFileCont {

    public static void copyFileContent(String fileFromPath, String fileToPath) throws IOException {
        //Проверить что файлы есть +
        //проверить права +
        //Считать контент файла from
        //Записать контент файла from в вайл  to

        File sours = new File(fileFromPath);
        File dest = new File(fileToPath);
try{
    if ((dest.exists())) {
        Files.copy(sours.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
catch (FileAlreadyExistsException e) {
            System.err.println("File doesnt exist");
        }
    }


    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws IOException {
        File sours = new File(fileFromPath);
        File dest = new File(fileToPath);
        FileUtils.copyFile(sours, dest);
    }
}