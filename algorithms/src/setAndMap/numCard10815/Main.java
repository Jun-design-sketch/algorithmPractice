package setAndMap.numCard10815;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    // 5
    // 6 3 2 10 -10
    // 8
    // 10 9 -5 2 3 4 5 -10
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 持っているカードの数
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 持っているカード
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        // 持ってるか問われるカードの数
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        // 持ってるか問われるカード
        for(int i=0; i<m; i++){
            if(set.contains(Integer.parseInt(st2.nextToken()))){
                sb.append("1 ");
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
