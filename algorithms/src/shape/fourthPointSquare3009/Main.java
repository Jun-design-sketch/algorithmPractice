package shape.fourthPointSquare3009;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // ３つの点の座標が与えられる。軸に並行した４つ目の点を求めよ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[6];
        // ３つの点の座標を取ってみる。for文でやってみた
        for(int i=0; i<6; i+=2){
            String[] strArr = br.readLine().split(" ");
            arr[i] = Integer.parseInt(strArr[0]);
            arr[i+1] = Integer.parseInt(strArr[1]);
        }
        br.close();
        // 各値が２つづつある中、１つしかない２つを求めると完了
        int x = 0;
        int y = 0;
        if(arr[0] == arr[2]) x = arr[4];
        if(arr[0] == arr[4]) x = arr[2];
        if(arr[2] == arr[4]) x = arr[0];
        if(arr[1] == arr[3]) y = arr[5];
        if(arr[1] == arr[5]) y = arr[3];
        if(arr[3] == arr[5]) y = arr[1];
        bw.write("" + x + " " + y);
        bw.flush();
        bw.close();
    }
}
