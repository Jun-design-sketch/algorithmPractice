package stackAndQueue.ps9012;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    // Parenthesis String, PS == '(' and ')'であるかを判別させる

    // 入力パターン
    // ①()()(), ((())) など＝プラマイゼロなので普通にempty
    // ②(()とかで、Stackが空ではない場合は!isEmpty
    // ③()))とかで、Stackが空になってからも続いてたらEmptyStackException e
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ball = 1;
        int n = Integer.parseInt(br.readLine());
        boolean exceptionChecker = false;

        for(int i=0; i<n; i++){
            Stack<Integer> stack = new Stack();
            String[] strArr = br.readLine().split("");

            try {
                for(int j=0; j< strArr.length; j++){
                        if (strArr[j].equals("(")) {
                            stack.add(ball);
                        } else {
                            stack.pop();
                        }
                }
            }catch(EmptyStackException e){
                exceptionChecker = true;
            }finally{
                if(exceptionChecker){
                    // ③
                    System.out.println("NO");
                }else{
                    if(stack.isEmpty()){
                        // ①
                        System.out.println("YES");
                    }else if(!stack.isEmpty()){
                        // ②
                        System.out.println("NO");
                    }
                }
                exceptionChecker = false;
            }
        }
        br.close();
    }
}
