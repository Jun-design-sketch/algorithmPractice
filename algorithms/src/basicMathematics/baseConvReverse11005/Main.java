package basicMathematics.baseConvReverse11005;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static int ALL_ALPHABET = 26;
    public static int ASCII_VALUE_A = 65;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        final int number = Integer.parseInt(st.nextToken());
        final int base = Integer.parseInt(st.nextToken());
        br.close();

        HashMap<Integer,Character> map = new HashMap();
        for(int i=0; i<ALL_ALPHABET; i++){
            map.put((10+i),(char)(ASCII_VALUE_A+i));
        }

        int quotient = number/base;
        int remainder = number%base;
        StringBuilder sb = new StringBuilder();
        while(quotient != 0){
            if(remainder > 9){
                sb.append(map.get(remainder));
            }else{
                sb.append(remainder);
            }
            remainder = quotient%base;
            quotient /= base;
        }
        if(remainder > 9){
            sb.append(map.get(remainder));
        }else{
            sb.append(remainder);
        }
        sb.reverse();

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

        // 2進数の10101＝21
        // 21 / 2 = 10 ...1
        // 10 / 2 = 5 ...0
        // 5 / 2 = 2 ...1
        // 2 / 2 = 1 ...0
        // 1 / 2 = 0 ...1
        // 3進数の21001＝190
        // 190 / 3 = 63 ...1
        // 63 / 3 = 21 ...0
        // 21 / 3 = 7 ...0
        // 7 / 3 = 2 ...1
        // 2 / 3 = 0 ...2
        // 割り算することは、進数の計算を逆順にやっていくだけになる
    }
}
