package stackAndQueue.card2164;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        // n個のカードがある。
        // カードは1~nまでの番号がついている。1番が一番上。n番が一番下。
        // 一番上にあるカードを捨てる。
        // 残りのうち一番上にあるカードを、一番下に移動させる。
        // これを繰り返した時、残るカード１枚を求めよ。

        // 最前と最後を入れ替える作業なので、dequeが適切そう
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();
        Deque<Integer> deque = new LinkedList<>();
        for(int i=1; i<=n; i++){
            deque.offerLast(i);
        }

        if(n > 1){
            while(true){
                deque.pop();
                if(deque.size() == 1) break;
                int out = deque.removeFirst();
                deque.addLast(out);
            }
        }
        int answer = deque.pop();
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
