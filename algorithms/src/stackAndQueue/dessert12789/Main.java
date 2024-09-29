package stackAndQueue.dessert12789;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    // 6
    // 6 2 1 3 4 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int correctOrder = 1;

        for(int i=0; i<n; i++){
            if(!stack.isEmpty() && stack.peek() == correctOrder){
                // 正しい順番が来ていたら、通過し次の数字になる。
                stack.pop();
            }else{
                // 正しい順番が来るまではstackに格納しておく
                int x;
                while(st.hasMoreTokens() && (x = Integer.parseInt(st.nextToken())) != correctOrder){
                    stack.add(x);
                }
            }
            correctOrder++;
        }
        br.close();
        // 結果出力
        if(stack.isEmpty()) bw.write("Nice");
        else bw.write("Sad");
        bw.flush();
        bw.close();
    }
}
