package application;

import java.util.Arrays;

// class converts binary IPv4 header back to decimal
public class ConvertBinaryToString {

    // store binary IPv4 header
    private String binaryValue;

    // constructor which expects binary IPv4 header as parameter
    public ConvertBinaryToString(String bin) {
        this.binaryValue = bin;
    }

    /*
    *  converts full binary IPv4 header to decimal value
    *  uses method ipBinaryToString to converts the ip addresses separate
    */
    public String getOutputBinToDec() {
        String[] binaryValues = this.binaryValue.split(" ");
        String[] shortArray = Arrays.copyOf(binaryValues, binaryValues.length-2);

        String ipSource = ipBinaryToString(binaryValues, binaryValues.length - 2);
        String ipTarget = ipBinaryToString(binaryValues, binaryValues.length - 1);

        String res = "";

        for (String item : shortArray) {
            int integerItem = Integer.parseUnsignedInt(item, 2);
            res += integerItem + "-";

        }

        return res.substring(0, res.length() - 1) + "-" + ipSource + "-" + ipTarget;

    }

    // converts ip addresses separate from binary to string
    public String ipBinaryToString(String[] array, int length) {

        int firstPart = Integer.parseUnsignedInt(array[length].substring(0, 8), 2);
        int secondPart = Integer.parseUnsignedInt(array[length].substring(8, 16), 2);
        int thirdPart = Integer.parseUnsignedInt(array[length].substring(16, 24), 2);
        int fourthPart = Integer.parseUnsignedInt(array[length].substring(24, 32), 2);

        return firstPart + "." + secondPart + "." + thirdPart + "." + fourthPart;

    }
}
