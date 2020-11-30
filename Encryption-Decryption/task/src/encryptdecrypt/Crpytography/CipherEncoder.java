package encryptdecrypt.Crpytography;

class CipherEncoder extends Cryptographer {
    @Override
    void processData() {
        StringBuilder builder = new StringBuilder();
        for (char c : rawData.toLowerCase().toCharArray()) {
            if (c >= 97 && c <= 122) {
                builder.append(shiftedChar(c, 97));
            } else if (c >= 65 && c <= 90) {
                builder.append(shiftedChar(c, 65));
            } else {
                builder.append(c);
            }
        }
        processedData = builder.toString();
    }

    private char shiftedChar(char c, int zeroth) {
        int index = c + key - zeroth;
        return (char) (index % 26 + zeroth);
    }
}
