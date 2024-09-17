package stackAndQueue.Queue18258;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if(st.countTokens() == 2){
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());
                if(command.equals("push")) {
                    deque.offerFirst(number);
                }
            }else{
                String command = st.nextToken();
                if(command.equals("pop")){
                    sb.append(deque.peekFirst() == null ? -1 : deque.pollLast());
                    sb.append("\n");
                }else if(command.equals("size")){
                    sb.append(deque.size());
                    sb.append("\n");
                }else if(command.equals("empty")){
                    sb.append(deque.isEmpty() ? 1 : 0);
                    sb.append("\n");
                }else if(command.equals("front")){
                    sb.append(deque.peekLast() == null ? -1 : deque.peekLast());
                    sb.append("\n");
                }else{
                    sb.append(deque.peekFirst() == null ? -1 : deque.peekFirst());
                    sb.append("\n");
                }
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
