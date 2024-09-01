package bruteForce.math19532;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        br.close();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        // -999 <= a,b,c,d,e,f,x,y <= 999
        // ax+by=c
        // dx+ey=f
        int answerX = 0;
        int answerY = 0;
        for(int x=-999; x<1000; x++){
            for(int y=-999; y<1000; y++){
                if(a*x+b*y==c && d*x+e*y==f){
                    answerX = x;
                    answerY = y;
                    break;
                }
            }
        }
        System.out.println(answerX+" "+answerY);
    }
}
