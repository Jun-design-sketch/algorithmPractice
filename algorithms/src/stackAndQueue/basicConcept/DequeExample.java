package stackAndQueue.basicConcept;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeExample {
    public static void main(String[] args) {
        // Dequeは Double-ended-queue。
        // 両端でデータを追加もしくは削除できる。
        // StackとQueueの機能を両方揃っている。
        //

        Deque<Integer> deque = new ArrayDeque<>();

        // 前に追加
        deque.offerFirst(1);
        deque.offerFirst(2);
        // 後ろに追加
        deque.offerLast(100);

        // 前と後ろから覗いてみる
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        // 前から引っ張り出す
        System.out.println(deque.pollFirst());

        // size
        System.out.println(deque.size());

        // 後ろから引っ張り出す
        System.out.println(deque.pollLast());

        // でもこれならLinkedListでもできそう
        Deque<Integer> deque2 = new LinkedList<>();
        deque2.offerFirst(10);
        deque2.offerFirst(11);
        deque2.offerLast(20);
        System.out.println(deque2.size());
        for(Integer el : deque2){
            System.out.println(el);
        }

        // DequeはQueueを相続したインタフェース。
        // public interface Deque<E> extends Queue<E> {
        // Queueは？ Collectionを相続したインタフェース。
        // public interface Queue<E> extends Collection<E> {

        // Collectionもインタフェースだから、結局これらは一つの概念もしくはBluePrintになる
        // だからDequeやQueueの具現はLinkedListやArrayDequeなどのClassで行われる

        // Stack？ Vector相続。Java1.0からあったもので、2からCollectionが登場
        // public class Stack<E> extends Vector<E> {

    }
}
