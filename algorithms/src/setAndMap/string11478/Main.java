package setAndMap.string11478;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        Sol sol = new Sol();
        // sol.one();
        sol.two();
    }
}

class Sol {
    protected void two() throws IOException {
        // 文字列を配列にせずに切ってしまえば、とは思ったけど
        // substring(start, end)を使うまで発想が届かなかった
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String original = br.readLine();
        br.close();
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<original.length(); i++){
            for(int j=i+1; j<=original.length(); j++){
                set.add(original.substring(i,j));
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }
    protected void one() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split("");
        br.close();

        // setは重複したものを許容しないからそのまま入れれば良いが、
        HashSet<String> set = new HashSet<>();
        for(int i=1; i<=arr.length; i++){
            // iが０の時は文字列はnull。
            // iが１の時、1文字をindex単位でチャチャっと
            // iが２の時は、2文字を（同上）
            // ... iが５の時まで。
            int charCount = i;
            int index = 0;
            while(index < arr.length){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<charCount; j++){
                    if(index+j < arr.length) sb.append(arr[index+j]);
                }
                set.add(String.valueOf(sb));
                index++;
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }
}
