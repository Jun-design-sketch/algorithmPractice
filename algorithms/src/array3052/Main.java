package array3052;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static int ALL_LINE_NUMBERS = 10;
    public static int DIVIDED_NUMBER = 42;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // get input
        int[] inputs = new int[ALL_LINE_NUMBERS];
        for(int i=0; i<ALL_LINE_NUMBERS; i++){
            // condition: 0 < intElement <= 1000
            inputs[i] = Integer.parseInt(br.readLine());
        }
        // sort
        Arrays.sort(inputs);
        // answer
        int answer = -1;
        if(inputs[ALL_LINE_NUMBERS-1] < DIVIDED_NUMBER){
            answer = ALL_LINE_NUMBERS;
        }else if(inputs[ALL_LINE_NUMBERS-1])

    }
}
