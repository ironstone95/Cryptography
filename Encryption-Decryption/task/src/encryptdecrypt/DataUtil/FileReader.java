package encryptdecrypt.DataUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader implements DataReader {
    private final File file;
    private String data;

    public FileReader(File file) {
        this.file = file;
        readFile();
    }

    public void readFile() {
        StringBuilder builder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.data = builder.toString();
    }

    @Override
    public String getData() {
        return this.data;
    }
}
