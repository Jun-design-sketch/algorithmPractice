package setAndMap.setDiff1269;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        // 対称差を求める。
        // setを２つ用意して解いてみる
        // 2次元配列でもいけそうだけど、値の範囲が大きくなるケースを考えるとsetが安全そう
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            set1.add(Integer.parseInt(st2.nextToken()));
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
        for(int j=0; j<m; j++){
            int el = Integer.parseInt(st3.nextToken());
            if(!set1.contains(el)){
                set2.add(el);
            }else{
                set1.remove(el);
            }
        }
        br.close();

        // 特にpredicate使わなくてもいける
        // Predicate<Integer> predicate1 = el -> set2.contains(el);
        // set1.removeIf(predicate1);

        int answer = set1.size()+set2.size();
        bw.write(""+answer);
        bw.flush();
        bw.close();
    }
}