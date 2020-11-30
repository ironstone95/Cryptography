package encryptdecrypt.Crpytography;

class CipherDecoder extends Cryptographer {

    @Override
    void processData() {
        StringBuilder builder = new StringBuilder(rawData.length());
        for (char c : rawData.toCharArray()) {
            char toAppend = c;
            if (c >= 97 && c <= 122) {
                int index = (((c - 97 - key) + 26) % 26);
                toAppend = (char) (index + 97);
            } else if (c >= 65 && c <= 90) {
                int index = (((c - 65 - key) + 26) % 26);
                toAppend = (char) (index + 65);
            }
            builder.append(toAppend);
        }
        processedData = builder.toString();
    }
}
