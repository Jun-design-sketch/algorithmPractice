package setAndMap.stringSet14425;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] firstLi = br.readLine().split(" ");
        int n = Integer.parseInt(firstLi[0]);
        int m = Integer.parseInt(firstLi[1]);
        // 持っている文字列集合
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }
        // 検査する文字列集合
        int ans = 0;
        for(int j=0; j<m; j++){
            if(set.contains(br.readLine())) ans++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
