package application;

import java.util.stream.IntStream;

public class Checksum {

    private static String headerAddressBinary;

    // constructor parameter is the binary header address
    public Checksum(String headerAddress) {
        this.headerAddressBinary = headerAddress;
    }

    public String calculateSum() {

        String[] binArray = headerAddressBinary.split(" ");
        int[] intArray = new int[binArray.length];

        for (int i = 0; i < binArray.length; i++) {
            int val = Integer.parseUnsignedInt(binArray[i], 2);
            intArray[i] = val;
        }

        int sum = IntStream.of(intArray).sum();

        String result = Integer.toBinaryString(sum);

        char[] convertedChars = new char[result.length()];
        char[] array = result.toCharArray();

        for (int i = 0; i < array.length; i++) {
            boolean checkNull = array[i] == '0';
            convertedChars[i] = checkNull ? '1' : '0';
        }

        String.valueOf(convertedChars);
        return Integer.toString(sum);
    }

    // method returns checksum, called in Main.java
    public String getOutputBin() {
        return calculateSum();
    }
}
