package encryptdecrypt;

import encryptdecrypt.Crpytography.Cryptographer;
import encryptdecrypt.Crpytography.CryptographyFactory;
import encryptdecrypt.DataUtil.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncryptDecrypt {
    private static final List<String> argumentNames = List.of("-mode", "in", "-out", "-data", "-key", "-alg");
    private static final List<String> modeNames = List.of("enc", "dec");
    private static final List<String> algorithms = List.of("shift", "unicode");
    private final Map<String, String> arguments = new HashMap<>();
    private Cryptographer cryptographer = null;
    private DataReader dataReader = null;
    private DataWriter dataWriter = null;

    public EncryptDecrypt(String[] args) throws IllegalArgumentException {
        setArguments(args);
        setCryptographer();
        setDataReader();
        setDataWriter();
    }

    public void runProgram() {
        readData();
        this.cryptographer.run();
        writeData();
    }

    private void writeData() {
        String processData = this.cryptographer.getProcessedData();
        this.dataWriter.writeData(processData);
    }

    private void readData() {
        String rawData = dataReader.getData();
        int key = 0;
        try {
            key = Integer.parseInt(arguments.get("-key"));
        } catch (NumberFormatException ignored) {
        }
        cryptographer.setConfig(rawData, key);
    }

    private void setArguments(String[] args) throws IllegalArgumentException {
        for (int i = 0; i < args.length - 1; i += 2) {
            if (argumentNames.contains(args[i + 1])) {
                throw new IllegalArgumentException("Arguments cannot be empty. Empty Argument: " + args[i]);
            } else {
                arguments.put(args[i], args[i + 1]);
            }
        }
    }

    private void setCryptographer() throws IllegalArgumentException {
        String mode = arguments.get("-mode");
        if (mode != null) {
            if (!modeNames.contains(mode)) {
                throw new IllegalArgumentException("Mode cannot be \"" + mode + "\n. You can use, \"" + modeNames.toString() + "\n");
            }
        } else {
            mode = "enc";
        }

        String algorithm = arguments.get("-alg");

        if (algorithm != null) {
            if (!algorithms.contains(algorithm)) {
                throw new IllegalArgumentException("Algorithm cannot be \"" + algorithm + "\n. You can use, \"" + algorithms.toString() + "\n");
            }
        } else {
            algorithm = "shift";
        }

        this.cryptographer = CryptographyFactory.build(algorithm, mode);
    }

    private void setDataReader() throws IllegalArgumentException {
        String argumentData = arguments.get("-data");
        if (argumentData == null) {
            String filePath = arguments.get("-in");
            if (filePath == null) {
                this.dataReader = new ArgsDataReader("");
            } else {
                File file = new File(filePath);
                if (!file.exists()) {
                    throw new IllegalArgumentException("File path not found.");
                }
                this.dataReader = new FileReader(file);
            }
        }
    }

    private void setDataWriter() {
        String filePath = arguments.get("-out");
        if (filePath == null) {
            this.dataWriter = new DataPrinter();
        } else {
            File file = new File(filePath);
            this.dataWriter = new FileWriter(file);
        }
    }
}
