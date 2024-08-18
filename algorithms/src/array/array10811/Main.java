package array.array10811;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // firstLine have n(bucketNumber.size()) and m(number of second~lastLine)
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        // make array
        int[] arr = new int[n];
        int init = 1;
        for(int i=0; i<n; i++){
            arr[i] = init;
            init++;
        }

        // secondLine~LastLine
        Main main = new Main();
        for(int j=0; j<m; j++){
            String[] eachLine = br.readLine().split(" ");
            int x = Integer.parseInt(eachLine[0])-1;
            int y = Integer.parseInt(eachLine[1])-1;
            main.reverseArray(arr, x, y);
        }

        // return answer
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<arr.length; k++){
            sb.append(arr[k]);
            if_(k != arr.length-1){
                sb.append(" ");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private void reverseArray(int[] array, int start, int end) {
        // condition to end
        if_ (start >= end) {
            return;
        }
        // exchange between first and last
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;

        // keep going
        reverseArray(array, start+1, end-1);
    }
}
