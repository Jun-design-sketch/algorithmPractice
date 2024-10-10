package deepening2.words20920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<String, Integer> map = new TreeMap<>();

        // 3つのソートを行う
        // 登場回数が多ければ先に出す、単語の文字数が長ければ先に出す、アルファベット順(a~)
        // 優先順位が高いものを最後にソートする
        for(int i=0; i<n; i++){
            String word = br.readLine();
            if(word.length() >= m) map.merge(word, 1, Integer::sum);
        }
        br.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getKey().length() - o1.getKey().length();
            }
        });

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int j=0; j<list.size();j++){
            sb.append(list.get(j).getKey()+"\n");
        }
        sb.setLength(sb.length()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}