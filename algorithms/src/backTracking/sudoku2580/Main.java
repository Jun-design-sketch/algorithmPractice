package backTracking.sudoku2580;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 9*9のsudoku板の空欄を埋めて出力せよ
    // 空欄には0が与えられる。

    // 各列や行で数字が重複してはならない。
    // また、3*3の四角形の中でも数字が重複してはならない。

    // 1つ目の四角形から考える。。。
    // まずは行を確認する：arr[0][i]と1~9を比較する
    // 続いて列を確認する：arr[i][0]と1~9を比較する
    // そして3*3の四角形で重複を検査する。。

//    0 3 5 4 6 9 2 7 8
//    7 8 2 1 0 5 6 0 9
//    0 6 0 2 7 8 1 3 5
//    3 2 1 0 4 6 8 9 7
//    8 0 4 9 1 3 5 0 6
//    5 9 6 8 2 0 4 1 3
//    9 1 7 6 5 2 0 8 0
//    6 0 3 7 0 1 9 5 2
//    2 5 8 3 9 4 7 6 0
    static public int[][] arr;
    static public BufferedReader br;
    static public BufferedWriter bw;
    static public StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        arr = new int[9][9];
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        sudokuTT(0, 0);
    }

    public static void sudokuTT(int row, int col) throws IOException {
        // 行がいっぱいであれば、次の列の最初から開始する
        if(col==9) {
            sudokuTT(row+1, 0);
            return;
        }
        // 行と列が全て満タンなら出力して終了する
        if(row==9) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(arr[i][j]+" ");
                }
                sb.append("\n");
            }
            sb.setLength(sb.length()-1);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            System.exit(0);
        }
        // 0があれば、どの値を入れられるかを探索する
        if(arr[row][col] == 0) {
            for(int i=1; i<10; i++){
                // 埋められるのであれば埋めて、次へ進む
                if(possibility(row,col,i)){
                    arr[row][col] = i;
                    sudokuTT(row,col+1);
                    // 正しい値が入って次へずっと進んでいるのであれば、ここの外へ出ることはない
                    // ずっと埋めて行ってSystem.exit(0)するから
                }
            }
            // つまりここに来た時は入れたarr[row][col]の値が間違っていた時。。
            // 間違った値で進んだ場合、空欄に戻しreturnする　ここが難しい。。
            arr[row][col] = 0;
            return;
        }
        sudokuTT(row, col+1);
    }

    public static boolean possibility(int row, int col, int value) {
        // row列にvalueが存在するか
        for(int i=0; i<9; i++) {
            if(arr[row][i] == value) {
                return false;
            }
        }

        // col行にvalueが存在するか
        for(int i=0; i<9; i++) {
            if(arr[i][col] == value){
                return false;
            }
        }

        // 3*3四角形にvalueが存在するか
        int initY = (row/3)*3;
        int initX = (col/3)*3;
        for(int i=initY; i<initY+3; i++){
            for(int j=initX; j<initX+3; j++){
                if(arr[i][j] == value){
                    return false;
                }
            }
        }

        return true;
    }
}
