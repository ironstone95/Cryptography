package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        try {
            EncryptDecrypt encryptDecrypt = new EncryptDecrypt(args);
            encryptDecrypt.runProgram();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}