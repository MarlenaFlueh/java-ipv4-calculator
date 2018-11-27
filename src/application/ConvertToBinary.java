package application;

public class ConvertToBinary {

    // values necessary for methods
    private int[] fields;
    private int[] fieldsLength;
    private String sourceIp;
    private String targetIp;

    /*
    *  constructor, called in IPv4Header.java
    *  gets values from constructor call in IPv4Header.java
    */
    public ConvertToBinary(int[] fields, int[] fieldsLength, String sourceIp, String targetIp) {
        this.fields = fields;
        this.fieldsLength = fieldsLength;
        this.sourceIp = sourceIp;
        this.targetIp = targetIp;
    }

    // called in Main.java, return full binary output
    public String getOutputBin() {
        return calcFirstHeaderPart(this.fields, this.fieldsLength) + " " + getIpAddressBin(this.sourceIp) + " " + getIpAddressBin(this.targetIp);
    }

    // converts first header part (IPv4 fields) from int to binary values
    public String calcFirstHeaderPart(int[] fields, int[] fieldsLength ) {

        String res = "";

        for (int i = 0; i < fields.length; i++) {
            res += this.intToString(fields[i], fieldsLength[i]) + " ";
        }

        return res.trim();
    }

    // converts int to binary String with leading zeros
    public String intToString(int num, int length) {

        String res = "";

        for(int i = 0; i < length; i++)
        {
            if(num % 2 == 1)
            {
                res = "1" + res;
            }
            if(num % 2 == 0)
            {
                res = "0" + res;
            }
            num = num / 2;
        }
        return res;
    }

    // converts int ip address to binary ip address
    public String getIpAddressBin(String ipAddress) {

        String[] integerStrings = ipAddress.split("\\.");
        String res = "";

        for (String item : integerStrings) {
            int intValue = Integer.parseInt(item);
            res += this.intToString(intValue, 8);
        }

        return res;

    }
}
