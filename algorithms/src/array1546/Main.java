package array1546;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // firstLine: 0 < N <= 1000 // N == size of secondLine
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        // secondLine: numbers
        String[] strArr = br.readLine().split(" ");
        int originalSum = 0;
        for(int i=0; i<n; i++){
            // each score  0 < j <= 100
            int j = Integer.parseInt(strArr[i]);
            originalSum += j;
            arr[i] = j;
        }
        // sort to get Maximum
        Arrays.sort(arr);
        int max = arr[n-1];
        // calculate new average: originalScore / max * 100
        // int answer = ((originalSum * 100 / max)) / n;
        // ((originalSum * 100 / max)) / n == (originalSum * 100) / max * n;
        BigDecimal el1 = new BigDecimal(originalSum*100);
        BigDecimal el2 = new BigDecimal(max*n);
        // The error should smaller than 10^-2(0.01)
        // precision setting: max could be 3digits, 2decimal places, precision should be 5
        BigDecimal result = el1
                        .divide(el2, new MathContext(5, RoundingMode.HALF_UP));
        bw.write(""+result);
        bw.flush();
        bw.close();
    }
}
