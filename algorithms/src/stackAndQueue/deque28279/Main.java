package stackAndQueue.deque28279;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());

                switch (command){
                    case 1:
                        int number1 = Integer.parseInt(st.nextToken());
                        deque.offerFirst(number1);
                        break;
                    case 2:
                        int number2 = Integer.parseInt(st.nextToken());
                        deque.offerLast(number2);
                        break;
                    case 3:
                        System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
                        break;
                    case 4:
                        System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
                        break;
                    case 5:
                        System.out.println(deque.size());
                        break;
                    case 6:
                        System.out.println(deque.isEmpty() ? 1 : 0);
                        break;
                    case 7:
                        System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                        break;
                    case 8:
                        System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
                        break;
                    default:
                        break;
                }
            }
        br.close();
    }
}
