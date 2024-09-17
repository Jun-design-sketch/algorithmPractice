package stackAndQueue.basicConcept;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Stack: 基本的な積み重ね。積み重ねたら、最後に入れたものが一番上になる
        // なので、引き出す時も最後に入れたものが最初にでてくる。
        // これをLIFO(Last In, First out)という
        // Stack > Queue > Dequeの順で発達していく印象がある

        // Stack<T> [name] = new Stack<>();
        // TはclassまたはwrapperClass
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(3);

        System.out.println("position of 5 " + stack.search(5));
        // positionというより、出てくる順番があとどれくらいかを指す

        System.out.println("pop " + stack.pop());
        System.out.println("see top " + stack.peek()); // peekは、ただ見るだけ
        System.out.println("pop " + stack.pop());

        System.out.println("Is empty: " + stack.isEmpty());

        //　遂行したものの逆順を求める時？
        //　ブラウザの「戻る」？ undo/redo
    }
}
