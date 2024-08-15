package practice.ascii;

public class Main {
    public static void main(String[] args) {
        // char to ascii
        char ch = 'A';
        int asciiVal = (int) ch;
        System.out.println(asciiVal);
        // ascii to char
        char ch2 = (char) asciiVal;
        System.out.println(ch2);
        // String to ascii
        String hello = "hello!";
        for(char c: hello.toCharArray()){
            System.out.print((int)c + " ");
        }

        // (char) (int) -> explicit casting
        int number = 130;
        byte smallNum = (byte) number;
        // int -> byte : get only 8bit of int, others lost
        // -126
        // int:32bit byte:8bit
        // 130 = '00000000 00000000 00000000 10000010';
        // 2*1 + 2^7*1 = 2 + 128 = 130
        // byte get 8 bit: '10000010';
        System.out.println(smallNum);

        // hint: byte = '8bit' = 2^8 = 256
        // -128~127 = 256, 2^7 = 128. position of 2^8 = definition +/-
        // calculate mechanism
        // 10000010 -> reverseAll -> 01111101 -> add 1 -> 01111110 -> 126

        // mechanism?
        // two's complement: easy to use minusValue
        // 000000111(7) -> 11111000 -> 11111001(-7)
        // 6 + (-3)
        // 0110 + (-0011)?
        // 3 is 0011 -> 1100 -> 1101 is -3
        // 0110 + 1101 = 10011
        // carry bit: this example use 4bit, ignore 5bit(1)
        // = 0011, 6 + (-3) = 3;

        // 4 bit? 2^4 = 16, range:-8~+7
        // overflow
        // (+) + (+) -> MSB(Most Significant Bit) == 1 ? overflow : not;
        // 0111 + 0001 = 10000 = 8, out of range = overflow
        // (-) + (-) -> MSB(Most Significant Bit) == 0 ? overflow : not;
        // let -> (-5) + (-4)
        // 5 = 0101 -> 1010 -> 1011 = -5
        // 4 = 0100 -> 1011 -> 1100 = -4
        // 1011 + 1100 = 10111 = 0111 = 7?!
        // 10111(X) 0111(O) cause it is 4bit, and MSB is 0 -> OVERFLOW

        // One's Complement 1の補数: need overflow carry
        // 0000 -> 1111, reverseAll
        // +0   -> -0
        // Two's Complement 2の補数
        // reverseAll -> +1

        // java
        // byte = 8bit = 2^8
        // short = 16bit = 2^16
        // int = 32bit = 2^32
        // long = 64bit = 2^64

    }
}
