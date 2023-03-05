package DataLayer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterClass {
    public FileWriterClass(){};

    public void write(String name, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(name);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(text);
        printWriter.close();
    }
}
