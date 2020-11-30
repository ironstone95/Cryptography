package encryptdecrypt.Crpytography;

class UnicodeEncoder extends Cryptographer {
    @Override
    void processData() {
        StringBuilder builder = new StringBuilder(rawData.length());
        for (char c : rawData.toCharArray()) {
            builder.append((char) (c + key));
        }
        this.processedData = builder.toString();
    }
}
