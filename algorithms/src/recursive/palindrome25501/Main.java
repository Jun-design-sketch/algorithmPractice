package recursive.palindrome25501;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 与えられた再帰的関数の呼び出し回数・判定結果を求めよ
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            String test = br.readLine();
            int count = 0;
            int flg = 1;
            int half = test.length() / 2;
            for(int j=0; j<=half; j++){
                count++;
                int otherSide = test.length() - 1;
                if(test.charAt(j) != test.charAt(otherSide-j)){
                    flg = 0;
                    break;
                }
            }
            sb.append(flg+" "+count+"\n");
        }
        br.close();
        sb.setLength(sb.length()-1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int recursion(String s, int l, int r) {
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }
}