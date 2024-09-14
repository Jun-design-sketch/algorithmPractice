package setAndMap.member7785;

import java.io.*;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
//    4
//    Baha enter
//    Askar enter
//    Baha leave
//    Artem enter
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        // TreeSetに降順のcomparatorを提供する
        Comparator<String> comp = Comparator.reverseOrder();
        TreeSet<String> set = new TreeSet<>(comp);
        // Mapを使っても良いけど、enterしてleaveしていないユーザーだけ洗い出せば良い
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int inOrOut = st.nextToken().equals("enter") ? 1 : 0;
            if(inOrOut == 1){
                set.add(name);
            }else{
                set.remove(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String item : set) sb.append(item+"\n");
        sb.setLength(sb.length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
