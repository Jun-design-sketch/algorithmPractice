package array.arrayFindMax;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // input: each line has number, 9 lines
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // find maximum value
        int max = 0;
        int[] arr = new int[9];
        for(int i=0; i<9; i++){
            int el = Integer.parseInt(br.readLine());
            max = el > max ? el : max;
            arr[i] = el;
        }
        // find position
        int times = 0;
        for(int j=0; j<9; j++){
            times += 1;
            if(arr[j] == max){
                break;
            }
        }

        bw.write(""+max+"\n"+ times+"\n");
        bw.flush();
        bw.close();
    }
}
