package Application;

import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileCreator {

    @SneakyThrows
    public static FileOutputStream createXLSFile(String name){
        FileOutputStream out;
        try {
            out = new FileOutputStream(name);
        } catch (IOException e){
            System.err.println("File can`t create or he has state - reading. Create error.xls!!!");
            out = new FileOutputStream("error.xls");
        }
        return out;
    }
}
