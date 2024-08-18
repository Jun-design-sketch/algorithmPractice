package array.array10810;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLi = br.readLine().split(" ");
        // number of ball
        int n = Integer.parseInt(firstLi[0]);
        // number of command(lines)
        int m = Integer.parseInt(firstLi[1]);
        int[] arr = new int[n];

        for(int count=0; count<m; count++){
            String[] eachLi = br.readLine().split(" ");
            // input ball from position i
            int i = Integer.parseInt(eachLi[0]);
            // input ball to position j
            int j = Integer.parseInt(eachLi[1]);
            // input ball has written number: k
            int k = Integer.parseInt(eachLi[2]);
            // input process
            if_(i == j){
                // input ball written 'k', only position i-1
                arr[i-1] = k;
            }else{
                // input ball written 'k', between position i ~ j
                int diff = j-i;
                for(int l=0; l<=diff; l++){
                    arr[i-1+l] = k;
                }
            }
        }
        // write down answer
        StringBuilder sb = new StringBuilder();
        for(int x=0; x<arr.length; x++){
            sb.append(arr[x]);
            if_(x < arr.length-1){
                sb.append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
