package stackAndQueue.queueStack24511;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Solution solution = new Solution();
        // solution.sol1();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr2 = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            int element = Integer.parseInt(st2.nextToken());
            arr2[i] = element;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
        for(int j=0; j<n; j++){
            int element = Integer.parseInt(st3.nextToken());
            if(arr2[j]==0) deque.addFirst(element);
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr5 = new int[m];
        StringTokenizer st5 = new StringTokenizer(br.readLine(), " ");
        for(int k=0; k<m; k++){
            int element = Integer.parseInt(st5.nextToken());
            arr5[k] = element;
        }
        br.close();
        // stackは何個あっても結果に影響なし
        // queueが複数あるのなら、１つのqueueがあることと変わらない
        StringBuilder sb = new StringBuilder();
        for(int l=0; l<m; l++){
            deque.addLast(arr5[l]);
            sb.append(deque.pollFirst()+" ");
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}

class Solution {
    // 正解は出るけど時間超過した
    protected void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // queueStackの大きさ
        int n = Integer.parseInt(br.readLine());
        // 長さnの数列A
        int[] arr2 = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            int element = Integer.parseInt(st2.nextToken());
            arr2[i] = element;
        }
        // 長さnの数列B
        int[] arr3 = new int[n];
        StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
        for(int j=0; j<n; j++){
            int element = Integer.parseInt(st3.nextToken());
            arr3[j] = element;
        }
        // 挿入対象数列の長さm
        int m = Integer.parseInt(br.readLine());
        // 長さmの数列C
        int[] arr5 = new int[m];
        StringTokenizer st5 = new StringTokenizer(br.readLine(), " ");
        for(int k=0; k<m; k++){
            int element = Integer.parseInt(st5.nextToken());
            arr5[k] = element;
        }
        br.close();

        int answer;
        StringBuilder sb = new StringBuilder();
        for(int l=0; l<m; l++){
            answer = arr5[l];
            for(int p=0; p<n; p++){
                // queueの場合、FIFO。stackの場合、FILOのため変化なし
                if(arr2[p] == 0){
                    int tmp = answer;
                    answer = arr3[p];
                    arr3[p] = tmp;
                }
            }
            sb.append(answer+" ");
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
