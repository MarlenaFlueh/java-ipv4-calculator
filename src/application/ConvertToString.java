package application;

import java.util.ArrayList;

public class ConvertToString {

    // values necessary for methods
    private String sourceIp;
    private String targetIp;
    private ArrayList<Integer> arrayList;

    // constructor, called in IPv4Header.java
    public ConvertToString(String sourceIp, String targetIp, ArrayList<Integer> arrayList) {
        this.sourceIp = sourceIp;
        this.targetIp = targetIp;
        this.arrayList = arrayList;
    }

    // iterates over arrayList with field values, returns String with dashes
    public String getFields() {
        ArrayList<Integer> intList = arrayList;
        String res = "";

        for(Integer item : intList) {
            res += item + "-";
        }

        return res;
    }

    // called in Main.java, return full decimal IPv4 header
    public String getOutput() {
        return getFields() + this.sourceIp + "-" + this.targetIp;
    }


}
