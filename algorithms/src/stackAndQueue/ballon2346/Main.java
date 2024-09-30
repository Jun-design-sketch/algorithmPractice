package stackAndQueue.ballon2346;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> dequeNum = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            deque.addLast(Integer.parseInt(st.nextToken()));
            dequeNum.addLast(i);
        }
        // paperValは紙の値、balloonPosは風船の位置
        int paperVal = deque.pollFirst();
        int balloonPos = dequeNum.pollFirst();
        sb.append(balloonPos+" ");

        for(int i=0; i<n-1; i++){
            if(paperVal>0){
                for(int j=1; j<=paperVal-1; j++){
                    deque.addLast(deque.pollFirst());
                    dequeNum.addLast(dequeNum.pollFirst());
                }
                paperVal = deque.pollFirst();
                balloonPos = dequeNum.pollFirst();
            }else {
                for (int j=-1; j>=paperVal+1; j--) {
                    deque.addFirst(deque.pollLast());
                    dequeNum.addFirst(dequeNum.pollLast());
                }
                paperVal = deque.pollLast();
                balloonPos = dequeNum.pollLast();
            }
            sb.append(balloonPos+" ");
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
