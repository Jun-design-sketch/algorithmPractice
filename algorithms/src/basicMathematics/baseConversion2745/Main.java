package basicMathematics.baseConversion2745;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static int ALL_ALPHABET = 26;
    public static int ASCII_VALUE_0 = 48;
    public static int ASCII_VALUE_9 = 58;
    public static int ASCII_VALUE_A = 65;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        String number = st.nextToken();
        int base = Integer.parseInt(st.nextToken());
        br.close();

        HashMap<Character,Integer> map = new HashMap();
        for(int i=0; i<ALL_ALPHABET; i++){
            map.put((char)(ASCII_VALUE_A+i),(10+i));
        }

        char[] chArr = number.toCharArray();
        int tenBase = 0;
        for(int j=0; j<chArr.length; j++){
            int squared = (int)Math.pow(base, j);
            int curArrPos = chArr.length-1-j;
            if(chArr[curArrPos] <= ASCII_VALUE_9){
                int num = (int)chArr[curArrPos] - ASCII_VALUE_0;
                tenBase += num*squared;
            }else{
                tenBase += map.get(chArr[curArrPos])*squared;
            }
        }
        bw.write(""+tenBase);
        bw.flush();
        bw.close();
    }
}