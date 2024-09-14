package setAndMap.numberCard10816;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // カードを何枚持っているか？
        // 数字がキー、枚数が値であるHashMapで解ける。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<Integer, Integer> map = new HashMap<>();
        // 番号と枚数を収集
        for(int i=0; i<n; i++){
            int el = Integer.parseInt(st.nextToken());
            if(!map.containsKey(el)){
                map.put(el, 1);
            }else{
                map.replace(el, map.get(el)+1);
            }
        }
        // 与えられる番号を何枚持っているか返す
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<m; j++){
            int el = Integer.parseInt(st2.nextToken());
            if(map.containsKey(el)){
                sb.append(map.get(el)+" ");
            }else{
                sb.append("0 ");
            }
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
