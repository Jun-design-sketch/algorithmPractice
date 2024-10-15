package recursive.cantorSet4779;

import java.io.*;

public class Main {
    // カントール集合
    // ０と１の間にある実数で構成される集合
    // [0,1]から始め、各区間を３等分し真ん中を除外することを繰り返していく。
    // 全体集合が有限である時、カントール集合と似たものを作ってみよう
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line;
        while((line=br.readLine()) != null){
            int length = (int) Math.pow(3, Integer.parseInt(line));
            arr = new int[length];
            for(int i=0; i<length; i++){
                arr[i] = 1;
            }

            doCantor(0, arr.length);

            for(int i=0; i<length; i++){
                if(arr[i] == 1) sb.append("-");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void doCantor(int start, int size) {
        if(size==1) return;

        int newSize = size/3;
        for(int i=start+newSize; i<start+2*newSize; i++){
            arr[i] = 0;
        }

        doCantor(start, newSize);
        doCantor(start+2*newSize, newSize);
    }
}
