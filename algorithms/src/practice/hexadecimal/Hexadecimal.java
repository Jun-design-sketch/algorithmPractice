package practice.hexadecimal;

import java.awt.*;

public class Hexadecimal {
    public static void main(String[] args) {
        // Hexadecimal? 16進数
        // 0 = 0, 1 = 1, ... 9 = 9, A = 10, B = 11, C = 12, D = 13, E = 14, F = 15
        // 1 hexadecimal expression = has 16 meaning

        // bit? 0 or 1, bit SHOULD BE binary
        // 1 binary expression = has 2 meaning

        // 1 hexadecimal expression = 4 binary expression
        // 16 = 2^4
        // In other word, 1 hexadecimal = 4 bit

        // byte? 8bit. 1 byte? 2 hexadecimal expression.
        // hexadecimal to int
        String hexStr1 = "1A3F";
        // (1 * 16^3) + (10 * 16^2) + (3 * 16) + (15 * 1) = 4096 + 2560 + 48 + 15 = 6719
        int decimalValue = Integer.parseInt(hexStr1, 16);
        System.out.println("Hexadecimal: " + hexStr1);
        System.out.println("Decimal: " + decimalValue);

        // int to hexadecimal
        int number = 22222;
        String hexStr2 = Integer.toHexString(number).toUpperCase();
        System.out.println("Decimal: " + number);
        System.out.println("Hexadecimal: " + hexStr2);

        // byte to hexadecimal
        // 0x : prefix used to denote hexadecimal literals
        byte[] bytes = {0x1A, 0x7F, (byte) 0xFF}; // 0xFF = 16*15 + 15 = 255, -128 < byte < 127.
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            // %X = hexadecimal, 02 = output minimum length
            sb.append(String.format("%02X", b));
        }
        System.out.println("Hexadecimal String: " + sb);

        // colorCode: each color has value: 0~255: 256? hexadecimal;
        // #RRGGBB : RR(red hexadecimal) GG(green) BB(blue)
        // #FF5733 : red(255) green(87) blue(51)
        int red = 255;
        int green = 87;
        int blue = 51;
        String hexCol = String.format("#%02X%02X%02X", red, green, blue);
        Color color = new Color(red, green, blue);
        System.out.println("HexColorCod: " + hexCol + " " + "ColorObject: " + color.toString());

        // memory address: C or C++ could express and work with it.. java hashcode
        Object obj = new Object();
        int hashCode = obj.hashCode();
        String hexAdd = String.format("%08X", hashCode);
        System.out.println("Object Hashcode in Hex: " + hexAdd);
        // linux
        // "ps aux", "ps -e | grep <process_name>", "top", "pgrep <process_name>"
        // pmap <pid>
        // mac
        // vmmap <pid>
    }
}
