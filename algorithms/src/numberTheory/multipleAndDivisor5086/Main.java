package numberTheory.multipleAndDivisor5086;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        String[] arr;
        while((str = br.readLine()) != null){
            arr = str.split(" ");
            int a = Integer.parseInt(arr[0]);
            if(a==0) break;
            int b = Integer.parseInt(arr[1]);
            boolean factor = b%a == 0; // aはbの約数
            boolean multiple = a%b == 0; // aはbの倍数
            if(factor) bw.write("factor"+"\n");
            else if(multiple) bw.write("multiple"+"\n");
            else bw.write("neither"+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
