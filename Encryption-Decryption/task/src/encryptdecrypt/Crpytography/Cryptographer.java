package encryptdecrypt.Crpytography;

abstract public class Cryptographer {
    String rawData;
    int key;
    String processedData;
    boolean isConfigSet = false;

    public void setConfig(String rawData, int key) {
        this.key = key;
        this.rawData = rawData;
        isConfigSet = true;
    }

    abstract void processData();

    public void run() {
        if (isConfigSet) {
            processData();
        }
    }

    public String getProcessedData() {
        return this.processedData;
    }
}
