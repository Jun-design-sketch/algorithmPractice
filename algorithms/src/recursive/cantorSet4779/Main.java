package recursive.cantorSet4779;

import java.io.*;

public class Main {
    // カントール集合
    // ０と１の間にある実数で構成される集合
    // [0,1]から始め、各区間を３等分し真ん中を除外することを繰り返していく。
    // 全体集合が有限である時、カントール集合と似たものを作ってみよう
    public static int[] arr;
    public static int head;
    public static int tail;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = (int) Math.pow(3, Integer.parseInt(br.readLine()));
        br.close();
        arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i] = 1;
        }

        head = 0;
        tail = arr.length-1;
        doCantorHead(head, tail);
        doCantorTail(head, tail);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++){
            if(arr[i] == 1) sb.append("-");
            else sb.append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    // 0,1,2,3,4,5,6,7,8
    // 真ん中は3,4,5
    // (0+8) == length
    // 8 / 3 = 2;
    // 8 / 3 , * 2 = 4;

    // TODO: 再帰的実行を頭と尻尾で分けてしまうとあいだにある頭と尻尾はちゃんと再帰実行されず、一つの関数にまとめないと正常動作しない
    public static void doCantorHead(int partHead, int partTail) {
        int middleLeft = ((partTail-partHead+1) / 3) * 1;
        int middleRight = ((partTail-partHead+1) / 3) * 2;
        if(middleLeft == middleRight) return;
        for(int i=middleLeft; i<middleRight; i++){
            arr[i] = -1;
        }
        doCantorHead(head, middleLeft);
    }

    public static void doCantorTail(int partHead, int partTail) {
        int middleLeft = ((partTail-partHead+1) / 3) * 1 + partHead;
        int middleRight = ((partTail-partHead+1) / 3) * 2 + partHead;
        if(middleLeft == middleRight) return;
        for(int i=middleLeft; i<middleRight; i++){
            arr[i] = -1;
        }
        doCantorTail(middleRight, tail);
    }
}
