package shape.triangle10101;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 3つの角度をinputとして貰う
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        if(arr[0]+arr[1]+arr[2]!=180){
            bw.write("Error");
        }else if(arr[0]!=arr[1] && arr[0]!=arr[2] && arr[1]!=arr[2]){
            bw.write("Scalene");
        }else if(arr[0]==arr[1] && arr[0]==arr[2] && arr[1]==arr[2]){
            bw.write("Equilateral");
        }else{
            bw.write("Isosceles");
        }
        bw.flush();
        bw.close();
    }
}
