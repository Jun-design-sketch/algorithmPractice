package setAndMap.intersection1764;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        // group1
        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }
        // group2
        TreeSet<String> set2 = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int j=0; j<m; j++){
            String member = br.readLine();
            if(set.contains(member)){
                set2.add(member);
                count++;
            }
        }
        br.close();
        // output
        sb.append(count+"\n");
        for(String member : set2){
            sb.append(member+"\n");
        }
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
