package stackAndQueue.ballon2346;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        // 最初dequeの状態
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            deque.addLast(Integer.parseInt(st.nextToken()));
        }

        // 1回目は最初の風船を確認する
        int position = 1;
        sb.append(position+" ");
        // 2回目から
        int paperNum = deque.pollFirst();
        for(int i=0; i<n-1; i++){
            position += paperNum;
            sb.append(position+" ");
            if(paperNum>0){
                for(int j=0; j<paperNum-1; j++){
                    deque.addLast(deque.pollFirst());
                }
                paperNum = deque.pollFirst();
            }else {
                for (int j = 0; j < paperNum-1; j++) {
                    deque.addFirst(deque.pollLast());
                }
                paperNum = deque.pollLast();
            }
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
