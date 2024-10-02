package numberTheory.primeNumber4134;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Solution solution = new Solution();
        // solution.sol1();

    }
}

class Solution {
    protected void sol1() throws IOException {
        // 各ケースに対して、n以上のうち最小の素数を見つける。
        // nが素数であるかを見つける：n^(-2)まで引き算してみると確認が可能
        // もしnが素数でなければ、n = a * bだけど
        // 二つの掛け算で出来上がるので、最低の値はn^(-2)までになる。
        // 一つがn^(-2)より小さい場合だと、もう１つは必ずn^(-2)より大きくなる。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int target = Integer.parseInt(br.readLine());
            while(true){
                int limit = (int) Math.sqrt(target);
                boolean flg = false;
                for(int j=target-1; j>=limit; j--){
                    if(target % j == 0){
                        flg = false;
                        break;
                    }else{
                        flg = true;
                    }
                }
                if(flg){
                    sb.append(target+"\n");
                    break;
                }
                target++;
            }
        }
        br.close();
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}