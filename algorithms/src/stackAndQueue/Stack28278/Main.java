package stackAndQueue.Stack28278;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if(st.hasMoreTokens()){
                int number = Integer.parseInt(st.nextToken());
                stack.push(number);
            }else{
                if(command == 2) System.out.println(stack.isEmpty() ? -1 : stack.pop());
                else if(command == 3) System.out.println(stack.size());
                else if(command == 4) System.out.println(stack.isEmpty() ? 1 : 0);
                else System.out.println(stack.isEmpty() ? -1 : stack.peek());
            }
        }
    }
}
