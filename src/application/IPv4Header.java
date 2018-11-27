package application;

import java.util.ArrayList;

public class IPv4Header {

    // get values from constructor
    private int version;
    private int ttl;
    private int flags;
    private int tos;
    private int identifier;
    private int fragmentOffset;
    private int protocol;

    private String sourceIp;
    private String targetIp;
    private String binaryValue;

    // length of each IPv4 header fields
    private int versionLength = 4;
    private int ihlLength = 4;
    private int tosLength = 8;
    private int fullLengthLength = 16;
    private int identifierLength = 16;
    private int flagsLength = 3;
    private int fragmentOffsetLength = 13;
    private int ttlLength = 8;
    private int protocolLength = 8;
    private int checkSumLength = 16;

    // hardcoded values of IPv4 fields
    private int ihl = (versionLength + ihlLength + tosLength + fullLengthLength +
            identifierLength + flagsLength + fragmentOffsetLength + ttlLength + protocolLength +
            checkSumLength + 64) / 32;
    private int checkSum = 0;
    private int fullLength = 1440;

    /*
    * constructor, called in Main.java and gets user input
    * uses binaryCheck method to proof if IPv4 header input is binary or decimal
    */
    public IPv4Header(String input) {

        if (binaryCheck(input)) {
            this.binaryValue = input;
        } else {
            String[] addressStringAr = input.split("-");
            Integer[] addressIntAr = new Integer[addressStringAr.length];

            for (int i = 0; i < addressStringAr.length - 2; i++)
                addressIntAr[i] = Integer.parseInt(addressStringAr[i]);

            this.version = addressIntAr[0];
            this.tos = addressIntAr[1];
            this.identifier = addressIntAr[2];
            this.flags = addressIntAr[3];
            this.fragmentOffset = addressIntAr[4];
            this.ttl = addressIntAr[5];
            this.protocol = addressIntAr[6];
            this.sourceIp = addressStringAr[7];
            this.targetIp = addressStringAr[8];
        }

    }

    /*
    * checks if method parameter is binary or decimal
    * used by constructor to check input
    */
    public boolean binaryCheck(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '0' && c != '1' && c != ' ') {
                return false;
            }
        }
        return true;
    }

    //creates ArrayList with all IPv4 fields
    public ArrayList<Integer> createArrayList() {
        ArrayList<Integer> ar = new ArrayList<>();

        ar.add(version);
        ar.add(ihl);
        ar.add(tos);
        ar.add(fullLength);
        ar.add(identifier);
        ar.add(flags);
        ar.add(fragmentOffset);
        ar.add(ttl);
        ar.add(protocol);
        ar.add(checkSum);

        return ar;
    }

    /*
    *  called in Main.java
    *  returns full binary output
    *  creates instance of ConvertToBinary class
    *  creates two arrays and parses them as parameters
    */
    public String getOutputBin() {
        int[] fieldsLength = {versionLength, ihlLength, tosLength, fullLengthLength, identifierLength, flagsLength,
                fragmentOffsetLength, ttlLength, protocolLength, checkSumLength};
        int[] fields = {version, ihl, tos, fullLength, identifier, flags, fragmentOffset, ttl, protocol, checkSum};

        ConvertToBinary ipv4Binary = new ConvertToBinary(fields, fieldsLength, this.sourceIp, this.targetIp);
        return ipv4Binary.getOutputBin();
    }

    /*
    *  converts full binary IPv4 header to decimal value
    *  returns result
    *  called in Main.java
    *  creates instance of ConvertBinaryToString class
    *  parses binaryValue from Main.java as parameter for output method
    */
    public String getOutputBinToDec() {
        ConvertBinaryToString ipv4String = new ConvertBinaryToString(binaryValue);
        return ipv4String.getOutputBinToDec();
    }

    /*
    *  called in Main.java
    *  returns full decimal IPv4 header
    *  creates instance of ConvertToString class
    *  calls method createArrayList and parses it as parameter
    */
    public String getOutput() {
        ConvertToString ipv4String = new ConvertToString(this.sourceIp, this.targetIp, createArrayList());
        return ipv4String.getOutput();
    }

}
