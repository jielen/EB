package com.ufgov.gk.common.system.util;

import java.io.UnsupportedEncodingException;

public class Hex {

    private static final char[] DIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    public static String encodeToString(byte[] bytes) {
        char[] encodedChars = encode(bytes);
        return new String(encodedChars);
    }

    /**
     * ����Ϊ16����
     * @param data
     * @return
     */
    public static char[] encode(byte[] data) {

        int l = data.length;

        char[] out = new char[l << 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS[0x0F & data[i]];
        }

        return out;
    }

    /**
     * ����
     * @param array
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] decode(byte[] array) throws UnsupportedEncodingException {
        String s = new String(array, "utf-8");
        return decode(s);
    }

    public static byte[] decode(String hex) {
        return decode(hex.toCharArray());
    }

    public static byte[] decode(char[] data) throws IllegalArgumentException {

        int len = data.length;

        if ((len & 0x01) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }

        byte[] out = new byte[len >> 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }
    
    public static String decodeToString(byte[] source) throws IllegalArgumentException, UnsupportedEncodingException {
      byte[] temp = decode(source);
      return new String(temp);
    }

    protected static int toDigit(char ch, int index) throws IllegalArgumentException {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new IllegalArgumentException("Illegal hexadecimal charcter " + ch + " at index " + index);
        }
        return digit;
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {

      String ori = Hex.decodeToString("2020202033".getBytes());
      System.out.println(ori);
      
      
    }

}
