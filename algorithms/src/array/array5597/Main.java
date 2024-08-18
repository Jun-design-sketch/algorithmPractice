package array.array5597;

import java.io.*;
import java.util.stream.IntStream;

// who forget homework?
public class Main {
    public static int SUBMITTED_NUMBER = 28;
    public static int ALL_MEMBER = 30;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // line input 28times, attendance number: 1 to 30
        int[] submitted = new int[ALL_MEMBER];
        for(int i=0; i<SUBMITTED_NUMBER; i++){
            int attendanceNumber = Integer.parseInt(br.readLine());
            submitted[attendanceNumber-1] = attendanceNumber;
        }
        // find value 0's key
        int[] whoForgot = IntStream.range(0, submitted.length) // start<=range<end
                                .filter(i -> submitted[i] == 0) // get index that value is 0
                                .map(i -> i + 1) // calculate.add 1
                                .toArray(); // need only values, do not need boxed->toList
        // build string
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<whoForgot.length; j++){
            sb.append(whoForgot[j]);
            if_(j < whoForgot.length-1){
                sb.append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
