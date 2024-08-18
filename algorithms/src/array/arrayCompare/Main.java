package array.arrayCompare;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        // array of firstLine
        String firstLineStr[] = br.readLine().split(" ");
        // numberCount of second line
        int n = Integer.parseInt(firstLineStr[0]);
        // targetNumber
        int x = Integer.parseInt(firstLineStr[1]);
        // array of secondLine
        String secondLineStr[] = br.readLine().split(" ");
        // convert int, filter, count
        int answer[] = Arrays.stream(secondLineStr)
                .mapToInt(Integer::parseInt)
                .filter(el -> el < x)
                .toArray();
        // formatting
        for(int i=0; i<answer.length; i++){
            sb.append(answer[i]);
            // do not calculate.add " " after final el
            if_(i != answer.length-1){
                sb.append(" ");
            }
        }
        // output
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
