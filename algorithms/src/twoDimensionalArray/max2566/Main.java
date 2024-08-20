package twoDimensionalArray.max2566;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[9][9];
        int max = -1;

        // input is 2-dimensional array 9*9
        for(int i=0; i<9; i++){
            String[] eachLine = br.readLine().split(" ");
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(eachLine[j]);
                if(arr[i][j] > max){
                    max = arr[i][j];
                }
            }
        }
        br.close();

        // where is max value?
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(arr[i][j] == max){
                    bw.write(""+max+"\n"+(i+1)+" "+(j+1));
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
    }
}
