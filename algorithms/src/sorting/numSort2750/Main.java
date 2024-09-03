package sorting.numSort2750;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Test test = new Test();
//        test.sol1();
        test.sol2();
    }
}

class Test {
    protected void sol2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        // Arraysを使わず手動で整列してみよう
        int[] manualArr = new int[n];
        int target=Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            for(int m=0; m<n; m++){
                if(arr[m]==target){
                    arr[m]=Integer.MAX_VALUE;
                    target=Integer.MAX_VALUE;
                }
            }
            for(int k=0; k<n; k++){
                if(target>arr[k]){
                    target=arr[k];
                }
            }
            manualArr[j]=target;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(manualArr[i]);
            if(i!=n-1){
                sb.append("\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    protected void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(arr);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<n; j++){
            sb.append(arr[j]);
            if(j!=n-1){
                sb.append("\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
