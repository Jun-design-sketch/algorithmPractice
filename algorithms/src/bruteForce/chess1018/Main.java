package bruteForce.chess1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// チェス用の板を作る
// 再度塗り直す四角形の最小数を求める
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nM = br.readLine().split(" ");
        // n: board height m: board width
        // 8<=n,m<=50
        int n = Integer.parseInt(nM[0]);
        int m = Integer.parseInt(nM[1]);
        // 2-dimension-array
        String[][] arr = new String[n][m];
        for(int i=0; i<n; i++){
            String[] eachLine = br.readLine().split("");
            for(int j=0; j<m; j++){
                arr[i][j] = eachLine[j];
            }
        }
        br.close();
        int[] answerArr = new int[(n-7)*(m-7)*2];
        int checkCounter = 0;
        for(int a=0; a<n-7; a++){
            for(int b=0; b<m-7; b++){
                // チェス板のパターン２つ
                // ①arr[0][0]をBにする場合：arr[0][7],arr[7][0]はW,arr[7][7]はB
                int check1 = 0;
                for(int i=a; i<a+8; i++){
                    for(int j=b;j<b+8; j++){
                        if(i%2==0){
                            if(j%2==0){
                                if(arr[i][j].equals("W")) check1++;
                            }else{
                                if(arr[i][j].equals("B")) check1++;
                            }
                        }else{
                            if(j%2==0){
                                if(arr[i][j].equals("B")) check1++;
                            }else{
                                if(arr[i][j].equals("W")) check1++;
                            }
                        }
                    }
                }
                answerArr[checkCounter] = check1;
                checkCounter++;
                // ②arr[0][0]をWにする場合：arr[0][7],arr[7][0]はB,arr[7][7]はW
                int check2 = 0;
                for(int i=a; i<a+8; i++){
                    for(int j=b;j<b+8; j++){
                        if(i%2==0){
                            if(j%2==0){
                                if(arr[i][j].equals("B")) check2++;
                            }else{
                                if(arr[i][j].equals("W")) check2++;
                            }
                        }else{
                            if(j%2==0){
                                if(arr[i][j].equals("W")) check2++;
                            }else{
                                if(arr[i][j].equals("B")) check2++;
                            }
                        }
                    }
                }
                answerArr[checkCounter] = check2;
                checkCounter++;
            }
        }
        Arrays.sort(answerArr);
        System.out.println(answerArr[0]);
    }
}
