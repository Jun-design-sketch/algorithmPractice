package shape.triangle5073;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while((str = br.readLine()) != null){
            if(str.equals("0 0 0")) break;
            String[] strArr = str.split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            int c = Integer.parseInt(strArr[2]);
            int max = Integer.max(a,Integer.max(b,c));
            if(max*2 >= a+b+c){
                bw.write("Invalid\n");
            }else if(a==b && b==c){
                bw.write("Equilateral\n");
            }else if(a!=b && b!=c && c!=a){
                bw.write("Scalene\n");
            }else{
                bw.write("Isosceles\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
