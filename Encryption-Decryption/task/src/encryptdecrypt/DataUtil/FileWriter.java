package encryptdecrypt.DataUtil;

import java.io.File;
import java.io.IOException;

public class FileWriter implements DataWriter {
    private final File file;

    public FileWriter(File file) {
        this.file = file;
    }

    @Override
    public void writeData(String data) {
        try (java.io.FileWriter fw = new java.io.FileWriter(file, false)) {
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
