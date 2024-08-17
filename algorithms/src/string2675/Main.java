package string2675;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        // numberOfTestCase
        int caseNum = Integer.parseInt(br.readLine());
        // each case?
        for(int eachCase=0; eachCase<caseNum; eachCase++){
            String[] strArr = br.readLine().split(" ");
            int iterateNum = Integer.parseInt(strArr[0]);
            String[] target = strArr[1].split("");
            // each word?
            for(int eachWord=0; eachWord<target.length; eachWord++){
                // repeat process
                for(int ite=0; ite<iterateNum; ite++){
                    sb.append(target[eachWord]);
                }
            }
            // each case done
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));
        br.close();
        bw.flush();
        bw.close();
    }
}
