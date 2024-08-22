package twoDimensionalArray.read10798;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[][] arr = new String[5][15];
        for(int i=0; i<5; i++){
            String[] strArr = br.readLine().split("");
            for(int j=0; j<15; j++){
                arr[i][j] = j<strArr.length ? strArr[j] : "";
            }
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for(int k=0; k<15; k++){
            for(int l=0; l<5; l++){
                sb.append(arr[l][k]);
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
