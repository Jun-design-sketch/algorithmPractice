package shape.land9063;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int minX = 0,minY = 0,maxX = 0,maxY = 0;
        // 初めの1回から初期値を設定しておく
        String[] strArr = br.readLine().split(" ");
        int x = Integer.parseInt(strArr[0]);
        int y = Integer.parseInt(strArr[1]);
        minX = x;
        maxX = x;
        minY = y;
        maxY = y;

        for(int i=0; i<n-1; i++){
            strArr = br.readLine().split(" ");
            x = Integer.parseInt(strArr[0]);
            y = Integer.parseInt(strArr[1]);
            if(x < minX) minX = x;
            if(x > maxX) maxX = x;
            if(y < minY) minY = y;
            if(y > maxY) maxY = y;
        }
        br.close();
        int answer = (maxX-minX)*(maxY-minY);
        bw.write(""+answer);
        bw.flush();
        bw.close();
    }
}
