package application;

import java.util.Scanner;// user test input 4, 2, 128, 192.168.1.1, 192.168.2.1

/*
* Main class, uses Scanner to read user inputs for all IPv4 header fields
* creates instance of IPv4Header class
* parses user inputs as parameters for constructor
* calls methods to get binary, decimal and from binary to decimal converted IPv4 headers
*/
public class Main {

    // values from user input
    private static String sourceIp;
    private static String targetIp;
    private static String version;
    private static String flags;
    private static String ttl;

    // hardcoded values of IPv4 fields
    private static String tos = "24";
    private static String identifier = "0";
    private static String fragmentOffset = "0";
    private static String protocol = "0";
    private static IPv4Header newIPv4;

    /*
    * reads user input
    * creates instance of IPv4Header class
    * calls methods of new instance
    * logs out binary, decimal and from binary to decimal IPv4 header
    */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Fill in source IP address.");
        sourceIp = scan.nextLine();
        System.out.println("Fill in target IP address.");
        targetIp = scan.nextLine();
        System.out.println("Fill in IPv4 version.");
        version = scan.nextLine();
        System.out.println("Fill in IPv4 flags.");
        flags = scan.nextLine();
        System.out.println("Fill in IPv4 ttl.");
        ttl = scan.nextLine();

        newIPv4 = new IPv4Header(getString());
        String binaryHeader = newIPv4.getOutputBin();
        Checksum newCheck = new Checksum(binaryHeader);

        System.out.println("Decimal solution: " + newIPv4.getOutput());
        System.out.println("Binary solution: " + binaryHeader);
        newIPv4 = new IPv4Header(binaryHeader);
        System.out.println("Convert binary to decimal: " + newIPv4.getOutputBinToDec());
        System.out.println("Checksum: " + newCheck.getOutputBin());
    }

    // method which returns IPv4 header values as constructor parameter
    private static String getString() {
        return version + "-" + tos + "-" + identifier + "-" + flags + "-" + fragmentOffset + "-" + ttl + "-" + protocol
                + "-" + sourceIp + "-" + targetIp;
    }

}
