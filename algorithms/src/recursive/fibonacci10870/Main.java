package recursive.fibonacci10870;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int answer = getLastFibonacci(n, 0, 0, 1);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static int getLastFibonacci(int count, int beforeNum, int curNum, int nextNum) {
        if(count == 0) return 0;
        beforeNum = curNum;
        curNum = nextNum;
        nextNum = beforeNum + curNum;
        count--;

        if(count > 0) return getLastFibonacci(count, beforeNum, curNum, nextNum);
        else return curNum;
    }
}