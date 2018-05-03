package structural.decorator;

import java.io.*;
import java.nio.file.*;

public class FileDataSource implements DataSource {
    private File file;
    
    public FileDataSource(String name) {
        this.file = new File(name);
    }
    
    @Override
    public void writeData(String data) {
        try {
            Files.write(
                file.toPath(), 
                data.getBytes()
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public String readData() {
        var buffer = "";
        
        try {
            buffer = new String(
                Files.readAllBytes(file.toPath())
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return buffer;
    }
}