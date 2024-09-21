package stackAndQueue.zero10773;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        // 最後に書いた数を消すか、新しく数字を書くか -> stack
        Stack<Integer> stack = new Stack<>();
        // 数字の合計は2^31-1以下なので、intで十分
        for(int i=0; i<k; i++){
            int c = Integer.parseInt(br.readLine());
            if(c == 0) stack.pop();
            else stack.add(c);
        }
        br.close();

        int answer = 0;
        for(Integer el : stack){
            answer += el;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
