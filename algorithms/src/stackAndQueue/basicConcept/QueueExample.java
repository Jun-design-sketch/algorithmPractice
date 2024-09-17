package stackAndQueue.basicConcept;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // JavaでQueueはLinkedListを使用して具現する
        Queue<Integer> queue = new LinkedList<>();

        // 追加
        queue.offer(1);
        queue.offer(100);
        queue.offer(2);
        queue.offer(99);

        // 削除
        System.out.println("Poll out " + queue.poll()); // 入れた順番通り出てくるから1だ

        // 確認
        System.out.println("Peek? see " + queue.peek()); // ものに影響を与えない。次に出てくるものが分かる

        // 入れた順番通りに出てくるということは
        // 入り口(Enqueue) -> back ... front -> 出口(Dequeue)
        // 常に最後尾にものをつけ、最前にあるものがなくなる（出てくる）という言葉に等しい
        // 作業の順番を維持することが容易だ。
        // 大きさの調整が簡単だ。-> 配列はちょっと面倒だけどキューは入れず出せば減る
        // 多重アクセス発生時、Queueに入れておいて順番に処理できる。

        // ただ探索には向いていない。
        // 1 -> 2 -> 3 -> 4 ...
        // LinkedListなので、要素個々がLinkされている
        // 3が欲しければ3とLinkしている2か4まで辿らないといけない
        // 探索したいのならTreeがいい。。
    }
}
