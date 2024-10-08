package deepening2.rabbit26069;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static final String keyPerson = "ChongChong";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        set.add(keyPerson);

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String leftMan = st.nextToken();
            String rightMan = st.nextToken();
            if(set.contains(leftMan) || set.contains(rightMan)) {
                set.add(leftMan);
                set.add(rightMan);
            }
        }
        br.close();

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }
}
