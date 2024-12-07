package dynamicProgramming.tile1904;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        br.close();

        // ここで、あれが必要だ。。。
        // 場合分けを格納するデータ構造は何にすれば良いか
        // int[]..
        // 2種類のブロックでN個を埋める...

        int result = counter(n);
        int answer = result % 15746;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    // n桁の２進数において重複を除いた場合何通りあるか
    // 1, 00のみ使用可能
    //
    public static int counter(int n) {
        // 再帰呼び出しする＋実行結果を保存する
        // 再帰。。。。。。。。。
        return 0;
    }
}
