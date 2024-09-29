package stackAndQueue.JosephusProblem11866;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();

        // Queue初期化：n個の要素を持つ状態
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        //  m番目の人を除外することをn回繰り返す
        for(int j=1; j<=n*m; j++){
            if(j % m != 0){
                queue.add(queue.poll());
            }else{
                sb.append(queue.poll()+", ");
            }
        }
        sb.setLength(sb.length()-2);
        sb.append(">");

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}