package beginner.number1550;

import java.io.*;

public class Main {
    private static final int BASE = 16;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int size = str.length();
        int exponent = size - 1;

        br.close();

        int sum = 0;
        for(int i = 0; i < size; i++) {
            char j = str.charAt(i);
            int val = (int)j;
            if(val < 58) val -= 48;
            else val -= 55;
            sum += val * (int)Math.pow(BASE, exponent);
            exponent--;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
