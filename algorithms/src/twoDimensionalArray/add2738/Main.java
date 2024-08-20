package twoDimensionalArray.add2738;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.firstSolution();
//        solution.secondSolution();
    }
}
class Solution {
    // 2次元配列を使うと直観的で分かりやすいけれど、メモリ消費量は多くなる
    // Scannerもそうだけど。。
    protected void secondSolution() throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // height 行
        int b = sc.nextInt(); // width 列
        int[][] arr = new int[a][b]; // metrix[height][width] == だから行列ね

        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                arr[i][j] += sc.nextInt();
                sb.append(arr[i][j]);
                if(j != b-1){
                    sb.append(" ");
                }else{
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
    // １次元配列だから平らにして１次元配列で計算し、後から改行させた
    protected void firstSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] firstArr = br.readLine().split(" ");
        int height = Integer.parseInt(firstArr[0]);
        int width = Integer.parseInt(firstArr[1]);
        int[] arr1 = new int[width*height];
        int index1 = 0;
        for(int i=1; i<=height; i++){
            String[] eachLine = br.readLine().split(" ");
            for(int j=1; j<=width; j++){
                arr1[index1] = Integer.parseInt(eachLine[j-1]);
                index1++;
            }
        }
        int[] arr2 = new int[width*height];
        int index2 = 0;
        for(int i=1; i<=height; i++){
            String[] eachLine = br.readLine().split(" ");
            for(int j=1; j<=width; j++){
                arr2[index2] = Integer.parseInt(eachLine[j-1]);
                index2++;
            }
        }
        br.close();
        StringBuilder sb = new StringBuilder();
        int index3 = 0;
        for(int i=1; i<=height; i++){
            for(int j=1; j<=width; j++){
                int add = arr1[index3]+arr2[index3];
                index3++;
                sb.append(add);
                if(j != width){
                    sb.append(" ");
                }else{
                    sb.append("\n");
                }
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
