package encryptdecrypt.DataUtil;

public class ArgsDataReader implements DataReader {
    private final String data;

    public ArgsDataReader(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return this.data;
    }
}
