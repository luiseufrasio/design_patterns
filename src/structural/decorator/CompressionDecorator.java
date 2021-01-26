package structural.decorator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator {
    private int compressionLevel = 6;
    
    public CompressionDecorator(DataSource ds) {
        super(ds);
    }
    
    public int getCompressionLevel() {
        return compressionLevel;
    }
    
    public void setCompressionLevel(int compressionLevel) {
        this.compressionLevel = compressionLevel;
    }
    
    @Override
    public void writeData(String data) {
        super.writeData(
            compress(data)
        );
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }
    
    public String compress(String stringData) {
        byte[] data = stringData.getBytes();
        
        try (var bout = new ByteArrayOutputStream(512)) {
            var dos = new DeflaterOutputStream(
                            bout, new Deflater(compressionLevel));
            dos.write(data);
            dos.close();

            return Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }
        
    }
    
    public String decompress(String stringData) {
        byte[] data = Base64.getDecoder().decode(stringData);
        
        try (
            var in = new ByteArrayInputStream(data);
            var iin = new InflaterInputStream(in);
            var bout = new ByteArrayOutputStream(512);
        ) {
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }

            return new String(bout.toByteArray());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }
    
}