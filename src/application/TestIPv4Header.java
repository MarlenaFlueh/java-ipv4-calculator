package application;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIPv4Header {

    //Testet die Ausgabe der eingegebenen dezimalen Werte (Notwendig f�r Note 4)
    @Test
    public void testGetOutputCase1()
    {
        IPv4Header ip = new IPv4Header("4-24-0-2-0-128-0-192.168.1.1-192.168.2.1");
        assertEquals("4-5-24-1440-0-2-0-128-0-0-192.168.1.1-192.168.2.1", ip.getOutput());

    }

    @Test
    public void testGetOutputCase2()
    {
        IPv4Header ip = new IPv4Header("4-24-0-1-0-120-0-1.1.1.1-2.2.2.2");
        assertEquals("4-5-24-1440-0-1-0-120-0-0-1.1.1.1-2.2.2.2", ip.getOutput());

    }

    @Test
    public void testGetOutputCase3()
    {
        IPv4Header ip = new IPv4Header("4-24-0-0-0-30-0-192.168.1.1-8.8.8.8");
        assertEquals("4-5-24-1440-0-0-0-30-0-0-192.168.1.1-8.8.8.8", ip.getOutput());
    }

    @Test
    public void testGetOutputCase4()
    {
        IPv4Header ip = new IPv4Header("4-24-0-2-0-128-0-0.0.0.0-192.168.2.1");
        assertEquals("4-5-24-1440-0-2-0-128-0-0-0.0.0.0-192.168.2.1", ip.getOutput());

    }

    // own tests
    @Test
    public void testGetOutputCase5()
    {
        IPv4Header ip = new IPv4Header("4-24-0-2-0-64-0-192.168.0.0-192.168.0.1");
        assertEquals("4-5-24-1440-0-2-0-64-0-0-192.168.0.0-192.168.0.1", ip.getOutput());

    }

    @Test
    public void testGetOutputCase6()
    {
        IPv4Header ip = new IPv4Header("4-24-0-0-0-96-0-3.3.3.3-4.4.4.4");
        assertEquals("4-5-24-1440-0-0-0-96-0-0-3.3.3.3-4.4.4.4", ip.getOutput());

    }

    //Testet die Ausgabe der bin�ren Form der eingegebenen dezimalen Werte (Notwendig f�r Note 3)
    @Test
    public void testGetOutputBinCase1()
    {
        IPv4Header ip = new IPv4Header("4-24-0-2-0-128-0-192.168.1.1-192.168.2.1");
        assertEquals("0100 0101 00011000 0000010110100000 0000000000000000 010 0000000000000 10000000 00000000 0000000000000000 11000000101010000000000100000001 11000000101010000000001000000001", ip.getOutputBin());
    }

    @Test
    public void testGetOutputBinCase2()
    {
        IPv4Header ip = new IPv4Header("4-24-0-1-0-120-0-1.1.1.1-2.2.2.2");
        assertEquals("0100 0101 00011000 0000010110100000 0000000000000000 001 0000000000000 01111000 00000000 0000000000000000 00000001000000010000000100000001 00000010000000100000001000000010", ip.getOutputBin());
    }

    @Test
    public void testGetOutputBinCase3()
    {
        IPv4Header ip = new IPv4Header("4-24-0-0-0-30-0-192.168.1.1-8.8.8.8");
        assertEquals("0100 0101 00011000 0000010110100000 0000000000000000 000 0000000000000 00011110 00000000 0000000000000000 11000000101010000000000100000001 00001000000010000000100000001000", ip.getOutputBin());
    }

    @Test
    public void testGetOutputBinCase4()
    {
        IPv4Header ip = new IPv4Header("4-24-0-2-0-128-0-0.0.0.0-192.168.2.1");
        assertEquals("0100 0101 00011000 0000010110100000 0000000000000000 010 0000000000000 10000000 00000000 0000000000000000 00000000000000000000000000000000 11000000101010000000001000000001", ip.getOutputBin());
    }

    // own test
    @Test
    public void testGetOutputBinCase5()
    {
        IPv4Header ip = new IPv4Header("4-24-0-1-0-64-0-192.168.0.0-192.168.0.1");
        assertEquals("0100 0101 00011000 0000010110100000 0000000000000000 001 0000000000000 01000000 00000000 0000000000000000 11000000101010000000000000000000 11000000101010000000000000000001", ip.getOutputBin());
    }

    //Testet die Ausgabe der eingegebenen bin�ren Werte in der dezimalen Darstellung (Notwendig f�r Note 2)
    @Test
    public void testGetOutputBinToDecCase1()
    {
        IPv4Header ip = new IPv4Header("0100 0101 00011000 0000010110100000 0000000000000000 010 0000000000000 10000000 00000000 0000000000000000 11000000101010000000000100000001 11000000101010000000001000000001");
        assertEquals("4-5-24-1440-0-2-0-128-0-0-192.168.1.1-192.168.2.1", ip.getOutputBinToDec());
    }

    @Test
    public void testGetOutputBinToDecCase2()
    {
        IPv4Header ip = new IPv4Header("0100 0101 00011000 0000010110100000 0000000000000000 001 0000000000000 01111000 00000000 0000000000000000 00000001000000010000000100000001 00000010000000100000001000000010");
        assertEquals("4-5-24-1440-0-1-0-120-0-0-1.1.1.1-2.2.2.2", ip.getOutputBinToDec());

    }

    @Test
    public void testGetOutputBinToDecCase3()
    {
        IPv4Header ip = new IPv4Header("0100 0101 00011000 0000010110100000 0000000000000000 000 0000000000000 00011110 00000000 0000000000000000 11000000101010000000000100000001 00001000000010000000100000001000");
        assertEquals("4-5-24-1440-0-0-0-30-0-0-192.168.1.1-8.8.8.8", ip.getOutputBinToDec());

    }

    @Test
    public void testGetOutputBinToDecCase4()
    {
        IPv4Header ip = new IPv4Header("0100 0101 00011000 0000010110100000 0000000000000000 010 0000000000000 10000000 00000000 0000000000000000 00000000000000000000000000000000 11000000101010000000001000000001");
        assertEquals("4-5-24-1440-0-2-0-128-0-0-0.0.0.0-192.168.2.1", ip.getOutputBinToDec());
    }

    // own test
    @Test
    public void testGetOutputBinToDecCase5()
    {
        IPv4Header ip = new IPv4Header("0100 0101 00011000 0000010110100000 0000000000000000 001 0000000000000 01000000 00000000 0000000000000000 11000000101010000000000000000000 11000000101010000000000000000001");
        assertEquals("4-5-24-1440-0-1-0-64-0-0-192.168.0.0-192.168.0.1", ip.getOutputBinToDec());
    }

    // tests the checksum
    @Test
    public void testGetOutputBinCheckCase1()
    {
        Checksum newCheck = new Checksum("0100 0101 00011000 0000010110100000 0000000000000000 010 0000000000000 10000000 00000000 0000000000000000 11000000101010000000000100000001 11000000101010000000000100000001");
        assertEquals("1111110101011111111011110111010", newCheck.getOutputBin());
    }

    // res without complement
    @Test
    public void testGetOutputBinCheckCase2()
    {
        Checksum newCheck = new Checksum("0100 0101 00011000 0000010110100000 0000000000000000 010 0000000000000 10000000 00000000 0000000000000000 11000000101010000000000100000001 11000000101010000000000100000001");
        assertEquals("110000001010100000000100001000101", newCheck.getOutputBin());
    }

}
