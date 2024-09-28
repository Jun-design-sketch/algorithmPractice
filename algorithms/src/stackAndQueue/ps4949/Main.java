package stackAndQueue.ps4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 9012との違い
        // [(]) == no
        // [()] == yes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        boolean isException = false;
        String line;

        while((line = br.readLine()) != null){
            try {
                for (int i = 0; i < line.length(); i++) {
                    // charAtすれば、1文字単位の確認でsplit不要
                    if (line.charAt(i) == '(') {
                        stack.add('(');
                    } else if (line.charAt(i) == ')') {
                        if(stack.peek() == '(') stack.pop();
                        else break;
                    } else if (line.charAt(i) == '[') {
                        stack.add('[');
                    } else if (line.charAt(i) == ']') {
                        if(stack.peek() == '[') stack.pop();
                        else break;
                    } else if (line.charAt(i) == '.') {
                        break;
                    } else {
                        // (, ), [, ], .以外の文字列は処理不要
                    }
                }
            } catch (EmptyStackException e) {
                isException = true;
            } finally {
                if(isException){
                    System.out.println("no");
                }else{
                    if(stack.isEmpty()){
                        System.out.println("yes");
                    }else{
                        System.out.println("no");
                    }
                }

                isException = false;
                // 以前は再度インスタンス化していたけど、clearすればそうせずとも良い
                stack.clear();
            }
        }
    }
}
