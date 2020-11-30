package encryptdecrypt.Crpytography;

public class CryptographyFactory {
    public static Cryptographer build(String alg, String mode) {
        Cryptographer cryptographer = null;
        if (alg.equals("unicode")) {
            if (mode.equals("dec")) {
                cryptographer = new UnicodeDecoder();
            } else if (mode.equals("enc")) {
                cryptographer = new UnicodeEncoder();
            }
        } else if (alg.equals("shift")) {
            if (mode.equals("dec")) {
                cryptographer = new CipherDecoder();
            } else if (mode.equals("enc")) {
                cryptographer = new CipherEncoder();
            }
        }
        return cryptographer;
    }
}
