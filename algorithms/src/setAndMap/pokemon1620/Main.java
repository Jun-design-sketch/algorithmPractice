package setAndMap.pokemon1620;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // n番までのポケモンを収集する
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        for(int i=1; i<=n; i++){
            String str= br.readLine();
            map1.put(String.valueOf(i), str);
            map2.put(str, String.valueOf(i));
        }
        // n+1~m列までの質問に回答する
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<m; j++){
            String question = br.readLine();
            // map1はキーが図鑑番号
            if(map1.containsKey(question)){
                sb.append(map1.get(question)+"\n");
            // map2はキーがポケモン名
            }else if(map2.containsKey(question)){
                sb.append(map2.get(question)+"\n");
            }
        }
        br.close();
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
