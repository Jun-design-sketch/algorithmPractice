package array.array10813;

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
        // initial array: each element has number = index+1
        int[] arr = new int[n];
        for(int arrCnt=0; arrCnt<n; arrCnt++){
            arr[arrCnt] = arrCnt+1;
        }
        // exchange balls i <-> j
        for(int count=0; count<m; count++) {
            String[] eachLi = br.readLine().split(" ");
            int i = Integer.parseInt(eachLi[0]);
            int j = Integer.parseInt(eachLi[1]);
            //Note: 1<=i<=j<=n
            if_(i != j){
                int keepVal = arr[j-1];
                int keepVal2 = arr[i-1];
                arr[i-1] = keepVal;
                arr[j-1] = keepVal2;
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
