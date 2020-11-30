package encryptdecrypt.DataUtil;

public class DataPrinter implements DataWriter {

    @Override
    public void writeData(String data) {
        System.out.println(data);
    }
}
