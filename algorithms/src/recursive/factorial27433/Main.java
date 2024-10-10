package recursive.factorial27433;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        long result;
        if(n < 1) result = 1;
        else result = getFactorial(n, 1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static long getFactorial(int number, long multiplied) {
        multiplied *= number;
        number--;
        if(number != 0) return getFactorial(number, multiplied);
        else return multiplied;
    }
}
